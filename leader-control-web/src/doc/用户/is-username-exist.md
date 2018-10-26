## 用户名是否存在

## 接口地址 /is-username-exist

## 请求参数
* username 用户名，非空，最大20个字符 string

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
* -201 该用户名不存在!
