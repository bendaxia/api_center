package com.apicenter.core.faced;

import java.util.List;

import com.apicenter.core.bean.ApiCenterApi;

/**
 * api业务封装接口
 * 
 * @author ben
 * @ClassName: ApiFacedService
 * @Description: 针对比较复杂的业务提供的接口,防止service层被入侵
 * @date 2017年9月8日 下午5:15:14
 */
public interface ApiFacedService {
	
	/**
	 * 添加api
	 * <p>
	 * @param api
	 * @param returns
	 * @param params
	 * @throws Exception 
	 * @return void
	 * @author ben
	 * @date 2017年9月9日 下午5:04:31 
	 * @Description: 添加api基础数据，并处理参数和返回数据
	 */
	void addApi(ApiCenterApi api, List<String> apiReturns, List<String> apiParams) throws Exception;
	
	/**
	 * 修改api
	 * <p>
	 * @param api
	 * @param apiReturns
	 * @param apiParams
	 * @throws Exception 
	 * @return void
	 * @author ben
	 * @date 2017年9月12日 下午2:35:57 
	 * @Description: TODO
	 */
	void updateApi(ApiCenterApi api, List<String> apiReturns, List<String> apiParams) throws Exception;
}
