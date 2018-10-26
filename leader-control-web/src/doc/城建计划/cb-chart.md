## 城建计划统计内容
#### 需添加授权请求头 

## 接口地址 /cb/prj-chart

## 请求参数
* planNo 城建计划期数，非空 int

## 返回结果
* id 编号 int
* planName 计划名称 string
* planInvest 年度计划总投资，单位亿元 double
* actualInvest 年度实际投资，单位亿元 double
* fundCost 经费开支，单位亿元 double
* prjNum 当期项目总数 int
* newPrjNum 新建项目个数 int
* extendPrjNum 续建项目个数 int
* sourceCityFinance 资金来源为是财政或其他 int
* sourceSocial 资金来源为城发或企业投资 int
* url 统计表URL地址 string

## 返回例子
<pre>
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
</pre>

## 错误码 - 无
