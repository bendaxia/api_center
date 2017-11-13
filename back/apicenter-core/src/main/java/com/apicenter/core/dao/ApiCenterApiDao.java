package com.apicenter.core.dao;

import com.apicenter.core.bean.ApiCenterApi;
import com.apicenter.core.bean.ApiCenterApiQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiCenterApiDao {
    int countByExample(ApiCenterApiQuery example);

    int deleteByExample(ApiCenterApiQuery example);

    int deleteByPrimaryKey(int id);

    int insert(ApiCenterApi record);

    int insertSelective(ApiCenterApi record);

    List<ApiCenterApi> selectByExample(ApiCenterApiQuery example);

    ApiCenterApi selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") ApiCenterApi record, @Param("example") ApiCenterApiQuery example);

    int updateByExample(@Param("record") ApiCenterApi record, @Param("example") ApiCenterApiQuery example);

    int updateByPrimaryKeySelective(ApiCenterApi record);

    int updateByPrimaryKey(ApiCenterApi record);
}