package org.zxs.leader.control.service.util;

import java.util.HashMap;
import java.util.Map;

public class ExceptionMessageTranslator {
	
	final private static Map<String, String> wordDict = new HashMap<String, String>();
	
	static {
		wordDict.put("cannot", "不能");
		wordDict.put("can't", "不能");
		wordDict.put("can not", "不能");
		wordDict.put("be", "为");
		wordDict.put("null", "空");
		wordDict.put("column", "字段");
		wordDict.put("duplicate", "重复");
		wordDict.put("entry", "记录");
		wordDict.put("for", "原因是");
		wordDict.put("key", "违反主键唯一性");
		wordDict.put("data", "数据");
		wordDict.put("truncation", "截断");
		wordDict.put("out", "超");
		wordDict.put("of", "出");
		wordDict.put("range", "范围");
		wordDict.put("at", "位于");
		wordDict.put("row", "行号:");
		wordDict.put("value", "值");
	}
	
	/**
	 * 
	* @Title: translate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param message
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月8日 下午3:45:44
	 */
	public static String translate(String message) {
		StringBuilder transBuild = new StringBuilder();
		String[] words = message.split(" ");
		for (String word : words) {
			String trans = wordDict.get(word.toLowerCase().replaceAll("[^a-zA-Z]", ""));
			if (null != trans) {
				transBuild.append(trans);
			} else {
				transBuild.append(word);
			}
		}
		return transBuild.toString();
	}

}
