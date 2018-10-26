## 用户授权登录
#### 请求类型：POST
#### 需添加授权请求头 2018-3-20
#### 返回对象添加hasLdPrj、hasCbPrj 2018-7-12
#### 返回对象添加isPrjLeader 2018-7-16

## 接口地址 /auth-login

## 请求头
* authorization 授权信息，格式为"用户编号;令牌"，如“11111；xxxxxx”，非空

## 返回结果 - 同normal-login接口


## 例子
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
		"hasLdPrj":1,
		"hasCbPrj":1,
		"isPrjLeader":1
	}
}
</pre>

## 错误码
* 401 未获得授权
