## 我的群聊组基本信息
#### 成员用户按加入时间升序排列
#### 需添加授权请求头

## 接口地址 /my-cg-info/{id}

## 请求参数
* {id} 群聊组编号,可为空 int

## 返回结果
* id 群聊组编号 int
* groupName 群聊组名称 string
* createId 群主用户编号 int
* createName 群主名称 string
* prjId 关联的项目编号 int
* prjName 关联的项目名称 string
* introduce 群聊组简介 string
* groupNum 群聊组成员数 int
* enableNameUpdate 是否允许更改群名，0为否，1位是 int
* enableRemove 是否允许解散，0为否，1位是 int
* createAt 群组创建时间,格式为"yyyy-mm-dd hh:MM:ss" date
* isGroupAdmin 能否管理群成员增减 booelan
* memberList 群聊组成员 array
    *  userId 成员用户编号 int
    *  userName 成员用户名称 string
    *  createAt 加入时间,格式为"yyyy-mm-dd hh:MM:ss" date
    *  removeable 能否被删除，0为否，1为是 int

## 返回例子
<pre>
{
	"id":13000000,
	"groupName":"xxxx",
	"createId":120000,
	"createName":"李xx",
	"prjId":22000,
	"prjName":"南宁xxxxxxxxx",
	"introduce":"",
	"enableNameUpdate":1,
	"enableRemove":1,
	"groupNum":2,
	"createAt":"2018-03-10 10:00:00",
	"isGroupAdmin":true,
	"memberList":[{
		"userId":110000,
		"userName":"王xx",
		"createAt":"2018-03-10 10:00:00",
		"removeable":1
	}]
}
</pre>

## 错误码 - 无
