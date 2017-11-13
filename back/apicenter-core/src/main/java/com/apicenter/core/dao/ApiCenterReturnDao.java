package com.apicenter.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.apicenter.core.bean.ApiCenterReturn;
import com.apicenter.core.bean.ApiCenterReturnQuery;

public interface ApiCenterReturnDao {
    int countByExample(ApiCenterReturnQuery example);

    int deleteByExample(ApiCenterReturnQuery example);

    int deleteByPrimaryKey(int id);

    int insert(ApiCenterReturn record);

    int insertSelective(ApiCenterReturn record);

    List<ApiCenterReturn> selectByExample(ApiCenterReturnQuery example);

    ApiCenterReturn selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") ApiCenterReturn record, @Param("example") ApiCenterReturnQuery example);

    int updateByExample(@Param("record") ApiCenterReturn record, @Param("example") ApiCenterReturnQuery example);

    int updateByPrimaryKeySelective(ApiCenterReturn record);

    int updateByPrimaryKey(ApiCenterReturn record);
    
	@Insert(value={
			  "<script> "
			+ "insert into api_center_return (return_name,return_describe,return_type,api_id) VALUES "
			+ " <foreach item='item' index='index' collection='apiCenterReturns' separator=',' > " 
			+ "  (#{item.returnName,jdbcType=VARCHAR},#{item.returnDescribe,jdbcType=VARCHAR},#{item.returnType,jdbcType=VARCHAR},#{item.apiId,jdbcType=INTEGER} ) " 
			+ " </foreach> "
			+ " </script>" })
	int batchInsert(@Param("apiCenterReturns")List<ApiCenterReturn> apiCenterReturns);
	
}