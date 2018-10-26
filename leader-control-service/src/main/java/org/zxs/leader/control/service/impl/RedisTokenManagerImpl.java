package org.zxs.leader.control.service.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.service.interf.ITokenManager;

@Service
public class RedisTokenManagerImpl implements ITokenManager {

	private static Log log = LogFactory.getLog(RedisTokenManagerImpl.class);
	
	@Resource
	private RedisTemplate<String, LoginUserOut> redis;
	
	public String createToken(LoginUserOut user) {
		String userIdStr = user.getUserId() + "";
		LoginUserOut tokenUser = redis.boundValueOps(userIdStr).get();
		if(tokenUser == null || tokenUser.getToken() == null) { // 创建token
			log.info("用户[" + user.getUserId() + "]的token不存在!开始创建新token!");
			// 使用uuid作为源token
			String token = UUID.randomUUID().toString().replace("-", "");
			user.setToken(token);
			// 存储到redis并设置过期时间
			redis.boundValueOps(userIdStr).set(user, IAppConst.TOKEN_EXPIRES_DAYS, TimeUnit.DAYS);
			return token;
		}
		log.info("用户[" + user.getUserId() + "]的token已存在!");	
		return tokenUser.getToken();
	}

	public LoginUserOut getTokenObject(String userIdStr) {
		return redis.boundValueOps(userIdStr).get();
	}

	public boolean checkToken(String userIdStr, String token) {
		if (userIdStr == null || userIdStr.isEmpty()
				|| token == null || token.isEmpty()) {
			return false;
		}
		
		LoginUserOut user = getTokenObject(userIdStr);
		
		if (user == null || !token.equals(user.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redis.boundValueOps(userIdStr).expire(IAppConst.TOKEN_EXPIRES_DAYS, TimeUnit.HOURS);
		return true;
	}

	public void deleteToken(int userId) {
		redis.delete(userId + "");
	}
	
}
