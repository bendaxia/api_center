package com.apicenter.core.faced;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicenter.core.bean.ApiCenterApi;
import com.apicenter.core.bean.ApiCenterParam;
import com.apicenter.core.bean.ApiCenterReturn;
import com.apicenter.core.service.ApiService;
import com.apicenter.util.json.JsonUtils;

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
	public void addApi(ApiCenterApi api, List<String> apiReturns, List<String> apiParams) throws Exception {
		ApiCenterApi apiCenterApi = this.apiService.addApi(api);
		if (apiCenterApi == null) {
			return;
		}
		System.out.println("toString-------" + apiParams.toString());
		List<ApiCenterParam> params = new ArrayList<>();
		apiParams.forEach(param -> {
			System.out.println(param);
//			ApiCenterParam p = JsonUtils.toBean(param, ApiCenterParam.class);
//			p.setApiId(apiCenterApi.getId());
//			params.add(p);
		});
		List<ApiCenterReturn> returns = new ArrayList<>();
		apiReturns.forEach(areturn -> {
			System.out.println(areturn);
			ApiCenterReturn r = JsonUtils.toBean(areturn, ApiCenterReturn.class);
			r.setApiId(apiCenterApi.getId());
			returns.add(r);
		});
		this.apiService.addApiParam(params);
		this.apiService.addApiReturn(returns);
	}

	@Override
	public void updateApi(ApiCenterApi api, List<String> apiReturns, List<String> apiParams) throws Exception {
		if (this.apiService.updateApi(api)) {
			this.apiService.delApiReturn(api.getId());
			this.apiService.delApiParam(api.getId());
			List<ApiCenterParam> params = new ArrayList<>();
			apiParams.forEach(param -> {
				ApiCenterParam p = JsonUtils.toBean(param, ApiCenterParam.class);
				p.setApiId(api.getId());
				params.add(p);
			});
			List<ApiCenterReturn> returns = new ArrayList<>();
			apiReturns.forEach(areturn -> {
				ApiCenterReturn r = JsonUtils.toBean(areturn, ApiCenterReturn.class);
				r.setApiId(api.getId());
				returns.add(r);
			});
			this.apiService.addApiParam(params);
			this.apiService.addApiReturn(returns);
		}
	}

}
