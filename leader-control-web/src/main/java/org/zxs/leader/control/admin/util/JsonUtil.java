package org.zxs.leader.control.admin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zxs.leader.control.admin.controller.common.NavsController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	private static final Log logger = LogFactory.getLog(NavsController.class);
	
	/*
	 * 返回JSON对象
	 */
	public static JSONObject getJsonObjectByFileName(String fileName) {
		JSONObject jsonData = new JSONObject();
		try {
			File file = new File(fileName);
			InputStream inputStream = new FileInputStream(file);
			String jsonStr = IOUtils.toString(inputStream,"utf8");
			jsonData = (JSONObject) JSON.parse(jsonStr);
		} catch (IOException e) {
			logger.info(String.format("系统找不到指定的文件[%s]", fileName));
		}
		return jsonData;
	}

	/*
	 * 返回JSON数字对象
	 */
	public static JSONArray getJsonArrayByFileName(String fileName) {
		JSONArray jsonData = new JSONArray();
		try {
			File file = new File(fileName);
			InputStream inputStream = new FileInputStream(file);
			String jsonStr = IOUtils.toString(inputStream,"utf8");
			jsonData = (JSONArray) JSON.parse(jsonStr);
		} catch (IOException e) {
			logger.info(String.format("系统找不到指定的文件[%s]", fileName));
		}
		return jsonData;
	}

}
