package com.apicenter.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicenter.user.bean.ApiCenterUser;
import com.apicenter.user.bean.ApiCenterUserQuery;
import com.apicenter.user.dao.ApiCenterUserDao;
import com.apicenter.user.service.UserService;

/**
 * 用户业务实现类
 * 
 * @author ben
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @date 2017年9月8日 下午3:16:16
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private ApiCenterUserDao userDao;

	@Override
	public ApiCenterUser getUserByUserNumber(String userNumber) throws Exception {
		ApiCenterUserQuery apiCenterUserQuery = new ApiCenterUserQuery();
		apiCenterUserQuery.createCriteria().andUserNumberEqualTo(userNumber);
		List<ApiCenterUser> user = this.userDao.selectByExample(apiCenterUserQuery);
		return user.size() > 0 ? user.get(0) : null;
	}

	@Override
	public ApiCenterUser getUser(int userId) throws Exception {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
