## 项目分页列表
#### 默认按照项目录入时间升序排列
#### 需添加授权请求头 2018-3-20
#### 原请求参数leaderId已无效，新增rspLeaderId、keyword 2018-3-21
#### 添加ownerName 2018-3-22
#### 查询条件添加nameLike 2018-4-9
#### 添加返回buildStatus,添加请求参数month 2018-4-15
#### 返回参数添加totalPlanInvest 2018-6-1
#### 请求参数添加prjUser 2018-7-16
#### 添加actualCompletionStatus项目实际竣工状态字段（String） 2018-9-4

## 接口地址 /prj-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string
* prjId 项目编号 int
* prjName 项目全名 string
* orgId 项目业主单位编号 int
* is60thWelfare 是否60周年公益项目,0为否，1为是 int
* isPrvcPlan 是否区统筹项目，0为否，1为是 int
* areaId 区域编号 int
* planStatus 计划建设阶段 int
* industry 行业分类，参见字典表 int
* group 服务队编号 int
* completeStatus 完成状态，1为超前，2为正常，3为滞后，4为其他 int
* isFavorite 是否查询关注项目，0为否，1为是 int
* isAreaCross 是否跨城区，0为否，1为是 int
* isSelf 是否服务队领导自己负责项目，0为否，1为是，默认为1 int
* rspLeaderId 项目责任领导编号，非服务队领导用户查询结果可能为空 int
* keyword 关键字模糊查询，可为项目名、联系领导名、业主单位名 string
* nameLike 项目名关键字模糊查询 string
* month 年月，即当月开工或在建的项目，格式为"yyyy-MM" string
* prjUser 项目相关人员编号 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 项目数组 array
    *  id 项目编号 int
    *  fullName 项目全称 string 
    *  shortName 项目简称 string
    *  lng 经度 decimal
    *  lat 纬度 decimal
    *  type 服务类别，如2代表2星 int
    *  planStatusDis 计划建设阶段释义 string
    *  actualStatusDis 实际建设阶段释义 string
    *  is60thWelfare 是否60周年公益项目 int
    *  isPrvcPlan 是否区统筹项目 int
    *  planStartDt 计划开始日期，格式为"yyyy-MM-dd" date
    *  planEndDt 计划竣工日期，格式为"yyyy-MM-dd" date
    *  accmPlanInvest 当年至本月累计计划投资，单位万元 int
    *  accmActualInvest 当年至本月累计实际投资，单位万元 int
    *  yearPlanInvest 年度计划投资，单位万元 int
    *  completeRateByMonth 月度投资完成百分比 int
    *  completeRateByYear 年度投资完成百分比 int
    *  groupName 服务队名称 string
    *  ownerName 所有业主单位名称 string
    *  ownerNameSub 业主单位，截取前14个字符 string
    *  completeStatusDis 完成进度，即正常、超前、滞后 string
    *  buildStatus 建设状态，1为开工，2为在建
    *  totalPlanInvest 计划总投资 int
    *  actualCompletionStatus 实际完成情况 string - 已完成返回“已竣工”，未完成返回null

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
			"fullName":"邕江综合整治和开发利用工程",
			"lng":103.5,
			"lat":22.15,
			"type":1,
			"planStatusDis":"预备",
			"actualStatusDis":"预备",
			"is60thWelfare":1,
			"isPrvcPlan":0,
			"planStartDt":"2017-07-01",
			"planEndDt":"2018-07-01",
			"accmPlanInvest":3200,
			"accmActualInvest":3000,
			"yearPlanInvest":15000,
			"completeRateByMonth":94,
			"completeRateByYear":20,
			"groupName":"第一服务队",
			"ownerName":"xxxxxxxxx",
			"ownerNameSub":"xxxxxxxxx",
			"completeStatusDis":"正常",
			"buildStatus":null,
			"actualCompletionStatus": "已竣工",
			"totalPlanInvest":0
		}
	]
}
</pre>

## 错误码 - 无
