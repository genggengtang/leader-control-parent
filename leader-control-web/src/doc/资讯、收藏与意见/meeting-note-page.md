## 会议纪要分页列表
#### 默认按照录入时间降序排列
#### 需添加授权请求头
#### 修改传入文件类型type
#### 添加参数startDate，endDate 2018-4-13
#### 请求参数添加prjType 2018-4-21
#### 请求参数添加isInspectIn，当查询督查报告时，设置isInspectIn=1 2018-7-3

## 接口地址 /meeting-note-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string
* prjType 项目类型，参见字典表214，默认21401 int
* type 文件类型，详见字典表209，多种类型以逗号分隔 string
* keyword 搜索关键字 string
* startDate 开始日期，格式为"yyyy-MM-dd" string
* endDate 结束日期，格式为"yyyy-MM-dd" string
* isFavorite 是否查询已关注项目，0为否，1为是，可为空 int
* isInspectIn 是否包括督查报告，0为否，1为是，默认0 int


## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 会议纪要数组 array
    *  id 编号 int
    *  type 会议纪要类型，详见字典表209 int 
    *  title 标题 string 
    *  name 纪要文件名 string
    *  url 内容URL string
    *  createAt 创建时间，格式为"yyyy-mm-dd hh:MM:ss" date
    *  favoriteId 关注编号 int

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
			"name":"xxxx",
			"contentUrl":"xxxx.html",
			"createAt":"2018-03-10 15:00:14",
			"favoriteId":null
		}
	]
}
</pre>

## 错误码 - 无
