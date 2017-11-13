package com.apicenter.core.api.views.group;

import java.util.List;

/**
 * 分组view
 * @author ben
 * @ClassName: ApiGroup 
 * @Description: TODO
 * @date 2017年9月12日 下午2:56:00
 */
public class ApiGroup {
	
	/**
	 * 分组的名称
	 */
	private String gruopName;

	/**
	 * 分组详细内容
	 */
	private List<ApiGroupDetails> apiGroupDetails;

	public String getGruopName() {
		return gruopName;
	}

	public void setGruopName(String gruopName) {
		this.gruopName = gruopName;
	}

	public List<ApiGroupDetails> getApiGroupDetails() {
		return apiGroupDetails;
	}

	public void setApiGroupDetails(List<ApiGroupDetails> apiGroupDetails) {
		this.apiGroupDetails = apiGroupDetails;
	}
	
	
}
