## 城建计划项目统计
#### 需添加授权请求头 

## 接口地址 /cb/prj-statics

## 请求参数
* type 统计项目类，1为自己负责，2为其他领导人负责，3为关注项目，默认值为1 int

## 返回结果 - 数组
* leaderId 领导人编号 int
* leaderName 领导人姓名 string
* aheadNum 超前项目数 int
* delayNum 滞后项目数 int
* normalNum 正常项目数 int
* otherNum 其他项目数 int
* startRate 开工率 int
* endRate 竣工率 int
* annualPlanInvest 年度计划投资额，单位万元 int
* annualActualInvest 年度累计投资额，单元万元 int
* annualRate 年度投资计划完成率 int
* totalNum 项目数 int

## 返回例子
<pre>
[
	{
		"leaderId":1234567890,
		"leaderName":"张文军",
		"aheadNum":2,
		"delayNum":3,
		"normalNum":12,
		"otherNum":0,
		"startRate":30,
		"endRate":15,
		"annualPlanInvest":200000,
		"annualActualInvest":190000,
		"annualRate":95,
		"totalNum":17
	}
]
</pre>

## 错误码 - 无
