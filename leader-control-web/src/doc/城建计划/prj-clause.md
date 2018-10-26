## 城建计划项目分类及重点分类条件查询

## 接口地址 /cb/prj-clause

## 请求参数
* planNo 城建计划期数，对应字典表218字段，非空 int

## 返回结果
* cbTypeList 城建项目分类 array
    *  id 选项值 int
    *  valueRemark 选项名字 string
* cbLabelList 城建重点项目分类 array
    *  id 选项值 int
    *  valueRemark 选项名字 string

## 返回例子
<pre>
{
  "cbTypeList": [
    {
      "id": 21601,
      "valueRemark": "五象新区项目"
    }],
    "cbLabelList": [
    {
      "id": 21701,
      "valueRemark": "迎接自治区成立60周年重大城建项目"
    }]
}
    
</pre>

## 错误码 - 无
