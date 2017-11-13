package com.apicenter.user.dao;

import com.apicenter.user.bean.ApiCenterUser;
import com.apicenter.user.bean.ApiCenterUserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiCenterUserDao {
    int countByExample(ApiCenterUserQuery example);

    int deleteByExample(ApiCenterUserQuery example);

    int deleteByPrimaryKey(int userId);

    int insert(ApiCenterUser record);

    int insertSelective(ApiCenterUser record);

    List<ApiCenterUser> selectByExample(ApiCenterUserQuery example);

    ApiCenterUser selectByPrimaryKey(int userId);

    int updateByExampleSelective(@Param("record") ApiCenterUser record, @Param("example") ApiCenterUserQuery example);

    int updateByExample(@Param("record") ApiCenterUser record, @Param("example") ApiCenterUserQuery example);

    int updateByPrimaryKeySelective(ApiCenterUser record);

    int updateByPrimaryKey(ApiCenterUser record);
}