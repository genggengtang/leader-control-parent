## 获取南宁市空气质量实时数据
#### 需添加授权请求头 2018-9-3

## 接口地址 /get-valid-aqi-nn

## 请求参数 - 无

## 返回结果
* apiDate 数据时间，格式为"yyyy-mm-dd hh:MM:ss" date
* pm251h 实时PM2.5浓度 double
* pm101h 实时PM10浓度 duoble
* aqi 空气质量指数 int

## 返回例子
<pre>
{
  "apiDate": "2018-05-22 15:00:00.0",
  "pm101h": 23,
  "pm1024h": 41,
  "pm251h": 18,
  "pm2524h": 21,
  "aqi": 35,
  "quality": "优",
  "areaId": 2,
  "epNum": 0,
  "epName": "全市",
  "so21h": 8,
  "so224h": 9,
  "no21h": 14,
  "no224h": 24,
  "co1h": 0.6,
  "co24h": 0.8,
  "o31h": 109,
  "o3124h": 107,
  "o38h": 72,
  "o3824h": 32,
  "displayName": "全市平均AQI"
}
</pre>

## 错误码 - 无
