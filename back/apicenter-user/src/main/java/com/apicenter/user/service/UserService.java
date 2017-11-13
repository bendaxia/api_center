package com.apicenter.user.service;

import com.apicenter.user.bean.ApiCenterUser;

/**
 * 用户业务接口
 * 
 * @author ben
 * @ClassName: UserService
 * @Description: TODO
 * @date 2017年9月8日 下午3:17:52
 */
public interface UserService {

	/**
	 * 根据用户账号查询用户
	 * <p>
	 * 
	 * @param userNumber
	 * @return
	 * @throws Exception
	 * @return ApiCenterUser
	 * @author ben
	 * @date 2017年9月8日 下午3:18:53
	 * @Description: TODO
	 */
	ApiCenterUser getUserByUserNumber(String userNumber) throws Exception;
	
	/**
	 * 根据id查询user
	 * <p>
	 * @param userId
	 * @return
	 * @throws Exception 
	 * @return ApiCenterUser
	 * @author ben
	 * @date 2017年9月20日 下午4:09:06 
	 * @Description: TODO
	 */
	ApiCenterUser getUser(int userId) throws Exception;
	
	
}
