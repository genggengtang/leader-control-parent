package org.zxs.leader.control.dao.consts;

/**
 * Desc:应用常量
 * Created by hafiz.zhang on 2017/7/21.
 */
public interface IAppConst {
    public static final String LAST_URL_KEY = "lastUrlKey";
    public static final Integer UNAUTHORIZED = -102;
    
    /**
     * token有效期（天）
     */
    public static final int TOKEN_EXPIRES_DAYS = 30;
    
    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "Authorization";
    
    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
    
    /**
     * session中APP用户信息参数名
     */
    public static final String SESSION_USER_NAME = "users";
    
    /**
     * session中后台用户信息参数名
     */
    public static final String SESSION_ADMIN_NAME = "admin";
    
    /**
     * 安卓
     */
    public static final byte OS_ANDROID = 1;
    /**
     * ios
     */
    public static final byte OS_IOS = 2;
    /**
     * 其他系统
     */
    public static final byte OS_OTHER = 3;
    
    /**
     * json序列化后的参数名
     */
    public static final String JSON_PARAM_NAME = "jParams";
}
