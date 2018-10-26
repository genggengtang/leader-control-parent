## 用户退出登录
#### 请求类型：DELETE
#### 需添加授权请求头 2018-3-20

## 接口地址 /logout

## 请求头
* authorization 授权信息，格式为"用户编号;令牌"，如“11111；xxxxxx”，非空

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string

## 例子
<pre>
{
	"errorCode":0，
	"errorMsg":"退出登录成功!"
}
</pre>

## 错误码
* 401 未获得授权
