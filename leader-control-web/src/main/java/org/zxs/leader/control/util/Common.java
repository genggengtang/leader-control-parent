//package org.zxs.leader.control.util;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Properties;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.zxs.base.model.Mail;
//
//public class Common {
//
//	private static Log log = LogFactory.getLog(Common.class);
//
//	static {
//		init();
//	}
//
//	private static String tokenExpireTime;
//
//	
//	
//	private static void init() {
//		String commonPath = "config/common.properties";
//		String os = System.getProperty("os.name");
//		if(os.toLowerCase().startsWith("win")){  
//			commonPath = "config/common_win.properties";
//		} else {
//			commonPath = "config/common_linux.properties";
//		}
//		
//		Properties pps = new Properties();
//		try {
//			pps.load(new InputStreamReader(
//					Common.class.getClassLoader().getResourceAsStream(commonPath), "utf-8"));
//		
//			tokenExpireTime = pps.getProperty("token.expire.time");
//
//		} catch (IOException e) {
//			log.error(e.getMessage(), e);
//		}
//	}
//
//
//	public static String getTokenExpireTime() {
//		return tokenExpireTime;
//	}
//	
//}
