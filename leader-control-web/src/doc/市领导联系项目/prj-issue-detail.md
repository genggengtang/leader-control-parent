## 项目沟通详情

## 接口地址 /prj-issue-detail/{id}

## 请求参数
* {id} 编号,非空 int

## 返回结果
*  issueId 编号 int
*  title 标题 string
*  issueType 问题类型 string
*  issueDt 提出日期，格式为"yyyy-MM-dd" date
*  action 解决措施 string
*  attachmentName 会议纪要等附件名，多个以逗号分隔 string
*  attachmentUrl 会议纪要等附件URL，多个以逗号分隔 string

## 返回例子
<pre>
{
  "title": "dddd",
  "issueType": "征拆原因",
  "issueDt": "2018-03-11",
  "content": "dddddddd",
  "contentSub": "dddddddd",
  "action": "dddddddd",
  "attachmentName": "ddddddddd",
  "attachmentUrl": "dddddd",
  "issueId": 2
}
</pre>

## 错误码 - 无
