## 随手拍分页列表
#### 默认按照最后更新时间降序排列
#### 只能查自己发的TOPIC或者别人发送的对象中包括自己的
#### 需添加授权请求头
#### 返回数据添加receiveUserList、isAuthor、isNewGroup、receiveUserNames、receiveUserNamesSub 2018-6-29

## 接口地址 /my-topic-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string


## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 数组 array
    *  id 编号 int
    *  sendUserName 发送者名称 string
    *  receiveCgName 接收群组名称 string
    *  receiveUserList 主题发送对象集合 array
    *  content 内容 string
    *  contentSub 内容摘要 string
    *  picUrl 图片地址 string
    *  commentNum 总评论数 int
    *  unreadNum 未回复主题或未读回复数 int
    *  commentStatus 回复状态描述 string
    *  createAt 创建时间，格式为"yyyy-mm-dd hh:MM:ss" date
    *  updateAt 最后更新时间，格式为"yyyy-mm-dd hh:MM:ss" date
    *  isAuthor 是否主题发送者，0为否，1为是 int
    *  isNewGroup 发送对象是否多人，0为否，即对象为群聊组，1为是 int
    *  receiveUserNames 主题发送所有对象名称 string
    *  receiveUserNamesSub 主题发送对象简称，只显示前5人 string

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"",
	"draw":"",
	"total":1,
	"data":[
		{
			"id":1234567890,
			"sendUserName":"xxxxxx",
			"receiveCgName": "xxxxxxxxxxxxx",
			"content":"xxxxxxxxxxxxxxxxxxxx",
			"contentSub":"xxxxxxxxxx",
			"picUrl":"http://cccccccccc",
			"commentNum":0,
			"unreadNum":1,
			"createAt": "2018-04-24 14:22:03",
			"updateAt": "2018-04-24 14:22:03"
			"receiveUserList":["dfgdfg","dafa"],
			"isAuthor":0,
			"isNewGroup": 0,
			"receiveUserNamesSub": "dfgdfg,dafa"
		}
	]
}
</pre>

## 错误码 - 无
