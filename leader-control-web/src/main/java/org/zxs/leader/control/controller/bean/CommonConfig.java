package org.zxs.leader.control.controller.bean;

import org.springframework.stereotype.Component;

@Component("commonConfig")
public class CommonConfig {
	private String serverPre; // 服务器地址前缀,用于月进度url

	public String getServerPre() {
		return serverPre;
	}

	public void setServerPre(String serverPre) {
		this.serverPre = serverPre;
	}

}
