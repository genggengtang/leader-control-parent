## 用户常规登录
#### 当errorcode为1时,表示同一登录用户名对应多个用户，返回数据中包含loginMap
#### 添加请求参数userId，返回类型添加loginMap 2018-4-12
#### 返回对象添加hasLdPrj、hasCbPrj 2018-7-12
#### 返回对象添加isPrjLeader 2018-7-16

## 接口地址 /normal-login
#### 请求类型：POST

## 请求参数
* username 用户名，非空，最大20个字符 string
* password 密码，非空，长度为32位，已经过MD5加密 string
* userId 用户编号 int

## 返回结果
* errorCode	返回码，0为成功，1为有多个用户，其余为错误码 int
* errorMsg 提示信息 string
* data object 返回数据
    *  userId 用户编号 string
    *  username 用户真实姓名 string
    *  orgName 用户所属机构 string
    *  position 用户职位 string
    *  avatar 头像url string
    *  level 用户级别 int
    *  token 令牌，32位字符 string
    *  unreadNum 未读消息总数 int
    *  createAt 时间戳，格式为“yyyy-MM-dd HH-mm:ss:ms” date
    *  loginMap 用户编号-名称集合 map
    *  hasLdPrj 市领导联系项目是否显示"联系项目"，0为不显示，1为显示 int
    *  hasCbPrj 城建计划是否显示"联系项目"，0为不显示，1为显示 int
    *  isPrjLeader 是否责任领导或联系领导，0为否，1为是 int

## 返回例子1
<pre>
{
	"errorCode":0，
	"errorMsg":"该用户登录成功!",
	"data":{
		"userId":1234567890,
		"username":"xxx",
		"orgName":"人民政府",
		"position":"副市长",
		"avatar":"",
		"level":2,
		"token":"4cdbc040657a4847b2667e31d9e2c3d9",
		"unreadNum":0,
		"createAt":"2018-03-15 10:00:00",
		"loginMap":null,
		"hasLdPrj":1,
		"hasCbPrj":1,
		"isPrjLeader":1
	}
}
</pre>

## 返回例子2
<pre>
{
	"errorCode":1，
	"errorMsg":"该用户名对应多个用户!",
	"data":{
		"loginMap":{
			"12312231231":"xxxxxxxxxxxxx",
			"12312231232":"xxxxxxxxxxxxx"
		}
	}
}
</pre>

## 错误码
* -101 存在非法字符，请检查您输入的字符!
* -201 该用户名不存在!
* -202 密码不正确!
