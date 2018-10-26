package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface ITokenManager {

	 /**
     * 创建一个token关联上指定用户
     * @param user 指定用户
     * @return 生成的token
     */
    public String createToken(LoginUserOut user);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(String userIdStr, String token);

    /**
     * 根据key获取用户登录缓存信息
     * @param authentication 加密后的字符串
     * @return
     */
    public LoginUserOut getTokenObject(String userIdStr);

    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(int userId);
    
}
