## 工作资讯分页列表
#### 默认按照录入时间降序排列

## 接口地址 /work-info-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string


## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 资讯数组 array
    *  id 资讯编号 int
    *  title 标题 string 
    *  picUrl 图片URL地址 string
    *  contentUrl 内容URL string
    *  createAt 创建时间，格式为"yyyy-mm-dd hh:MM:ss" date

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
			"title":"邕江综合整治和开发利用工程",
			"picUrl":"xxxx.jpg",
			"contentUrl":"xxxx.html",
			"createAt":"2018-03-10 15:00:14"
		}
	]
}
</pre>

## 错误码 - 无
