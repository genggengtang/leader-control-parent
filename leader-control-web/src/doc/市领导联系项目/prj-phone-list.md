## 项目通讯录
#### 只能查询同级别或更低级别的用户信息
#### 需添加授权请求头
#### 请求参数添加nameLike 2018-4-4
#### 请求参数添加prjType 2018-4-30

## 接口地址 /prj-phone-list/{id}

## 请求参数
* {id} 项目编号 int
* prjType 项目类型，对应字典表214字段，默认21401 int
* nameLike 模糊查询关键字，可为空 string

## 返回结果
* bookList 通讯录分组数据 array
    * groupName 通讯录组名 string
    * groupMembers 通讯录人名 array
        *  userId 用户编号 int
        *  userName 用户名 string
        *  orgName 所属机构名称 string
        *  mobilePhone 手机号 string
        *  position 职位 string
        *  isInGroup 是否在群组中，0为否，1为是 int
* cgList 当前项目聊天群组 array
    *  id 群聊组编号 int
    *  groupName 群聊组名称 string
    *  createName 创建者名称 string
    *  groupNum 群成员总数    int
    *  unreadNum 未读消息数    int
    *  createAt 创建时间,格式为"yyyy-mm-dd hh:MM:ss" date


## 返回例子
<pre>
{
	"bookList":[
		{
			"groupName":"市政府",
			"groupMembers":[
			{
				"userId":1234567890,
				"userName":"张文军",
				"orgName":"xxxxxxxxx",
				"mobilePhone":"13xxxxxxxxx",
				"position":"副市长",
				"isInGroup":0
			}
			]
		}
	],
	"cgList":[
		{
			"id":1234567890,
			"groupName":"xxxxxx",
			"createName":"张文军",
			"groupNum":2,
			"unreadNum":0,
			"createAt":"2018-03-12 10:00:00"
		}
	]
</pre>

## 错误码 - 无
