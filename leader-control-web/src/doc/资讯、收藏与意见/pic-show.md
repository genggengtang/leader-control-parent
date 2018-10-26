## 轮播图列表2.0
#### 添加授权请求头

## 接口地址 /pic-show

## 请求参数 - 无


## 返回结果 - 数组
* id 编号 int
* prjType 项目类型，对应字典表214字段 int
* prjId 项目编号 int
* picUrl 图片url地址 string
* activeOrder 图片顺序,升序排列 int
* title 标题 string
* readable 是否可以查看项目详情 boolean


## 返回例子
<pre>
[
  {
    "id": 3,
    "prjType": 21401,
    "prjId": 21002,
    "picUrl": "ttttt.jpg",
    "activeOrder": 1,
    "title":"tttt",
    "readable":true
  },
  {
    "id": 1,
    "prjType": 21401,
    "prjId": 21000,
    "picUrl": "xxxxxx.jpg",
    "activeOrder": 2,
    "title":"xxxx",
    "readable":true
  }
]
</pre>

## 错误码 - 无
