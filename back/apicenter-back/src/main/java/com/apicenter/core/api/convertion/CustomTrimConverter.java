package com.apicenter.core.api.convertion;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 去掉前后空格
 * @author zl
 * 
 */
public class CustomTrimConverter implements Converter<String, String>{
	public String convert(String source) {
		try {
			// 判断不是Null
			if (null != source) {
				//空字符串过滤     emoji过滤掉
				source = source.trim().replaceAll("[^\\u0000-\\uFFFF]", "");
				// 判断是否为空串
				if (!StringUtils.isEmpty(source)) {
					return source;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}
}