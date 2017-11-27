package com.apicenter.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicenter.core.bean.ApiCenterApi;
import com.apicenter.core.bean.ApiCenterApiQuery;
import com.apicenter.core.bean.ApiCenterGroup;
import com.apicenter.core.bean.ApiCenterGroupQuery;
import com.apicenter.core.bean.ApiCenterParam;
import com.apicenter.core.bean.ApiCenterParamQuery;
import com.apicenter.core.bean.ApiCenterReturn;
import com.apicenter.core.bean.ApiCenterReturnQuery;
import com.apicenter.core.dao.ApiCenterApiDao;
import com.apicenter.core.dao.ApiCenterGroupDao;
import com.apicenter.core.dao.ApiCenterParamDao;
import com.apicenter.core.dao.ApiCenterReturnDao;
import com.apicenter.core.service.ApiService;
import com.apicenter.util.time.TimeUtils;

/**
 * api操作实现类
 * @author ben
 * @ClassName: ApiServiceImpl 
 * @Description: TODO
 * @date 2017年9月8日 下午4:57:55
 */
@Service
public class ApiServiceImpl implements ApiService{

	@Autowired
	private ApiCenterApiDao apiCenterApiDao;
	@Autowired
	private ApiCenterGroupDao apiCenterGroupDao;
	@Autowired
	private ApiCenterParamDao apiCenterParamDao;
	@Autowired
	private ApiCenterReturnDao apiCenterReturnDao;
	
	@Override
	public ApiCenterGroup addApiGruop(ApiCenterGroup apiGroup) throws Exception {
		apiGroup.setCreateTime(TimeUtils.getCurrentTime());
		return this.apiCenterGroupDao.insertSelective(apiGroup)>0?apiGroup:null;
	}

	@Override
	public ApiCenterApi addApi(ApiCenterApi api) throws Exception {
		api.setCreateTime(TimeUtils.getCurrentTime());
		return this.apiCenterApiDao.insertSelective(api)>0?api:null;
	}

	@Override
	public ApiCenterParam addApiParam(ApiCenterParam apiParam) throws Exception {
		return this.apiCenterParamDao.insertSelective(apiParam)>0?apiParam:null;
	}

	@Override
	public ApiCenterReturn addApiReturn(ApiCenterReturn apiReturn) throws Exception {
		return this.apiCenterReturnDao.insertSelective(apiReturn)>0?apiReturn:null;
	}

	@Override
	public boolean addApiReturn(List<ApiCenterReturn> apiReturns) throws Exception {
		if(apiReturns.size()==0) {
			return false;
		}
		return this.apiCenterReturnDao.batchInsert(apiReturns)>0?true:false;
	}

	@Override
	public boolean addApiParam(List<ApiCenterParam> apiParams) throws Exception {
		if(apiParams.size()==0) {
			return false;
		}
		return this.apiCenterParamDao.batchInsert(apiParams)>0?true:false;
	}

	@Override
	public ApiCenterApi getApi(int apiId) throws Exception {
		return this.apiCenterApiDao.selectByPrimaryKey(apiId);
	}

	@Override
	public boolean updateApi(ApiCenterApi api) throws Exception {
		return this.apiCenterApiDao.updateByPrimaryKeySelective(api)>0?true:false;
	}

	@Override
	public boolean delApiParam(int apiId) throws Exception {
		ApiCenterParamQuery example = new ApiCenterParamQuery();
		example.createCriteria().andApiIdEqualTo(apiId);
		return this.apiCenterParamDao.deleteByExample(example)>0?true:false;
	}

	@Override
	public boolean delApiReturn(int apiId) throws Exception {
		ApiCenterReturnQuery example = new ApiCenterReturnQuery();
		example.createCriteria().andApiIdEqualTo(apiId);
		return this.apiCenterReturnDao.deleteByExample(example)>0?true:false;
	}

	@Override
	public List<ApiCenterGroup> listWithApiGroup() throws Exception {
		ApiCenterGroupQuery example = new ApiCenterGroupQuery();
		example.createCriteria();
		return this.apiCenterGroupDao.selectByExample(example);
	}

	@Override
	public List<ApiCenterApi> listWithApiByGroupIds(List<Integer> groupIds) throws Exception {
		if(groupIds.size()==0) {
			return new ArrayList<>();
		}
		ApiCenterApiQuery apiCenterApiQuery = new ApiCenterApiQuery();
		apiCenterApiQuery.createCriteria().andApiGroupIdIn(groupIds);
		return this.apiCenterApiDao.selectByExample(apiCenterApiQuery);
	}

	@Override
	public List<ApiCenterReturn> listWithReturn(int apiId) throws Exception {
		ApiCenterReturnQuery query = new ApiCenterReturnQuery();
		query.createCriteria().andApiIdEqualTo(apiId);
		return this.apiCenterReturnDao.selectByExample(query);
	}

	@Override
	public List<ApiCenterParam> listWithParam(int apiId) throws Exception {
		ApiCenterParamQuery query = new ApiCenterParamQuery();
		query.createCriteria().andApiIdEqualTo(apiId);
		return this.apiCenterParamDao.selectByExample(query);
	}

	@Override
	public ApiCenterGroup getApiCenterGroup(int apiCenterGroupId) throws Exception {
		return this.apiCenterGroupDao.selectByPrimaryKey(apiCenterGroupId);
	}
	
}
