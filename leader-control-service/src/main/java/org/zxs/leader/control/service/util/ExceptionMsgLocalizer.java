package org.zxs.leader.control.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionMsgLocalizer {
	
	public static Map<String, String> fieldMap = new HashMap<String, String>();
	
	public static Map<String, String> causeMap = new HashMap<String, String>();
	
	static {
		// database schema fields dictionary
		fieldMap.put("id", "编号");
		fieldMap.put("last_year_id", "关联的最新年记录编号");
		fieldMap.put("full_name", "项目全称");
		fieldMap.put("short_name", "项目简称");
		fieldMap.put("lng", "经度");
		fieldMap.put("lat", "纬度");
		fieldMap.put("rsp_leader_id", "责任领导编号");
		fieldMap.put("contact_leader_id", "联系领导编号");
		fieldMap.put("contact_id", "牵头单位联系人");
		fieldMap.put("type", "服务类别");
		fieldMap.put("content", "项目内容");
		fieldMap.put("total_invest", "总投资额");
		fieldMap.put("actual_invest", "实际总投资额");
		fieldMap.put("submit_org_id", "填报单位编号");
		fieldMap.put("industry", "行业");
		fieldMap.put("plan_status", "建设阶段");
		fieldMap.put("actual_status", "实际建设阶段");
		fieldMap.put("area_id", "所属区域编号");
		fieldMap.put("plan_start_dt", "计划开工时间");
		fieldMap.put("actual_start_dt", "实际开工时间");
		fieldMap.put("plan_end_dt", "计划竣工日期");
		fieldMap.put("actual_end_dt", "实际竣工日期");
		fieldMap.put("is_60th_welfare", "是否60周年公益项目");
		fieldMap.put("is_prvc_plan", "是否区统筹");
		fieldMap.put("owner_org_name", "业主单位名");
		fieldMap.put("remark", "备注");
		fieldMap.put("remark_display", "需要展示的备注");
		fieldMap.put("create_at", "创建时间");
		fieldMap.put("update_at", "最后更新时间");
		fieldMap.put("is_deleted", "是否已经软删除");
		
		// exception causes dictionary
		causeMap.put("cannot be null", "不能为空");
	}
	
	public static String translate(String causeMsg) {
		StringBuilder retStr = new StringBuilder();
		retStr.append("字段");
		List<String> fields = findStrBtwnQuotes(causeMsg);
		List<String> translatedFields = new ArrayList<>();
		for (String field : fields) {
			translatedFields.add(fieldMap.get(field) == null ? "" : fieldMap.get(field));
		}
		
		for (String cause : causeMap.keySet()) {
			if (causeMsg.contains(cause)) {
				retStr.append(translatedFields.toString() + causeMap.get(cause));
			}
		}
		
		return retStr.toString();
	}
	
	public static List<String> findStrBtwnQuotes(String str) {
		Pattern p = Pattern.compile("'([^\\s']+)'");
		Matcher m = p.matcher(str);
		
		List<String> fieldsArray = new ArrayList<>();
		while (m.find()) {
			for (int i = 1; i <= m.groupCount(); i++) {
				fieldsArray.add(m.group(i));
	        }
		}
		return fieldsArray;
	}

}
