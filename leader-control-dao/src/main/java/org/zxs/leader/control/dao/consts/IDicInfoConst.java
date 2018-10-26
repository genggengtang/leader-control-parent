package org.zxs.leader.control.dao.consts;

/**
 * 字典表常量
 */
public interface IDicInfoConst {
    
    // 项目类型
    public static final int PRJ_LEADER_CONTROL = 21401; // 市领导联系项目
    public static final int PRJ_CITY_PLAN = 21402; // 市统筹项目
    public static final int PRJ_CITY_BUILD = 21403; // 城建计划项目
    
    // 市领导联系项目联系人关联类型
    public static final int PRJ_CONTACT_RSP = 20804; // 责任单位联系人
    public static final int PRJ_CONTACT_OWNER = 20805; // 业主联系人
    public static final int PRJ_CONTACT_DIRECT = 20806; // 现场联系人
    
    // 城建计划期数
    public static final int CB_LATEST_PLAN = 21803; // 最新计划期数，每新增一期都需要更新
    
    public static final int CB_2017_1ST = 21801; // 2017年第一期
    public static final int CB_2017_2ND = 21802; // 2017年第一、二期
    public static final int CB_2018_1ST = 21803; // 2018年第一期
    
    // 操作类型
    public static final int OPT_LOGIN = 223001; // 登录
    public static final int OPT_LIST_PRJ = 223002; // 查询项目列表
    public static final int OPT_DETAIL_PRJ = 223003; // 查询项目详细信息
    public static final int OPT_TRAIN_PRJ = 223004; // 查询项目直通车
    public static final int OPT_PRGR_PRJ = 223005; // 查询项目计划进度
    public static final int OPT_INFO_NOTE = 223006; // 查询项目资讯
    public static final int OPT_LETTER = 223007; // 查看站内信
    public static final int OPT_PRJ_FAVOR = 223008; // 关注项目
    public static final int OPT_DOC_FAVOR = 223009; // 关注会议纪要
    public static final int OPT_PRJ_NOTFAVOR = 223010; // 取消项目关注
    public static final int OPT_DOC_NOTFAVOR = 223011; // 取消会议纪要关注
    public static final int OPT_CHAT_CREATE = 223012; // 创建群聊组
    public static final int OPT_CHAT_MEMBER_ADD = 223013; // 添加群聊组员
    public static final int OPT_CHAT_MEMBER_RM = 223014; // 移除群聊组员
    public static final int OPT_CHAT_NAME_MDF = 223015; // 修改群聊组名
    public static final int OPT_CHAT_RM = 223016; // 解散群聊组
    public static final int OPT_LOGOUT = 223017; // 登出
    public static final int OPT_PSW_MDF = 223018; // 修改密码
    public static final int OPT_ISSUE_RAISE = 223019; // 意见反馈
    public static final int OPT_TOPIC_PAGE = 223020; // 查询随手拍
    public static final int OPT_TOPIC_SEND = 223021; // 发送随手拍
    public static final int OPT_TOPIC_DETAIL = 223022; // 查看随手拍详情
    public static final int OPT_COMMENT_SEND = 223023; // 发送随手拍评论
    public static final int OPT_TOPIC_DELETE = 223024; // 删除随手拍
    
    public static final short TYPE_LD_INDUSTRY = 203; 		// 市领导联系项目产业
    public static final short TYPE_LD_BUILD_STATUS = 204; 	// 市领导联系项目建设阶段
    public static final int TYPE_PRJ_TYPE = 214; 			// 项目大类别
    public static final int TYPE_QUESTION_TYPE = 205; 		// 问题类型
    public static final int TYPE_PROVE_TYPE = 206; 			// 审批类型
    
}
