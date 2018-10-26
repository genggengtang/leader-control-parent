## 获取APP最新版本信息，返回空表示当前已为最新版本

## 接口地址 /get-app-version

## 请求参数
* version 当前版本号 string

## 返回结果
* id 版本编号 int
* os 操作系统编号，1为android，2为ios int
* vCode 最新版本号 string
* content 版本更新内容 string
* url 下载地址
* createAt 数据时间，格式为"yyyy-mm-dd hh:MM:ss" date

## 返回例子
<pre>
{
	"id": 1,
	"os": 1,
	"vCode": "string"，
	"content": "xxxx",
	"url": "string",
	"createAt": "2018-05-24 03:30:46",
}
</pre>

## 错误码 - 无
