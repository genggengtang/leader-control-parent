## 项目摘要详情
#### 需添加授权请求头
#### 返回结果添加cbTypeDis、address、planStartYear、planEndYear 2018-4-24
#### 返回值中添加项目计划起止年限 2018-5-4
#### 删除返回值prjInvestTotal，添加yearPlanInvest 2018-5-10

## 接口地址 /cb/simple-detail/{id}

## 请求参数
* {id} 项目编号,非空 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data object 返回数据
    *  id 项目编号 int
    *  name 项目全称 string
    *  cbFeatureDis 城建性质释义 string
    *  cbTypeDis 工程类型 string
    *  isFundPrj 是否经费开支项目，0为否，1为是 int
    *  labelArray 标签数组 array
    *  starNum 重点星数 int
    *  prjDbNo 项目库编号 string
    *  address 项目地址 string
    *  planInvestTotal 项目计划总投资，单位万元 int
    *  prjStartYear 项目计划开始年份 int
    *  prjEndYear 项目计划竣工年份 int
    *  planStartYear 本期计划开始年份 int
    *  planEndYear 本期计划结束年份 int
    *  planStartDate 计划开始日期，格式为"yyyy-MM-dd" date
    *  planEndDate 计划竣工日期，格式为"yyyy-MM-dd" date
    *  prjContent 主要建设规模及主要建设内容 string
    *  content 本期主要建设内容 string
    *  areaName 所属区域，多个区域以逗号分隔 int
    *  adminOrgName 主管单位,多个以逗号分隔 string
    *  isCurrentPlan 是否当前期数，0为否，1为是 int
    *  remark 备注 string
    *  favoriteId 关注编号 int
    *  yearPlanInvest 当期计划总投资，单位万元 int
    *  ownerList 业主集合 array
        *  orgName 业主单位名 string
        *  userName 业主负责人姓名 string
        *  mobilePhone 业主负责人联系手机号 string
    *  sourceFundList 资金源集合 array
        *  sourceName 资金来源名称 string
        *  sourceTypeName 资金来源分类名称 string
        *  planInvest 计划投资额，单位万元 int
        *  actualInvest 实际投资额，单位万元 int
        *  restInvest 未落实投资额，单位万元 int

## 返回例子
<pre>
{
	"errorCode":0，
	"errorMsg":"查询城建项目详情成功!",
	"data":{
		"id":12345678,
		"name":"邕江综合整治和开发利用工程",
		"cbFeatureDis":"预备",
		"cbTypeDis":"五象新区项目",
		"isFundPrj":0,
		"starNum":1,
		"labelArray":["60周年"],
		"prjDbNo":"2017-450114-48-01-900353",
		"address":"",
		"planInvestTotal":600000,
		"yearPlanInvest":200000,
		"prjStartYear":2017,
		"prjEndYear":2017,
		"planStartYear":2017,
		"planEndYear":2017,
		"planStartDate":"2017-02-01",
		"planEndDate":"2017-12-31",
		"prjContent":"xxxxxxxxxxxxxxxxxxxxxxxxx",
		"content":"cccccccccccc",
		"isCurrentPlan":0,
		"areaName":"青秀区,兴宁区",
		"remark":"",
		"adminOrgName":"市发改委,市交通管理局"
		"favoriteId":null,
		"ownerList":[{
			"orgName":"市交警支队",
			"userName":"xxx",
			"mobilePhone":"13xxxxxxxxx"
		}],
		"sourceFundList":[{
			"sourceName":"市本级财政投资",
			"sourceTypeName":"市财政",
			"planInvest":500,
			"actualInvest":500,
			"restInvest":0
		}]
	}
}
</pre>

## 错误码
* -203 您查询的项目编号不存在！
* -204 您查询的用户编号不存在！
