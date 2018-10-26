## 我的群聊历史记录
#### 按消息时间降序排列
#### 需添加授权请求头

## 接口地址 /my-chat-msg/{id}

## 请求参数
* {id} 群聊组编号 int
* msgId 查询起始消息编号，可为空 int
* msgNum 最大查询数目，默认15条 int

## 返回结果 - 消息数组
* msgId 消息编号 int
* userId 消息发送者编号 int
* userName 消息发送者名称 string
* msgContent 消息内容 string
* msgAt 消息发送时间，格式为"yyyy-mm-dd hh:MM:ss" date
* shMsgType 消息类型，详见字典表211，当前定义4种类型，21101为文本消息，21102为添加成员消息，21103 为移除成员消息，21104为群解散消息
* sUserNames 添加或删除用户名称，多个以逗号分隔 string
* sUserIds 添加或删除用户编号，多个以逗号分隔 string
* shUserNum 添加或删除用户数 int
* isSelf 是否本人发送的消息，0为否，1为是 int

## 返回例子
<pre>
[
	{
		"msgId":150000000,
		"userId":110000,
		"userName":"张xx",
		"msgContent":"xxxxxxxxxxxxxxxxxxxxxx",
		"msgAt":"2018-03-15 10:01:00",
		"shMsgType":21101,
		"sUserIds":"",
		"sUserNames":"",
		"shUserNum":""，
		"isSelf":1
	}
]
</pre>

## 错误码 - 无
