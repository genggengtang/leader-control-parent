## 发送随手拍
#### 发送成功后，往群聊组发送一条随手拍消息；若群组不存在，则新建聊天室，然后发送随手拍消息
#### 需添加授权请求头

## 接口地址 /create-topic
#### POST

## 请求参数
* cgId 群聊组编号 int
* userArray 用户编号数组序列化 string 前两项二选一
* picName 图片文件名 string 非空
* picFile 图片文件内容经base64编码 string 非空
* content 描述内容，500字以内 string 非空

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"发送随手拍成功！"
}
</pre>

## 错误码
* -302 创建群聊失败
* -321 发送随手拍失败
