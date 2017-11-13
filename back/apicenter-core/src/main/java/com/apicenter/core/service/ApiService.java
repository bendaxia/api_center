package com.apicenter.core.service;

import java.util.List;

import com.apicenter.core.bean.ApiCenterApi;
import com.apicenter.core.bean.ApiCenterGroup;
import com.apicenter.core.bean.ApiCenterParam;
import com.apicenter.core.bean.ApiCenterReturn;

/**
 * api操作接口
 * 
 * @author ben
 * @ClassName: ApiService
 * @Description: TODO
 * @date 2017年9月8日 下午4:58:22
 */
public interface ApiService {

	/**
	 * 持久化api分组数据
	 * <p>
	 * 
	 * @return
	 * @throws Exception
	 * @return ApiCenterGroup
	 * @author ben
	 * @date 2017年9月8日 下午5:01:04
	 * @Description: TODO
	 */
	ApiCenterGroup addApiGruop(ApiCenterGroup apiGroup) throws Exception;

	/**
	 * 持久化api基础数据
	 * <p>
	 * 
	 * @param api
	 * @return
	 * @return ApiCenterApi
	 * @author ben
	 * @date 2017年9月8日 下午4:59:18
	 * @Description: TODO
	 */
	ApiCenterApi addApi(ApiCenterApi api) throws Exception;

	/**
	 * 持久化api参数数据
	 * <p>
	 * 
	 * @param apiParam
	 * @return
	 * @throws Exception
	 * @return ApiCenterParam
	 * @author ben
	 * @date 2017年9月8日 下午5:03:14
	 * @Description: TODO
	 */
	ApiCenterParam addApiParam(ApiCenterParam apiParam) throws Exception;

	/**
	 * 批量插入参数数据
	 * <p>
	 * 
	 * @param apiParams
	 * @return
	 * @throws Exception
	 * @return boolean true:成功 false:失败
	 * @author ben
	 * @date 2017年9月9日 下午5:46:43
	 * @Description: TODO
	 */
	boolean addApiParam(List<ApiCenterParam> apiParams) throws Exception;

	/**
	 * 持久化api返回数据
	 * <p>
	 * 
	 * @param apiReturn
	 * @return
	 * @throws Exception
	 * @return ApiCenterReturn
	 * @author ben
	 * @date 2017年9月8日 下午5:04:20
	 * @Description: TODO
	 */
	ApiCenterReturn addApiReturn(ApiCenterReturn apiReturn) throws Exception;

	/**
	 * 批量插入返回数据
	 * <p>
	 * 
	 * @param apiReturns
	 * @return
	 * @throws Exception
	 * @return boolean true:成功 false:失败
	 * @author ben
	 * @date 2017年9月9日 下午5:42:03
	 * @Description: TODO
	 */
	boolean addApiReturn(List<ApiCenterReturn> apiReturns) throws Exception;

	/**
	 * 根据id查询api对象
	 * <p>
	 * 
	 * @param apiId
	 * @return
	 * @throws Exception
	 * @return ApiCenterApi
	 * @author ben
	 * @date 2017年9月12日 下午2:29:19
	 * @Description: 没存在返null
	 */
	ApiCenterApi getApi(int apiId) throws Exception;

	/**
	 * 根据id修改api
	 * <p>
	 * 
	 * @param api
	 * @return
	 * @throws Exception
	 * @return boolean
	 * @author ben
	 * @date 2017年9月12日 下午2:32:57
	 * @Description: 成功返true，反之false
	 */
	boolean updateApi(ApiCenterApi api) throws Exception;

	/**
	 * 根据apiId删除api参数
	 * <p>
	 * @param apiId
	 * @return
	 * @throws Exception 
	 * @return boolean
	 * @author ben
	 * @date 2017年9月12日 下午2:41:12 
	 * @Description: TODO
	 */
	boolean delApiParam(int apiId) throws Exception;

	/**
	 * 根据apiId删除api返回值
	 * <p>
	 * @param apiId
	 * @return
	 * @throws Exception 
	 * @return boolean
	 * @author ben
	 * @date 2017年9月12日 下午2:41:33 
	 * @Description: TODO
	 */
	boolean delApiReturn(int apiId) throws Exception;
	
	/**
	 * 查询全部的api分组
	 * <p>
	 * @return
	 * @throws Exception 
	 * @return List<ApiCenterGroup>
	 * @author ben
	 * @date 2017年9月12日 下午3:05:33 
	 * @Description: TODO
	 */
	List<ApiCenterGroup> listWithApiGroup()throws Exception;
	
	/**
	 * 根据分组id集合in查询api
	 * <p>
	 * @param groupIds
	 * @return
	 * @throws Exception 
	 * @return List<ApiCenterApi>
	 * @author ben
	 * @date 2017年9月12日 下午3:21:55 
	 * @Description: TODO
	 */
	List<ApiCenterApi> listWithApiByGroupIds(List<Integer> groupIds)throws Exception;
	
	/**
	 * 根据apiid获取返回值
	 * <p>
	 * @param apiId
	 * @return
	 * @throws Exception 
	 * @return List<ApiCenterReturn>
	 * @author ben
	 * @date 2017年9月20日 下午4:18:30 
	 * @Description: TODO
	 */
	List<ApiCenterReturn> listWithReturn(int apiId)throws Exception;
	
	/**
	 * 获取api的参数
	 * <p>
	 * @param apiId
	 * @return
	 * @throws Exception 
	 * @return List<ApiCenterParam>
	 * @author ben
	 * @date 2017年9月20日 下午4:19:08 
	 * @Description: TODO
	 */
	List<ApiCenterParam> listWithParam(int apiId)throws Exception;
}
