package com.apicenter.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.apicenter.core.bean.ApiCenterParam;
import com.apicenter.core.bean.ApiCenterParamQuery;

public interface ApiCenterParamDao {
    int countByExample(ApiCenterParamQuery example);

    int deleteByExample(ApiCenterParamQuery example);

    int deleteByPrimaryKey(int id);

    int insert(ApiCenterParam record);

    int insertSelective(ApiCenterParam record);

    List<ApiCenterParam> selectByExample(ApiCenterParamQuery example);

    ApiCenterParam selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") ApiCenterParam record, @Param("example") ApiCenterParamQuery example);

    int updateByExample(@Param("record") ApiCenterParam record, @Param("example") ApiCenterParamQuery example);

    int updateByPrimaryKeySelective(ApiCenterParam record);

    int updateByPrimaryKey(ApiCenterParam record);
    
	@Insert(value={
			  "<script> "
			+ "insert into api_center_param (api_id,param_name,param_describe,param_type,test_value,isoptional) VALUES "
			+ " <foreach item='item' index='index' collection='apiCenterParams' separator=',' > " 
			+ "  (#{item.apiId,jdbcType=INTEGER},#{item.paramName,jdbcType=VARCHAR},#{item.paramDescribe,jdbcType=VARCHAR},#{item.paramType,jdbcType=VARCHAR} ,#{item.testValue,jdbcType=VARCHAR},#{item.isoptional,jdbcType=INTEGER} ) " 
			+ " </foreach> "
			+ " </script>" })
	int batchInsert(@Param("apiCenterParams")List<ApiCenterParam> apiCenterParams);
	
}