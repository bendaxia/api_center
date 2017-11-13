package com.apicenter.core.api.common;

import java.util.HashMap;

import com.apicenter.util.json.JsonUtils;

public class Response {
	public static final int OK = 200;// 成功
	public static final int OPERATION_FAIL = 201;// 失败
	public static final int ARRAY_IS_EMPTY = 300;//数据为空
	public static final int ERROR = 500;// 服务器错误

	/**
	 * ok
	 * <p>
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月8日 下午7:13:09 
	 * @Description: TODO
	 */
	public static String ok() {
		Response response = new Response();
		response.setCode(OK);
		response.setMessage("成功!");
		try {
			return JsonUtils.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ok
	 * <p>
	 * @param message
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月8日 下午7:14:31 
	 * @Description: TODO
	 */
	public static String ok(String message) {
		Response response = new Response();
		response.setCode(OK);
		response.setMessage(message);
		try {
			return JsonUtils.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ok
	 * <p>
	 * @param data
	 * @param message
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月8日 下午7:14:37 
	 * @Description: TODO
	 */
	public static String ok(Object data,String message) {
		Response response = new Response();
		response.setCode(OK);
		response.setMessage(message);
		response.setData(data);
		try {
			return JsonUtils.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * error
	 * <p>
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月8日 下午7:16:36 
	 * @Description: TODO
	 */
	public static String error(){
		Response response = new Response();
		response.setCode(ERROR);
		response.setMessage("服务器内部错误");
		try {
			return JsonUtils.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * fail
	 * <p>
	 * @param message
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月8日 下午7:27:25 
	 * @Description: TODO
	 */
	public static String fail(String message) {
		Response response = new Response();
		response.setCode(OPERATION_FAIL);
		response.setMessage(message);
		try {
			return JsonUtils.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 数据为空
	 * <p>
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月12日 下午3:02:09 
	 * @Description: TODO
	 */
	public static String empty() {
		Response response = new Response();
		response.setCode(ARRAY_IS_EMPTY);
		response.setMessage("数据为空");
		try {
			return JsonUtils.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 基本响应码
	 */
	private int code;

	/**
	 * 描述信息
	 */
	private String message;

	/**
	 * 基本对象
	 */
	private Object data = new HashMap<Object, Object>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
