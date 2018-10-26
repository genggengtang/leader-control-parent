## 城建计划项目地图列表
#### 全表检索，不分页，默认按照项目录入时间升序排列
#### 需添加授权请求头
#### 6级用户只能查到自己负责的项目
#### 请求参数添加isSelf、isFavorite 2018-4-25
#### 请求参数添加nameLike 2018-5-7
#### 返回参数添加prjInvestTotal 2018-6-1

## 接口地址 /cb/prj-list

## 请求参数
* prjId 项目计划编号 int
* orgId 项目业主单位编号 int
* rspLeaderId 项目责任领导编号 int
* areaId 区域编号 int
* cbFeture 城建性质，对应字段表215 int
* cbType 城建项目分类，参见字典表216 int
* label 重大项目分类标签，对应字典表217 int
* month 年月，即当月开工或在建的项目，格式为"yyyy-MM" string
* planNo 计划代号，对应字典表218字段，默认查询21803 int
* isKeyPrj 是否重点项目，0为否，1为是，默认0 int
* keyword 关键字模糊查询，可为项目名、联系领导名、业主单位名 string
* isLngAndLatNotNull 经纬度是否非空，0为否，1为是，默认为1 int
* isSelf 是否领导自己负责项目，0为否，1为是 int
* isFavorite 是否查询关注项目，0为否，1为是 int
* nameLike 项目名模糊查询 string

## 返回结果 - 数组
* id 计划项目编号 int
* name 项目名称 string
* lng 经度 decimal
* lat 纬度 decimal
* cbFeatureDis 城建性质释义 string
* accmPlanInvest 当年至本月累计计划投资，单位万元 int
* accmActualInvest 当年至本月累计实际投资，单位万元 int
* isFundPrj 是否经费开支项目，0为否，1为是 int
* isCurrentPlan 是否最新计划期，0为否，1为是 int
* completeStatusDis 完成进度，即正常、超前、滞后 string
* buildStatus 建设状态，1为新开工，2为在建 int
* labelArray 标签数组 array
* starNum 重点星数 int
* prjInvestTotal 项目计划总投资 int

## 返回例子
<pre>
[
	{
		"id":1234567890,
		"name":"邕江综合整治和开发利用工程",
		"lng":103.5,
		"lat":22.15,
		"cbFetureDis":"前期",
		"accmActualInvest":3000,
		"accmPlanInvest":15000,
		"isFundPrj":0,
		"isCurrentPlan":0,
		"completeStatusDis":"正常",
		"buildStatus":1,
		"starNum":0,
		"labelArray":[],
		"prjInvestTotal":0
	}
]
</pre>

## 错误码 - 无
