package com.apicenter.core.faced;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicenter.core.bean.ApiCenterApi;
import com.apicenter.core.bean.ApiCenterParam;
import com.apicenter.core.bean.ApiCenterReturn;
import com.apicenter.core.service.ApiService;

/**
 * api业务封装实现类
 * 
 * @author ben
 * @ClassName: ApiFacedServiceImpl
 * @Description: TODO
 * @date 2017年9月8日 下午5:16:19
 */
@Service
public class ApiFacedServiceImpl implements ApiFacedService {

	@Autowired
	private ApiService apiService;

	@Override
	public void addApi(ApiCenterApi api, List<ApiCenterReturn> apiReturns, List<ApiCenterParam> apiParams) throws Exception {
		ApiCenterApi apiCenterApi = this.apiService.addApi(api);
		if (apiCenterApi == null) {
			return;
		}
		apiParams.forEach(param -> {
			param.setApiId(apiCenterApi.getId());
		});
		apiReturns.forEach(areturn -> {
			areturn.setApiId(apiCenterApi.getId());
		});
		this.apiService.addApiParam(apiParams);
		this.apiService.addApiReturn(apiReturns);
	}

	@Override
	public void updateApi(ApiCenterApi api, List<ApiCenterReturn> apiReturns, List<ApiCenterParam> apiParams) throws Exception {
		if (!this.apiService.updateApi(api)) {
			return;
		}
			this.apiService.delApiReturn(api.getId());
			this.apiService.delApiParam(api.getId());
			apiParams.forEach(param -> {
				param.setApiId(api.getId());
			});
			apiReturns.forEach(areturn -> {
				areturn.setApiId(api.getId());
			});
			this.apiService.addApiParam(apiParams);
			this.apiService.addApiReturn(apiReturns);
	}

}
