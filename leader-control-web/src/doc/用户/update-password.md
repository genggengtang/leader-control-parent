## 修改密码
#### 需添加授权请求头

## 接口地址 /update-password
#### POST

## 请求参数
* pswdOld 旧密码，需经过MD5加密，非空 string
* pswdNew 新密码，需经过MD5加密，非空 string

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string

## 返回例子
{
	"errorCode":0，
	"errorMsg":"该用户名通过验证!"
}

## 错误码
* -101 存在非法字符，请检查您输入的字符!
* -103 原密码错误!
* -104 更改密码失败！
