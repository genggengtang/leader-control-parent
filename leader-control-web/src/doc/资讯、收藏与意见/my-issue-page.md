## 我的意见分页列表
#### 默认按照最后更新时间降序排列
#### 需添加授权请求头

## 接口地址 /my-issue-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string


## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 意见数组 array
    *  id 编号 int
    *  title 标题 string 
    *  content 意见内容 string
    *  issueAt 创建时间，格式为"yyyy-mm-dd hh:MM:ss" date
    *  statusDis 意见回复状态 string
    *  replyContent 回复内容 string
    *  replyAt 回复时间，格式为"yyyy-mm-dd hh:MM:ss" date

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"",
	"draw":"",
	"total":1,
	"data":[
		{
			"id":1234567890,
			"title":"xxxxxx",
			"content":"xxxxxxxxxxxxxxxxxxxx",
			"issueAt": "2018-04-24 14:22:03",
			"statusDis":"未回复",
			"replyContent":null,
			"replyAt":null
		}
	]
}
</pre>

## 错误码 - 无
