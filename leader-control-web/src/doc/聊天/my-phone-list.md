## 我的通讯录
#### 只能查询同级别或更低级别的用户信息
#### 需添加授权请求头
#### 修改请求参数名isUserIn,返回值添加所属机构名和是否在群组中 2018-3-29
#### 请求参数添加nameLike、userSelected 2018-4-4
#### 添加请求参数prjType 2018-4-30
#### 返回参数添加removeable 2018-5-14

## 接口地址 /my-phone-list

## 请求参数
* cgId 群聊组编号,可为空 int
* prjId 项目编号,可为空 int
* prjType 项目类型，对应字典表214，默认21401,当prjId为空时无效 int
* isUserIn 是否查询群里用户，0为否，1为是，可为空 int
* nameLike 模糊查询关键字，可为空 string
* userSelected 已选择的用户数组 string

## 返回结果
* groupName 通讯录组名 string
* groupMembers 通讯录人名 array
    *  userId 用户编号 int
    *  userName 用户名 string
    *  orgName 所属机构名称 string
    *  mobilePhone 手机号 string
    *  position 职位 string
    *  isInGroup 是否在群组中，0为否，1为是 int
    *  isSelected 是否已选择，0为否，1为是 int
    *  removeable 能否被删除，0为否，1为是 int

## 返回例子
<pre>
[
{
	"groupName":"市政府",
	"groupMembers":[
	{
		"userId":1234567890,
		"userName":"张文军",
		"orgName":"xxxxxxxxx",
		"mobilePhone":"13xxxxxxxxx",
		"position":"副市长",
		"isInGroup":0,
		"isSelected":0,
		"removeable":0
	}
	]
}
]
</pre>

## 错误码 - 无
