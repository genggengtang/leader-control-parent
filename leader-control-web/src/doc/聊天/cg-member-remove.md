## 移除群聊组成员
#### 需添加授权请求头
#### 修改请求参数userArray，改为string类型 2018-4-2

## 接口地址 /cg-member-remove/{id}
#### POST

## 请求参数
* {id} 群组编号，非空 int
* userArray 用户编号数组序列化,非空 string

## 返回结果 - 机构数组
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data 返回聊天室信息 object
    *  id 群组编号 int
    *  groupName 群组名称 string
    *  groupNum 群人数 int


## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"移除群组成员成功！",
	"data":{
		"id":1200000,
		"groupName":"cccccc",
		"groupNum":10
	}
}
</pre>

## 错误码
* -303 权限不足！
* -304 该聊天群组可能已解散！
* -309 不能移除不在该群组的成员！
* -310 移除群组成员失败！
* -311 默认群组不能加减人，也不能解散！