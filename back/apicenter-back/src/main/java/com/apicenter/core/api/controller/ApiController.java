package com.apicenter.core.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apicenter.core.api.common.Response;
import com.apicenter.core.api.consts.BaseController;
import com.apicenter.core.api.views.group.ApiGroup;
import com.apicenter.core.api.views.group.ApiGroupDetails;
import com.apicenter.core.bean.ApiCenterApi;
import com.apicenter.core.bean.ApiCenterGroup;
import com.apicenter.core.bean.ApiCenterParam;
import com.apicenter.core.bean.ApiCenterReturn;
import com.apicenter.core.faced.ApiFacedService;
import com.apicenter.core.service.ApiService;
import com.apicenter.user.bean.ApiCenterUser;
import com.apicenter.user.service.UserService;
import com.apicenter.util.bean.BeanUtils;
import com.apicenter.util.json.JsonUtils;

@Controller
@RequestMapping("api")
public class ApiController extends BaseController {
	private static final Logger logger = Logger.getLogger(ApiController.class);

	@Autowired
	private ApiService apiService;
	@Autowired
	private ApiFacedService apiFacedService;
	@Autowired
	private UserService userService;

	/**
	 * 添加分组
	 * <p>
	 * 
	 * @param request
	 * @param groupName
	 *            分组名称
	 * @return
	 * @return String
	 * @author ben
	 * @date 2017年9月9日 下午4:36:49
	 * @Description: TODO
	 */
	@RequestMapping(value = "group/add", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String addApiGroup(HttpServletRequest request,
			@RequestParam(value = "groupName", required = true) String groupName) {
		int userId = getUserId(request);
		try {
			ApiCenterGroup group = new ApiCenterGroup();
			group.setFounderUserId(userId);
			group.setGroupName(groupName);
			this.apiService.addApiGruop(group);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ApiController.addApiGroup[添加分组],参数:userId:" + userId);
			return Response.error();
		}
		return Response.ok();
	}

	/**
	 * 添加api
	 * <p>
	 * 
	 * @param request
	 *            获取请求头的
	 * @param apiName
	 *            接口名称
	 * @param apiGruopId
	 *            接口所属分组id
	 * @param apiAgreement
	 *            接口协议
	 * @param apiMode
	 *            接口请求方式
	 * @param apiDomain
	 *            接口域名
	 * @param apiAddress
	 *            接口地址
	 * @param apiDescribe
	 *            接口描述
	 * @param apiParams
	 *            接口参数数组
	 * @param apiReturns
	 *            接口返回数组
	 * @return
	 * @return String
	 * @author ben
	 * @date 2017年9月8日 下午9:08:07
	 * @Description: 该接口用于添加api
	 */
	@RequestMapping(value = "add", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String addApi(HttpServletRequest request, @RequestParam(value = "apiName", required = true) String apiName,
			@RequestParam(value = "apiGruopId", required = true) int apiGruopId,
			@RequestParam(value = "apiAgreement", required = true) String apiAgreement,
			@RequestParam(value = "apiMode", required = true) String apiMode,
			@RequestParam(value = "apiDomain", required = true) String apiDomain,
			@RequestParam(value = "apiAddress", required = true) String apiAddress,
			@RequestParam(value = "apiDescribe", required = true) String apiDescribe,
			@RequestParam(value = "apiParams", required = false) String apiParams,
			@RequestParam(value = "apiReturns", required = false) String apiReturns) {
		int userId = getUserId(request);
		try {
			ApiCenterApi api = new ApiCenterApi();
			api.setApiName(apiName);
			api.setApiGroupId(apiGruopId);
			api.setApiAgreement(apiAgreement);
			api.setApiMode(apiMode);
			api.setApiDomain(apiDomain);
			api.setApiAddress(apiAddress);
			api.setApiDescribe(apiDescribe);
			api.setFounderUserId(userId);
			List<ApiCenterReturn> aReturns = JsonUtils.jsonToList(apiReturns, ApiCenterReturn.class);
			List<ApiCenterParam> aParams = JsonUtils.jsonToList(apiParams, ApiCenterParam.class);
			this.apiFacedService.addApi(api, aReturns, aParams);
			// 问题:想办法支持header 和 cookie 2017 09 08

			// 解决:header 和 cookie 在模拟请求的时候自行添加 2017 09 12
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ApiController.addApi[添加api],参数:userId:" + userId);
			return Response.error();
		}
		return Response.ok();
	}

	/**
	 * 修改api
	 * <p>
	 * 
	 * @param request
	 * @param apiId
	 * @param apiName
	 * @param apiGruopId
	 * @param apiAgreement
	 * @param apiMode
	 * @param apiDomain
	 * @param apiAddress
	 * @param apiDescribe
	 * @param apiParams
	 * @param apiReturns
	 * @return
	 * @return String
	 * @author ben
	 * @date 2017年9月12日 下午2:26:54
	 * @Description: TODO
	 */
	@RequestMapping(value = "update", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String updateApi(HttpServletRequest request, @RequestParam(value = "apiId", required = true) int apiId,
			@RequestParam(value = "apiName", required = true) String apiName,
			@RequestParam(value = "apiGruopId", required = true) int apiGruopId,
			@RequestParam(value = "apiAgreement", required = true) String apiAgreement,
			@RequestParam(value = "apiMode", required = true) String apiMode,
			@RequestParam(value = "apiDomain", required = true) String apiDomain,
			@RequestParam(value = "apiAddress", required = true) String apiAddress,
			@RequestParam(value = "apiDescribe", required = true) String apiDescribe,
			@RequestParam(value = "apiParams[]", required = false) List<String> apiParams,
			@RequestParam(value = "apiReturns[]", required = false) List<String> apiReturns) {
		int userId = getUserId(request);
		try {
			ApiCenterApi api = this.apiService.getApi(apiId);
			if (api == null) {
				return Response.fail("api不存在");
			}
			if (api.getFounderUserId() != userId) {
				return Response.fail("这个接口不是你管理,请找相关人员修改管理人");
			}
			api.setApiName(apiName);
			api.setApiGroupId(apiGruopId);
			api.setApiAgreement(apiAgreement);
			api.setApiMode(apiMode);
			api.setApiDomain(apiDomain);
			api.setApiAddress(apiAddress);
			api.setApiDescribe(apiDescribe);
			api.setFounderUserId(userId);
			this.apiFacedService.updateApi(api, apiReturns, apiParams);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ApiController.updateApi[修改api],参数:userId:" + userId);
			return Response.error();
		}
		return Response.ok();
	}

	/**
	 * 获取分组列表
	 * <p>
	 * @param request
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月12日 下午3:30:26 
	 * @Description: TODO
	 */
	@RequestMapping(value = "group/list/catalog", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String listWithApiGroup(HttpServletRequest request) {
		int userId = getUserId(request);
		List<ApiGroup> apiGroups = new ArrayList<>();
		try {
			List<ApiCenterGroup> ApiCenterGroups = this.apiService.listWithApiGroup();
			if (ApiCenterGroups.size() == 0) {
				return Response.empty();
			}
			List<Integer> apiGroupIds = new ArrayList<>();
			ApiCenterGroups.forEach(apiGroup -> {
				apiGroupIds.add(apiGroup.getId());
			});
			List<ApiCenterApi> apis = this.apiService.listWithApiByGroupIds(apiGroupIds);
			ApiCenterGroups.forEach(apiGroup -> {
				ApiGroup apiGroupView = new ApiGroup();
				apiGroupView.setGruopName(apiGroup.getGroupName());
				List<ApiGroupDetails> details = new ArrayList<>();
				apis.forEach(api -> {
					if (api.getApiGroupId() == apiGroup.getId()) {
						ApiGroupDetails detail = new ApiGroupDetails();
						detail.setApiId(api.getId());
						detail.setApiName(api.getApiName());
						details.add(detail);
					}
				});
				apiGroupView.setApiGroupDetails(details);
				apiGroups.add(apiGroupView);
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ApiController.listWithApiGroup[查询分组],参数:userId:" + userId);
			return Response.error();
		}
		return Response.ok(apiGroups, "成功");
	}
	
	/**
	 * 获取分组类型(添加api时候用)
	 * <p>
	 * @param request
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月21日 下午3:08:04 
	 * @Description: TODO
	 */
	@RequestMapping(value = "group/list", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String listWithApiGroupName(HttpServletRequest request) {
		int userId = getUserId(request);
		List<ApiCenterGroup> apiCenterGroups = new ArrayList<>();
		try {
			apiCenterGroups = this.apiService.listWithApiGroup();
			if (apiCenterGroups.size() == 0) {
				return Response.empty();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ApiController.listWithApiGroupName[查询分组],参数:userId:" + userId);
			return Response.error();
		}
		return Response.ok(apiCenterGroups, "成功");
	}
	
	/**
	 * 获取api详情
	 * <p>
	 * @param apiId
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月20日 下午3:59:44 
	 * @Description: TODO
	 */
	@RequestMapping(value = "api", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String getApi(@RequestParam(value = "apiId", required = true) int apiId) {
		Map<String,Object> apiMap = new HashMap<>();
		try {
			ApiCenterApi api = this.apiService.getApi(apiId);
			if(api==null) {
				return Response.fail("api不存在");
			}
			Map<String,String> map = BeanUtils.describe(api);
			map.remove("id");
			map.remove("founderUserId");
			ApiCenterUser user = this.userService.getUser(api.getFounderUserId());
			map.put("userName", user.getUserName());
			List<ApiCenterParam> params = this.apiService.listWithParam(apiId);
			List<ApiCenterReturn> returns = this.apiService.listWithReturn(apiId);
			apiMap.putAll(map);
			apiMap.put("returns", returns);
			apiMap.put("params", params);
			ApiCenterGroup apiCenterGroup = this.apiService.getApiCenterGroup(api.getApiGroupId());
			apiMap.put("apiGroupName", apiCenterGroup.getGroupName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ApiController.api[api]");
			return Response.error();
		}
		return Response.ok(apiMap, "成功");
	}

}
