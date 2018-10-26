package org.zxs.leader.control.util;

import java.io.IOException;

import org.junit.Test;

public class PhoneModelTest {
	@Test
	public void testPhoneModel() throws IOException {
		String userAgent = "Mozilla/5.0 (Linux; Android 7.0; AGS-W09 Build/HUAWEIAGS-W09; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/59.0.3071.125 Safari/537.36 Html5Plus/1.0";
		System.out.println(UserAgentUtil.getPhoneModel(userAgent));
    }
}
