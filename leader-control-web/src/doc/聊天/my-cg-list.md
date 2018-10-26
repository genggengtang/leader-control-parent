## 我的群聊分组列表
#### 聊天群组按创建时间降序排列
#### 需添加授权请求头
#### 修改工作组返回数据结构 2018-3-29
#### 添加返回值enableRemove 2018-4-10
#### 修改工作群返回数据结构 2018-4-10
#### 添加请求参数nameLike 2018-6-20

## 接口地址 /my-cg-list

## 请求参数
* nameLike 群聊组名关键字搜索 string

## 返回结果
* workGroupCnt 工作群数量 int
* myGroupCnt 我的群数量 int
* myGroup 我的群 array
    *  id 群聊组编号 int
    *  groupName 群聊组名称 string
    *  createName 创建者名称 string
    *  groupNum 群成员总数    int
    *  unreadNum 未读消息数  int
    *  createAt 创建时间,格式为"yyyy-mm-dd hh:MM:ss" date
* serviceGroup 服务队群 array
    *  id 群聊组编号 int
    *  groupName 群聊组名称 string
    *  createName 创建者名称 string
    *  groupNum 群成员总数    int
    *  unreadNum 未读消息数    int
    *  enableRemove 是否可解散，0为否，1为是，不可解散对应默认群组 int
    *  createAt 创建时间,格式为"yyyy-mm-dd hh:MM:ss" date
* lcGroup 市领导联系项目群 array
    *  prjName 项目名称 string
    *  prjGroupNum 项目群成员总数    int
    *  workPrjGroup 项目群 array
        *  id 群聊组编号 int
        *  groupName 群聊组名称 string
        *  createName 创建者名称 string
        *  groupNum 群成员总数    int
        *  unreadNum 未读消息数    int
        *  enableRemove 是否可解散，0为否，1为是，不可解散对应默认群组 int
        *  createAt 创建时间,格式为"yyyy-mm-dd hh:MM:ss" date
* cbGroup 城建计划项目群 array
    *  prjName 项目名称 string
    *  prjGroupNum 项目群成员总数    int
    *  workPrjGroup 项目群 array
        *  id 群聊组编号 int
        *  groupName 群聊组名称 string
        *  createName 创建者名称 string
        *  groupNum 群成员总数    int
        *  unreadNum 未读消息数    int
        *  enableRemove 是否可解散，0为否，1为是，不可解散对应默认群组 int
        *  createAt 创建时间,格式为"yyyy-mm-dd hh:MM:ss" date


## 返回例子
<pre>
{
	"workGroupCnt":3,
	"serviceGroup":[{
		"id":1234567890,
		"groupName":"xxxxxx",
		"createName":"张文军",
		"groupNum":2,
		"unreadNum":0,
		"createAt":"2018-03-12 10:00:00"
	}],
	"lcGroup":[{
		"prjName":"xxxxxxxx",
		"prjGroupNum":1,
		"workPrjGroup":[
		{
			"id":1234567890,
			"groupName":"xxxxxx",
			"createName":"张文军",
			"groupNum":2,
			"unreadNum":0,
			"createAt":"2018-03-12 10:00:00"
		}]
	}],
	"cbGroup":[{
		"prjName":"xxxxxxxx",
		"prjGroupNum":1,
		"workPrjGroup":[
		{
			"id":1234567890,
			"groupName":"xxxxxx",
			"createName":"张文军",
			"groupNum":2,
			"unreadNum":0,
			"createAt":"2018-03-12 10:00:00"
		}]
	}],

	"myGroupCnt":1,
	"myGroup":[
		{
			"id":12345880,
			"groupName":"xxxxxx",
			"createName":"张文军",
			"groupNum":2,
			"unreadNum":0,
			"createAt":"2018-03-12 10:00:00"
		}
	]
}
</pre>

## 错误码 - 无
