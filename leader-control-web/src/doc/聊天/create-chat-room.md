## 创建群聊室
#### 需添加授权请求头
#### 修改请求参数userArray，改为string类型 2018-4-2
#### 添加请求参数prjType 2018-4-30

## 接口地址 /create-chat-room
#### POST

## 请求参数
* groupName 聊天组名，50字以内，可为空 string
* userArray 用户编号数组序列化，可为空 string
* prjId 项目编号，可为空 int
* prjType 项目类型，对应字典表214，默认21401,当prjId为空时无效 int
* introduce 简介，100字以内，可为空 string

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data 返回聊天室信息 object
    *  id 群组编号 int
    *  groupName 群组名称 string
    *  groupNum 群人数 int
    *  prjName 项目名 string
    *  createAt 群组创建时间,格式为"yyyy-mm-dd hh:MM:ss" date
    
## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"创建群聊组成功！",
	"data":{
		"id":1200000,
		"groupName":"cccccc",
		"groupNum":10,
		"prjName":"xxxxxxxxxxxxx",
		"createAt":"2018-03-10 10:00:00"
	}
}
</pre>

## 错误码
* -301 您无权创建聊天室
* -302 创建群聊失败
