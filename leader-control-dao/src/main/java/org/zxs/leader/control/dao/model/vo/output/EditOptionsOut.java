package org.zxs.leader.control.dao.model.vo.output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zxs.leader.control.dao.model.DictHeader;

public class EditOptionsOut {
	
	private List<DictHeader> headers;
	
	private Map<String, List<OptionsOut>> options;
	
	public EditOptionsOut() {
		this.options = new HashMap<>();
	}

	public List<DictHeader> getHeaders() {
		return headers;
	}

	public void setHeaders(List<DictHeader> headers) {
		this.headers = headers;
	}

	public Map<String, List<OptionsOut>> getOptions() {
		return options;
	}

	public void setOptions(Map<String, List<OptionsOut>> options) {
		this.options = options;
	}
	
}
