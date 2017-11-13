package com.apicenter.core.dao;

import com.apicenter.core.bean.ApiCenterGroup;
import com.apicenter.core.bean.ApiCenterGroupQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiCenterGroupDao {
    int countByExample(ApiCenterGroupQuery example);

    int deleteByExample(ApiCenterGroupQuery example);

    int deleteByPrimaryKey(int id);

    int insert(ApiCenterGroup record);

    int insertSelective(ApiCenterGroup record);

    List<ApiCenterGroup> selectByExample(ApiCenterGroupQuery example);

    ApiCenterGroup selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") ApiCenterGroup record, @Param("example") ApiCenterGroupQuery example);

    int updateByExample(@Param("record") ApiCenterGroup record, @Param("example") ApiCenterGroupQuery example);

    int updateByPrimaryKeySelective(ApiCenterGroup record);

    int updateByPrimaryKey(ApiCenterGroup record);
}