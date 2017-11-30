package com.apicenter.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.apicenter.util.http.bean.HttpResult;

public class HttpUtils {
	/**
	 * 发送GET请求
	 * 
	 * @param url
	 *            目的地址
	 * @param parameters
	 *            请求参数，Map类型。
	 * @return 远程响应结果
	 */
	private static HttpResult sendGet(String url, Map<String, String> parameters, Map<String, String> requestHeaders,String cookie) {
		String result = "";
		BufferedReader in = null;// 读取响应输入流
		StringBuffer sb = new StringBuffer();// 存储参数
		String params = "";// 编码之后的参数
		java.net.HttpURLConnection httpConn = null;
		try {
			// 编码请求参数
			if(parameters.size()>0) {
				if (parameters.size() == 1) {
					for (String name : parameters.keySet()) {
						sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
					}
					params = sb.toString();
				} else {
					for (String name : parameters.keySet()) {
						sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
								.append("&");
					}
					String temp_params = sb.toString();
					params = temp_params.substring(0, temp_params.length() - 1);
				}
			}
			String full_url = url + "?" + params;
			// 创建URL对象
			java.net.URL connURL = new java.net.URL(full_url);
			// 打开URL连接
			httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// 设置通用属性
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// 设置用户自定义的请求头
			for (String key : requestHeaders.keySet()) {
				httpConn.setRequestProperty(key, requestHeaders.get(key));
			}
			// cookie
			if(!StringUtils.isEmpty(cookie)) {
				httpConn.setRequestProperty("Cookie", cookie);
			}
			// 建立实际的连接
			httpConn.connect();
			// 定义BufferedReader输入流来读取URL的响应,并设置编码方式
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		HttpResult httpResult = getHttpResult(httpConn, requestHeaders);
		httpResult.setResult(result);
		return httpResult;
	}

	/**
	 * 发送POST请求
	 * 
	 * @param url
	 *            目的地址
	 * @param parameters
	 *            请求参数，Map类型。
	 * @return 远程响应结果
	 */
	private static HttpResult sendPost(String url, Map<String, String> parameters, Map<String, String> requestHeaders,String cookie) {
		String result = "";// 返回的结果
		BufferedReader in = null;// 读取响应输入流
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();// 处理请求参数
		String params = "";// 编码之后的参数
		java.net.HttpURLConnection httpConn = null;
		try {
			// 编码请求参数
			if(parameters.size()>0) {
				if (parameters.size() == 1) {
					for (String name : parameters.keySet()) {
						sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
					}
					params = sb.toString();
				} else {
					for (String name : parameters.keySet()) {
						sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
								.append("&");
					}
					String temp_params = sb.toString();
					params = temp_params.substring(0, temp_params.length() - 1);
				}
			}
			// 创建URL对象
			java.net.URL connURL = new java.net.URL(url);
			// 打开URL连接
			httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// 设置通用属性
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// 设置用户自定义的请求头
			for (String key : requestHeaders.keySet()) {
				httpConn.setRequestProperty(key, requestHeaders.get(key));
			}
			// cookie
			if(!StringUtils.isEmpty(cookie)) {
				httpConn.setRequestProperty("Cookie", cookie);
			}
			// 设置POST方式
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			// 获取HttpURLConnection对象对应的输出流
			out = new PrintWriter(httpConn.getOutputStream());
			// 发送请求参数
			out.write(params);
			// flush输出流的缓冲
			out.flush(); 
			// 定义BufferedReader输入流来读取URL的响应，设置编码方式
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		HttpResult httpResult = getHttpResult(httpConn, requestHeaders);
		httpResult.setResult(result);
		return httpResult;
	}

	/**
	 * 处理返回数据
	 * <p>
	 * 
	 * @param httpConn
	 * @param requestHeaders
	 * @return
	 * @return HttpResult
	 * @author ben
	 * @date 2017年11月29日 下午4:15:54
	 * @Description: TODO
	 */
	private static HttpResult getHttpResult(java.net.HttpURLConnection httpConn, Map<String, String> requestHeaders) {
		HttpResult httpResult = new HttpResult();
		try {
			// 响应头部获取
			Map<String, List<String>> headers = httpConn.getHeaderFields();
			List<String> responseHeaders = new ArrayList<String>();
			// 遍历所有的响应头处理要返回的对象
			for (String key : headers.keySet()) {
				String responseHeader = key + ":>>>" + headers.get(key);
				responseHeaders.add(responseHeader);
			}
			httpResult.setResponseHeaders(responseHeaders);
			List<String> requestHeadersList = new ArrayList<String>();
			// 遍历自定义请求头处理要返回的对象
			for (String key : requestHeaders.keySet()) {
				String requestHeader = key + ":>>>" + requestHeaders.get(key);
				requestHeadersList.add(requestHeader);
			}
			httpResult.setRequestHeaders(requestHeadersList);
			List<String> generals = new ArrayList<>();
			generals.add("Request URL:>>>" + httpConn.getURL());
			generals.add("Request Method:>>>" + httpConn.getRequestMethod() + "   " + "HTTP/1.1");
			generals.add("Status Code:>>>" + httpConn.getResponseCode() + "   " + httpConn.getResponseMessage());
			httpResult.setGeneral(generals);
			return httpResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpResult;
	}

	/**
	 * send
	 * <p>
	 * 
	 * @param manner
	 * @param url
	 * @param parameters
	 * @param requestHeaders
	 * @return
	 * @return HttpResult
	 * @author ben
	 * @date 2017年11月29日 下午5:22:15
	 * @Description: TODO
	 */
	public static HttpResult send(String manner, String url, Map<String, String> parameters,
			Map<String, String> requestHeaders,String cookie) {
		if (requestHeaders == null) {
			requestHeaders = new HashMap<>();
		}
		if (parameters == null) {
			parameters = new HashMap<>();
		}
		HttpResult httpResult = new HttpResult();
		switch (manner) {
		case "POST":
			httpResult = sendPost(url, parameters, requestHeaders,cookie);
			break;
		case "GET":
			httpResult = sendGet(url, parameters, requestHeaders,cookie);
			break;
		default:
			break;
		}
		return httpResult;
	}

	/**
	 * 主函数，测试请求
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		 Map<String, String> parameters = new HashMap<String, String>();
		 parameters.put("page", "1");
		 parameters.put("cityId", "1");
		 System.out.println(send("POST","http://test.allxiu.com/v2/home/list/sxp/home",parameters,null,null));
	}
}
