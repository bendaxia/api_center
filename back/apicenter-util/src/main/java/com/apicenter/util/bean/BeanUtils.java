package com.apicenter.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;

public class BeanUtils {

	private static BeanUtilsBean beanUtilsBean2 = BeanUtilsBean2.getInstance();

	public static Map<String, String> describe(Object obejct) {

		try {
			Map<String, String> result = beanUtilsBean2.describe(obejct);
			result.remove("class");
			return result;
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		}
	}

/**
 * bean 转 map
 * <p>
 * @param obejct
 * @param properties
 * @return 
 * @return Map<String,String>
 * @author ben
 * @date 2017年9月20日 下午4:05:03 
 * @Description: TODO
 */
	public static Map<String, String> describe(Object obejct, String... properties) {
		try {
			Map<String, String> describeMap = beanUtilsBean2.describe(obejct);
			List<String> keys = new ArrayList<String>(describeMap.keySet());
			List<String> propertiesList = Arrays.asList(properties);
			for (String string : keys) {
				if (!propertiesList.contains(string)) {
					describeMap.remove(string);
				}
			}
			return describeMap;
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		}
	}

}
