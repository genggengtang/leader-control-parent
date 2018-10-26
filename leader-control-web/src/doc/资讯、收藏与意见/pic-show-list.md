## 轮播图列表1.0
#### 返回参数添加title 2018-4-25
#### 添加授权请求头，返回字段添加用户是否可查看项目详情标记 2018-7-11
#### 还原旧逻辑，不加授权头 2018-7-20

## 接口地址 /pic-show-list

## 请求参数 - 无


## 返回结果 - 数组
* id 编号 int
* prjType 项目类型，对应字典表214字段 int
* prjId 项目编号 int
* picUrl 图片url地址 string
* activeOrder 图片顺序,升序排列 int
* title 标题 string


## 返回例子
<pre>
[
  {
    "id": 3,
    "prjType": 21401,
    "prjId": 21002,
    "picUrl": "ttttt.jpg",
    "activeOrder": 1,
    "title":"tttt"
  },
  {
    "id": 1,
    "prjType": 21401,
    "prjId": 21000,
    "picUrl": "xxxxxx.jpg",
    "activeOrder": 2,
    "title":"xxxx"
  }
]
</pre>

## 错误码 - 无
