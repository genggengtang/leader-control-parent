## 市统筹项目分页列表
#### 默认按照项目录入时间升序排列
#### 需添加授权请求头 2018-5-16

## 接口地址 /cp-prj-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string
* planStatus 计划建设阶段，参见字典表204 int
* industry 行业分类，参见字典表203 int
* labels  项目属性标签数组，参见字典表213 array
* nameLike 项目名或业主单位名关键字模糊查询 string
* areaAdmin 所属行政管理区域 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 项目数组 array
    *  id 项目编号 int
    *  name 项目全称 string
    *  planInvestTotal 计划总投资，单位万元 int
    *  planStatusDis 计划建设阶段释义 string
    *  planStartYear 计划开始年 int
    *  planEndYear 计划竣工年 int
    *  ownerName 所有业主单位名称,多个以逗号分隔 string
    *  yearPlanInvest 当年计划总投资，单位万元 int
    *  labelArray 项目属性标签数组,如“60周年”等  array

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
			"name":"邕江综合整治和开发利用工程",
			"planInvestTotal":500000,
			"planStatusDis":"预备",
			"planStartYear":"2017",
			"planEndYear":"2018",
			"ownerName":"xxxxxxxxx,xxxxxx",
			"yearPlanInvest":20000,
			"labelArray":["60周年","区统筹"]
		}
	]
}
</pre>

## 错误码 - 无
