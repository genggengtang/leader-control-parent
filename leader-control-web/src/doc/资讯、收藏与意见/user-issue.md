## 用户提出意见
#### 需添加授权请求头

## 接口地址 /user-issue
#### POST

## 请求参数
* title 标题，可以为空 string
* content 意见内容，非空 string

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data 返回数据，为意见编号 int

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"成功收到用户提出的意见！"，
	"data":1001
}
</pre>

## 错误码
* -130 保存用户意见出错
