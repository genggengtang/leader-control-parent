package org.zxs.leader.control.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class HtmlParseTest {
	
	@Test
	public void testParseHtml() throws IOException {
		Document doc = null;
		doc = Jsoup.connect("http://p53wzuaxq.bkt.clouddn.com/html/1525141540357.html").get();
        
        Elements p = doc.select("span");
        System.out.println(p.size());
        String picName = "";
        for(int i=1;i<p.size() - 2;i++) {
			if(i > 1)
				picName += ",";
			picName += p.get(i).text();
		}
        System.out.println(picName);
    }
}
