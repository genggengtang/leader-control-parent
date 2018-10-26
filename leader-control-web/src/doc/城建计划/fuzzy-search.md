## 关键字模糊查询
#### 可搜索项目名、领导名、业主单位名

## 接口地址 /cb/fuzzy-search

## 请求参数
* keyword 关键字，非空，长度不超过20个字 string
* planNo 计划期数，参见字典表218 int

## 返回结果 - 数组
* type 搜索类型，1为按项目名，2为按领导名，3为按业主名 int
* id 编号 int
* value 搜索结果名称 string
* typeDis 搜索类型释义 string

## 返回例子
<pre>
[
	{
		"type":2,
		"id":1234567890,
		"value":"张文军",
		"typeDis":"按领导名"
	},
	{
		"type":1,
		"id":12345678,
		"value":"邕江综合整治和开发利用工程",
		"typeDis":"按项目名"
	}
]
</pre>


## 错误码 - 无
