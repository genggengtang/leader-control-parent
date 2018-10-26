## 城建计划项目分页列表
#### 默认按照项目录入时间升序排列
#### 需添加授权请求头
#### 返回值中添加项目计划起止年限 2018-5-4
#### 返回参数添加prjInvestTotal 2018-6-1

## 接口地址 /cb/prj-page

## 请求参数
* pageNum 起始页码，默认为1 int
* pageSize 每页数据条数，默认为10 int
* draw 前端自定义字段，后端原样返回 string
* prjId 项目计划编号 int
* orgId 项目业主单位编号 int
* rspLeaderId 项目责任领导编号 int
* areaId 区域编号 int
* cbFeature 城建性质，对应字段表215 int
* cbType 城建项目分类，参见字典表216 int
* label 重大项目分类标签，对应字典表217 int
* completeStatus 完成状态，1为超前，2为正常，3为滞后，4为其他 int
* planNo 计划代号，对应字典表218字段，默认查询21803 int
* isFavorite 是否查询关注项目，0为否，1为是 int
* isAreaCross 是否跨城区，0为否，1为是 int
* isSelf 是否rspLeaderId对应的领导自己负责项目，0为否，即除本人之外的其他领导，1为是 int
* isKeyPrj 是否重点项目，0为否，1为是，默认0 int
* keyword 关键字模糊查询，可为项目名、联系领导名、业主单位名 string
* nameLike 项目名关键字模糊查询 string
* isLngAndLatNotNull 经纬度是否非空，0为否，1为是，默认为0 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg	提示信息 string
* draw 前端传入数据 string
* total 记录总条数 int
* data 项目数组 array
    *  id 项目编号 int
    *  name 项目全称 string
    *  lng 经度 decimal
    *  lat 纬度 decimal
    *  cbFetureDis 城建性质释义 string
    *  prjStartYear 项目计划开始年份 int
    *  prjEndYear 项目计划竣工年份 int
    *  planStartYear 本期计划开始年份 int
    *  planEndYear 本期计划竣工年份 int
    *  accmPlanInvest 当年至本月累计计划投资，单位万元 int
    *  accmActualInvest 当年至本月累计实际投资，单位万元 int
    *  yearPlanInvest 年度计划投资，单位万元 int
    *  completeRateByMonth 月度投资完成百分比 int
    *  completeRateByYear 年度投资完成百分比 int
    *  isFundPrj 是否经费开支项目，0为否，1为是 int
    *  ownerName 所有业主单位名称,多个以逗号分隔 string
    *  completeStatusDis 完成进度，即正常、超前、滞后 string
    *  labelArray 标签数组 array
    *  starNum 重点星数 int
    *  prjInvestTotal 项目计划总投资 int

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
			"lng":103.5,
			"lat":22.15,
			"cbFetureDis":"续建",
			"prjStartYear":"2017",
			"prjEndYear":"2018",
			"planStartYear":"2017",
			"planEndYear":"2018",
			"accmPlanInvest":3200,
			"accmActualInvest":3000,
			"yearPlanInvest":15000,
			"completeRateByMonth":94,
			"completeRateByYear":20,
			"ownerName":"xxxxxxxxx",
			"completeStatusDis":"正常",
			"isFundPrj":0,
			"starNum":1
			"labelArray":["60周年"],
			"prjInvestTotal":0
		}
	]
}
</pre>

## 错误码 - 无
