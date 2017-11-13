package com.apicenter.core.api.views.group;
/**
 * 分组明细view
 * @author ben
 * @ClassName: ApiGroupDetails 
 * @Description: TODO
 * @date 2017年9月12日 下午2:56:16
 */
public class ApiGroupDetails {
	/**
	 * api的id
	 */
	private int apiId;
	/**
	 * api的名称
	 */
	private String apiName;
	public int getApiId() {
		return apiId;
	}
	public void setApiId(int apiId) {
		this.apiId = apiId;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
}
