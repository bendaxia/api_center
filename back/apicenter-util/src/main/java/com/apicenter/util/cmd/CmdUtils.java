package com.apicenter.util.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CmdUtils {

	/**
	 * 执行
	 * <p>
	 * 
	 * @param cmd
	 * @return String
	 * @author ben
	 * @date 2017年11月30日 下午2:52:00
	 * @Description: TODO
	 */
	private static String execute(String cmd) {
		try {
			Process ps = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 性能测试
	 * <p>
	 * 
	 * @param concurrentintNum
	 *            并发数
	 * @param requestCount
	 *            请求数
	 * @param url
	 * @return
	 * @return String
	 * @author ben
	 * @date 2017年11月30日 下午3:20:21
	 * @Description: TODO
	 */
	public static String abPerformanceTesting(int concurrentintNum, int requestCount, String url, Map<String, String> headers,
			Map<String, String> params, String cookie) {
		String header = "";
		if (!headers.isEmpty()) {
			for (String key : headers.keySet()) {
				header += " -H '" + key + ":" + headers.get(key) + "'";
			}
			if (!StringUtils.isEmpty(cookie)) {
				header += " -H 'Cookie:" + cookie + "'";
			}
		}
		String param = "?";
		if (!params.isEmpty()) {
			for (String key : params.keySet()) {
				param += key + "=" + params.get(key) + "&";
			}
		}
		String cmd = "ab -c " + concurrentintNum + " -n " + requestCount + " " + header + " " + url + param;
		return execute(cmd);
	}
}
