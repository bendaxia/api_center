package com.apicenter.util.http.bean;

import java.util.List;

public class HttpResult {
	/**
	 * 请求返回的数据
	 */
	String result;
	/**
	 * 响应头信息
	 */
	List<String> responseHeaders;
	/**
	 * 请求头信息
	 */
	List<String> requestHeaders;
	/**
	 * 基本信息
	 */
	List<String> general;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<String> getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(List<String> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public List<String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(List<String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public List<String> getGeneral() {
		return general;
	}

	public void setGeneral(List<String> general) {
		this.general = general;
	}

}
