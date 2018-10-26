## SOCKET.IO全部交互信息
#### 未读消息对象添加unreadTopicNum 2018-7-5

```
1. 普通聊天，即用户在聊天室内发消息
#### 路径： /{roomId}
* {roomId} 聊天室编号

#### 客户端发送的对象名：org.zxs.leader.control.dao.model.vo.output.ChatMsgOut
#### 客户端发送信息
* userId 发送者编号 int
* userName 发送者名称 string
* msgContent 消息内容 string
* shMsgType 消息类型,参见字典表211字段 int
* fileName 文件名 string
* fileUrl 文件URL地址 string

#### 客户端收到信息
* msgId 消息编号 int
* userId 发送者编号 int
* userName 发送者名称 string
* msgContent 消息内容 string
* msgAt 消息时间,格式为"yyyy-mm-dd hh:MM:ss" date
* shMsgType 消息类型,参见字典表211 int
* sUserNames 添加或删除成员名单，多人以逗号分隔 string
* sUserIds 添加或删除成员编号，多人以逗号分隔 string
* shUserNum 添加或删除总人数 int
* isSelf 是否本人，0为否，1为是 int
* fileName 文件名 string
* fileUrl 文件URL地址 string	
* topicId 随手拍主题编号 string

2. 未读消息
#### 用户在首次连接SOCKET时需主动向服务器发送一条订阅信息，之后该用户有新未读消息时由服务器主动通知客户端
#### 路径: /

#### 客户端发送的对象名：org.zxs.leader.control.dao.model.vo.output.UnreadMsgOut
#### 客户端发送信息
* userId 发送者编号 int

#### 客户端收到信息
* userId 用户编号 int
* totalUnreadNum 所有未读聊天消息总数 int
* unreadTopicNum 所有未读随手拍消息总数 int
* unreadList 群聊组未读消息集合 array

3. 推送消息
#### 用户在首次连接SOCKET时需主动向服务器发送一条订阅信息，之后该用户有新推送消息时由服务器主动通知客户端
#### 当客户端收到isPush为1时，无需显示推送内容
#### 路径: /push

#### 客户端发送的对象名：org.zxs.leader.control.dao.model.vo.output.UnpushMsgOut
#### 客户端发送信息
* userId 发送者编号 int

#### 客户端收到信息
* userId 用户编号 int
* pushContent 推送内容 string
* systemNoticeList 系统通知列表 array
```
