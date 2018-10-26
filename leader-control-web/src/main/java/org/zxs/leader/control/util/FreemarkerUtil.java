package org.zxs.leader.control.util;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * freemarker生成HTML页面工具
 * @author Administrator
 *
 */
public class FreemarkerUtil {
	/** 
     * 通过指定的名字获取相应的模板 
     * @param fileName 模板文件名
     * @return 
	 * @throws IOException 
     */  
//    private static Template getTemplate(String fileName) throws IOException {  
//        Configuration cfg = new Configuration();  
//        cfg.setOutputEncoding("UTF-8");  
//        cfg.setDefaultEncoding("UTF-8");// 编码设置1    
//        cfg.setEncoding(Locale.CHINA, "UTF-8");  
//        //设定读取ftl模板文件的目录  
//        cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/tmpl");     //读取src目录下  
//        // cfg.setServletContextForTemplateLoading(request.getSession().getServletContext(), "/template"); //读取webroot目录下  
//        //在模板文件目录中找到名称为name的文件,并加载为模板  
//        Template template = cfg.getTemplate(fileName);  
//        template.setEncoding("UTF-8");// 编码设置2  
//        return template;  
//    }
    
    /** 
     * 通过指定的文件目录和文件名生成相应的文件,返回生成文件名地址
     * @param templateName 
     * @param filePath 
     * @throws IOException 
     * @throws TemplateException 
     */  
    public static <T> String printToFile(Template template,String filePath, T root) throws TemplateException, IOException {  
    	Writer writer = null;  
        try {  
            //判断多级目录是否存在，不存在则一级级创建  
//            String[] paths = fileDir.split("\\\\");//注意：此处“\\”是错误的，必须要“\\\\”才能分割字符串  
//            String dir = paths[0];  
//            for (int i = 1; i < paths.length; i++) {  
//                dir = dir + File.separator + paths[i];  
//                File file=new File(dir.toString());  
//                if (!file.exists()) {  
//                    file.mkdir();  
//                }  
//            }  
            //创建输出流  
			File file = new File(filePath);    
                 
            //设置生成的文件编码为UTF-8     
            //服务器不支持UTF-8格式HTML时候使用ANSI格式HTML文件，即系统默认编码     
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));  // 编码设置3  
            //writer = new FileWriter(fileDir +File.separator+ fileName);  
            //输出模板和数据模型都对应的文件  
            template.process(root, writer); 
            
            return filePath;
        }  finally {  
            if(writer!=null){  
                writer.close();  
            }  
        }  
    }
}
