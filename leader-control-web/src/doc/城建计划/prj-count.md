## 城建计划项目计数

## 接口地址 /cb/prj-count

## 请求参数
* planNo 计划期数，对应字典表218字段，默认21803 int
* label 重点项目标签，对应字典表217字段 int
* isKeyPrj 是否重点项目，0为否，1为是 int

## 返回结果
* {key:value} key为计划期数名称，value为总数 map


## 返回例子
<pre>
	{"2018年第一期":100}
</pre>

## 错误码 - 无
