package org.zxs.leader.control.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.UnpushMsgOut;
import org.zxs.leader.control.dao.model.vo.output.UnreadMsgOut;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IChatGroupMsgService;
import org.zxs.leader.control.service.interf.IChatGroupUserService;
import org.zxs.leader.control.service.interf.IMsgStatusService;
import org.zxs.leader.control.service.interf.ITopicUnreadService;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.BroadcastAckCallback;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

/**
 * 启动socketio server
 * @author Administrator
 *
 */
@Component("ackChatLaunch")
public class AckChatLaunch implements ApplicationListener<ContextRefreshedEvent> {
	private static final Log log = LogFactory.getLog(AckChatLaunch.class);
	private Map<UUID, Integer> unreadMap = new HashMap<>();
	private Map<SocketIOClient, Integer> unpushMap = new HashMap<>();

	@Resource
	private SocketIOServer server;
	
	@Resource
	private IChatGroupInfoService cgInfoService;
	
	@Resource
	private IChatGroupMsgService cgMsgService;
	
	@Resource
	private IMsgStatusService msgStatusService;
	
	@Resource
	private IChatGroupUserService cgUserService;
	
	@Resource
	private ITopicUnreadService topicUnreadService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		if (evt.getApplicationContext().getParent() != null) {
			log.info("SocketIOServer服务启动!");
			unreadMap.clear();
			unpushMap.clear();
			server.start();
			
			List<ChatGroupInfo> cgList = cgInfoService.getAllChatGroup();
			// 为每一个聊天群开启监听
			if(null != cgList && !cgList.isEmpty()) {
				log.info("需要添加的聊天室监听数为：" + cgList.size());
				for(ChatGroupInfo cgInfo : cgList) {
					addMsgEventListener(cgInfo);
				}
			}
			
			server.addJsonObjectListener(UnreadMsgOut.class, new DataListener<UnreadMsgOut>() {
	            @Override
	            public void onData(SocketIOClient client, UnreadMsgOut data, AckRequest ackRequest) {
	            	if(client.isChannelOpen()) {
	            		UUID currentSessionId = client.getSessionId();
	            		if(data != null) {
		    				Integer userId = data.getUserId();
		    				if(null != userId) {
		    					log.info("添加服务器端未读消息监听！sessionId为：" + currentSessionId + ",userId为：" + userId);
		    					unreadMap.put(currentSessionId, userId);
		    					notifyUnreadMsg(client, userId);
		    				}else{
		            			log.warn("客户端未发送用户信息！");
		            		}
							
	            		}else {
	            			log.warn("客户端发送的数据信息为空！");
	            		}
	                	
	            	}else {
	            		log.warn("客户端消息渠道未打开！");
	            	}
	            }
	        });
			
			String unpushRoom = "/push";
			if(server.getNamespace(unpushRoom) == null) { // 聊天室未被监听
				final SocketIONamespace unpushRoomNamespace = server.addNamespace(unpushRoom);
				unpushRoomNamespace.addJsonObjectListener(UnpushMsgOut.class, new DataListener<UnpushMsgOut>() {
		        	@Override
		            public void onData(SocketIOClient client, UnpushMsgOut data, AckRequest ackRequest) {
		        		if(client.isChannelOpen()) {
//		        			UUID currentSessionId = client.getSessionId();
		            		if(data != null) {
			    				Integer userId = data.getUserId();
			    				if(null != userId) {
			    					unpushMap.put(client, userId);
			    					notifyUnpushMsg(client, userId);
			    				}else{
			            			log.warn("客户端未发送用户信息！");
			            		}
								
		            		}else {
		            			log.warn("客户端发送的数据信息为空！");
		            		}
		                	
		            	}else {
		            		log.warn("客户端消息渠道未打开！");
		            	}
		            }
		        });
			}
			
			server.addDisconnectListener(new DisconnectListener(){

				@Override
				public void onDisconnect(SocketIOClient client) {
					UUID sessionId = client.getSessionId();
					Integer userId = unreadMap.get(sessionId);
					if(null != userId) {
						log.info("移除未读消息监听！客户端：" + sessionId + ",用户：" + userId);
						unreadMap.remove(sessionId);
					}
					
					unpushMap.remove(client);
					
//					if(unreadMap.containsKey(sessionId)) {
//						client.disconnect();
//					}
					
				}
				
			});
		}
	}
	
	/**
	 * 为每个群组添加消息事件监听
	 * @param cgInfo
	 */
	public void addMsgEventListener(ChatGroupInfo cgInfo) {
		String chatRoom = "/" + cgInfo.getId();
		if(server.getNamespace(chatRoom) == null) { // 聊天室未被监听
			final SocketIONamespace chatRoomNamespace = server.addNamespace(chatRoom);
	        chatRoomNamespace.addJsonObjectListener(ChatMsgOut.class, new DataListener<ChatMsgOut>() { 
	            @Override
	            public void onData(SocketIOClient client, ChatMsgOut data, AckRequest ackRequest) {
	            	if (ackRequest.isAckRequested()) {
	                    // send ack response with data to client
	                    ackRequest.sendAckData("client message was delivered to server!", "yeah!");
	                }
	            	
					try {
						// 保存到数据库中
						ChatMsgOut saveMsgOut = cgMsgService.saveChatMsg(data, cgInfo.getId());
						
						if(null != saveMsgOut) {
							log.info("聊天记录保存成功!" + JSON.toJSONString(data));
						}
						// saveMsgOut.setShMsgType(ChatGroupMsg.TYPE_MSSAGE);
						
						chatRoomNamespace.getBroadcastOperations().sendJsonObject(saveMsgOut, new BroadcastAckCallback<String>(String.class) {
							@Override
		                    protected void onClientSuccess(SocketIOClient client, String result) {
								if(null != result && !result.isEmpty()) { // 更新用户消息已读状态
									UUID sessionId = client.getSessionId();
									log.info("客户端[" + sessionId + "]返回:" + result);
									String[] resultArray = result.split(",");
									if(!"undefined".equals(resultArray[1]))
										msgStatusService.updateMsgReadStatus(Integer.parseInt(resultArray[0]), Long.parseLong(resultArray[1]));
								
//									if(!unpushMap.isEmpty()) {
//										Integer listener = unpushMap.get(sessionId);
//										if(null != listener) {
//											log.info("向客户端[" + sessionId + "]发出推送通知！");
//											notifyUnpushMsg(client, listener); // 通知用户
//										}
//									}
								}
								
		                    }
							
							@Override
		                    protected void onAllSuccess() {
								List<Integer> userList = cgUserService.getUserByCgId(cgInfo.getId(), saveMsgOut.getUserId());
								if(!unreadMap.isEmpty()) {
									for(UUID uuid : unreadMap.keySet()) {
										Integer listener = unreadMap.get(uuid);
										if(userList.contains(listener)) { // 用户在监听
											notifyUnreadMsg(server.getClient(uuid), listener); // 通知用户
										}
									}
								}
								
								if(!unpushMap.isEmpty()) {
									for(SocketIOClient sClient : unpushMap.keySet()) {
										Integer listener = unpushMap.get(sClient);
										if(userList.contains(listener)) { // 用户在监听
											notifyUnpushMsg(sClient, listener); // 通知用户
										}
									}
								}
		                    }

						});
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
					
	            }
	        });
		}

	}
	
	/**
	 * 通知客户端有新的未读消息
	 * @param cgInfo
	 */
	private void notifyUnreadMsg(SocketIOClient client, int userId) {
		log.info("通知用户[" + userId + "]未读聊天消息和随手拍消息数！");
		// 查询聊天未读消息
    	UnreadMsgOut unreadMsg = msgStatusService.getUnreadMsgCnt(userId);
    	
    	// 查询随手拍未读消息数
    	unreadMsg.setUnreadTopicNum(topicUnreadService.getMyUnreadNum(userId));
    	
		client.sendJsonObject(unreadMsg, new AckCallback<String>(String.class) {

			@Override
			public void onSuccess(String result) {
				log.info("客户端成功收到未读消息通知！结果为：" + result);
			}
			
		});
	}
	
	/**
	 * 通知客户端有新的推送消息
	 * 
	 */
	private void notifyUnpushMsg(SocketIOClient client, int userId) {
		if(null != client) {
			log.info("通知客户端未推送消息数，用户为：" + userId + ",客户端为：" + client.getSessionId());
			UnpushMsgOut unpushMsg = getUnpushMsg(userId);
			if(null != unpushMsg) {
				client.sendJsonObject(unpushMsg, new AckCallback<String>(String.class) {

					@Override
					public void onSuccess(String result) {
						log.info("客户端[" + client.getSessionId() +"]成功收到未推送消息通知！结果为：" + result);
						// 更新推送状态
						int updCnt = msgStatusService.updateAllPushStatus(userId);
						log.info("更新未推送消息状态，返回结果：" + updCnt);
					}
					
				});
			}else {
				log.info("客户端无未推送消息!");
			}
				
		}else {
			log.warn("传入的socket客户端为空！");
		}
		
	}

	/**
	 * 根据用户编号获取所有推送信息
	 * @param userId
	 * @return
	 */
	private UnpushMsgOut getUnpushMsg(int userId) {
		// 查询未推送系统消息
    	List<String> sysList = msgStatusService.getUnpushSysMsg(userId);
    	
    	// 查询未推送聊天消息数
    	int unPushChat = msgStatusService.getUnpushChatCnt(userId);
    	
    	// 查询未推送随手拍消息
    	int unPushTopic = topicUnreadService.getUnpushTopicCnt(userId);
    	
    	int unpushSysCnt = sysList == null ? 0 : sysList.size();
    	
    	if(unpushSysCnt == 0 && unPushChat == 0 && unPushTopic == 0) {
//    		unpushMsg.setIsPush(1);
    		log.info("当前用户无推送信息！" + userId);
    		return null;
    	}
    	
		UnpushMsgOut unpushMsg = new UnpushMsgOut();
		log.info("请求推送消息结束，系统消息数为：" + unpushSysCnt + ",聊天消息数为：" + unPushChat + ",随手拍消息数为：" + unPushTopic + ",接收用户为：" + userId);
//    		unpushMsg.setIsPush(0);
		
		String pushMsg = "您收到";
		String tmp = "";
		if(unpushSysCnt > 0) {
			tmp = unpushSysCnt + "条新系统通知";
			pushMsg += tmp;
			
			unpushMsg.setSystemNoticeList(sysList);
		}
		
		if(unPushChat > 0) {
			if(!tmp.isEmpty()) {
				pushMsg += ",";
			}
			
			// 获取未读消息数
			UnreadMsgOut unreadMsg = msgStatusService.getUnreadMsgCnt(userId);
			if(null != unreadMsg) {
				tmp = unreadMsg.getTotalUnreadNum() + "条新聊天消息";
				pushMsg += tmp;
			}
		}
		
		if(unPushTopic > 0) {
			if(!tmp.isEmpty()) {
				pushMsg += ",";
			}
			
			int unreadTopic = topicUnreadService.getMyUnreadNum(userId);
			
			tmp = unreadTopic + "条新随手拍消息";
			pushMsg += tmp;
		}
		
		pushMsg += "。";
		unpushMsg.setPushContent(pushMsg);
		log.info("有推送消息[" + pushMsg + "] 发出用户为：" + userId);
		return unpushMsg;
	}
	
	/**
	 * 通知群聊组所有在线客户端
	 * @param roomId 聊天室编号
	 */
	public void notifyAllRoomClients(Integer roomId, ChatMsgOut data) {
		final SocketIONamespace chatRoomNamespace = server.getNamespace("/" + roomId);
		chatRoomNamespace.getBroadcastOperations().sendJsonObject(data, new BroadcastAckCallback<String>(String.class) {
			@Override
            protected void onClientSuccess(SocketIOClient client, String result) {
				if(null != result && !result.isEmpty()) {
					UUID sessionId = client.getSessionId();
					log.info("客户端[" + sessionId + "]返回:" + result);
					String[] resultArray = result.split(",");
					if(!"undefined".equals(resultArray[1]))
						msgStatusService.updateMsgReadStatus(Integer.parseInt(resultArray[0]), Long.parseLong(resultArray[1]));
					
//					if(!unpushMap.isEmpty()) {
//						if(unpushMap.containsKey(client)) {
//							Integer listener = unpushMap.get(client);
//							notifyUnpushMsg(client, listener); // 通知用户
//						}
//					}
				}
            }
			
			@Override
            protected void onAllSuccess() {
				Integer userId = data.getUserId();
				List<Integer> userList = cgUserService.getUserByCgId(roomId, userId);
				if(data.getShMsgType() == 21103) { // 通知被移出群的用户
					String[] removeArray = data.getsUserIds().split(",");
					if(null != removeArray && removeArray.length > 0)
						for(String userIdStr : removeArray)
							userList.add(Integer.parseInt(userIdStr));
				}
				
				if(!unreadMap.isEmpty()) {
					for(UUID uuid : unreadMap.keySet()) {
						Integer listener = unreadMap.get(uuid);
						if(userList.contains(listener)) { // 用户在监听
							notifyUnreadMsg(server.getClient(uuid), listener); // 通知用户
						}
					}
				}
				
				if(!unpushMap.isEmpty()) {
					for(SocketIOClient sClient : unpushMap.keySet()) {
						Integer listener = unpushMap.get(sClient);
						if(userList.contains(listener)) { // 用户在监听
							notifyUnpushMsg(sClient, listener); // 通知用户
						}
					}
				}
            }

		});
	}
	
	/**
	 * 发送推送通知
	 * @param userId 推送发出者
	 * @param isUnreadFlush 是否更新未读消息
	 */
	public void sendPushMsg(Integer userId, boolean isUnreadFlush) {
		log.info("用户[" + userId + "]发出推送通知！");
		final SocketIONamespace pushRoomNamespace = server.getNamespace("/push");
		Collection<SocketIOClient> clients = pushRoomNamespace.getAllClients();
		
		for(SocketIOClient client : clients) {
			if(client.isChannelOpen()) {
        		UUID clientSessionId = client.getSessionId();
				if(unpushMap.containsKey(client)) {
					Integer receiveId = unpushMap.get(client);
	        		
	        		if(null != receiveId) {
	        			if(receiveId != userId) { // 推送接收者非发送者时
	            			notifyUnpushMsg(client, receiveId);
	            			
	            			if(isUnreadFlush) {
	            				if(!unreadMap.isEmpty()) {
									for(UUID uuid : unreadMap.keySet()) {
										Integer listener = unreadMap.get(uuid);
										if(receiveId.equals(listener)) { // 用户在监听
											notifyUnreadMsg(server.getClient(uuid), listener); // 通知用户未读消息
										}
									}
								}
	            				
	            			}
	            		}else {
	            			log.info("接收者与发送者为相同用户，不发推送！" + clientSessionId);
	            		}
	        		}else{
	        			log.warn("接收的用户编号为空!");
	        		}
				}
        		
        	}else {
        		log.warn("客户端消息渠道未打开！");
        	}
		}
	}
	
	/**
	 * 发送未读消息更新通知
	 * @param userId 未读消息接收者
	 */
	public void sendUnreadMsg(Integer userId) {
		log.info("通知客户端用户[" + userId + "]的新未读消息数！");
		
		if(!unreadMap.isEmpty()) {
			for(UUID uuid : unreadMap.keySet()) {
				Integer listener = unreadMap.get(uuid);
				if(userId.equals(listener)) { // 用户在监听
					notifyUnreadMsg(server.getClient(uuid), listener); // 通知用户未读消息
				}
			}
		}
	}
	
}
