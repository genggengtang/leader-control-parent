## 获取项目内容或进度图片
#### 请求参数添加月份，返回参数添加年份数组 2018-4-25
#### 修改返回数据为单个对象，当无数据返回空；当有数据时，返回值中yearArray非空 2018-4-26

## 接口地址 /prj-chart

## 请求参数
* prjType 项目类型，对应字典表214字典 int
* chartType 图表类型，1为项目内容，2为项目进度,默认为1 int
* year 年份，默认当前年 int
* month 月份，当图表类型为2时默认当前月 int

## 返回结果
* id 编号 int
* prjType 项目类型 int
* chartType 图表类型 int
* year 年份 int
* month 月份 int
* url 图片url string
* yearArray 年份数组 array

## 返回例子
<pre>
  {
    "id": 2,
    "prjType": 21401,
    "chartType": 2,
    "year": 2018,
    "month": 1,
    "url": "bbbbb.jpg",
    "yearArray":["2018"]
  }
</pre>

## 错误码 - 无
