package org.zxs.leader.control.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentUtil {
	private static String android="android";    
	private static String iphone="iphone";    
	private static String ipad="ipad";  
	private static String noDevice="未知设备";  
      
    //获取用户UA信息  
    public static String getUaInfo(HttpServletRequest request){  
          
        if(null == request) return "";  
        return request.getHeader("User-Agent");  
    }     
      
    //获取用户Browser信息  
    public static String getBrowser(String ua){  
          
        if(null == ua) return "";  
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);  
        Browser browser = userAgent.getBrowser();  
        return browser.toString();  
    }  
      
    //获取用户os信息  
    public static String getOS(String ua){  
          
        if(null == ua) return noDevice;  
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);  
        OperatingSystem os = userAgent.getOperatingSystem();  
        return os.toString();  
    }  
      
    //获取移动用户操作系统    
    public static String getMobileOS(String userAgent){
    	String ua = userAgent.toLowerCase();
        if (ua.contains(android)) {    
            return android;    
        }else if (ua.contains(iphone)){    
            return iphone;    
        }else if (ua.contains(ipad)){    
            return ipad;    
        }else {    
            return "other";  
        }    
    }    
      
    //获取用户手机型号    
    public static String getPhoneModel(String userAgent){  
        if(null == userAgent || "" == userAgent) return noDevice;  
          
        String os = getMobileOS(userAgent.toLowerCase());
        
        if(os.equals(iphone)){  
        	String[] str=userAgent.split("[()]+");    
        	String res="iphone"+str[1].split("OS")[1].split("like")[0];    
        	return res;  
        }else if(os.equals(ipad)) {
        	return ipad; 
        }else if(os.equals(android)) {
        	Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/(\\S*);.*");  
            Matcher matcher = pattern.matcher(userAgent);  
            String model = "";  
            if (matcher.find()) {  
                model = matcher.group(3).trim();  
            }
            return model;
        }
        return getOS(userAgent); 
    }    
}
