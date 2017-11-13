package com.apicenter.core.bean;

import java.io.Serializable;

public class ApiCenterParam implements Serializable {
    /**
     * 参数id
     */
    private int id;

    /**
     * 所属api的id
     */
    private int apiId;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 参数描述
     */
    private String paramDescribe;

    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 测试参数值
     */
    private String testValue;

    /**
     * 是否可选  0 可选 1不可选
     */
    private int isoptional;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamDescribe() {
        return paramDescribe;
    }

    public void setParamDescribe(String paramDescribe) {
        this.paramDescribe = paramDescribe;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public int getIsoptional() {
        return isoptional;
    }

    public void setIsoptional(int isoptional) {
        this.isoptional = isoptional;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apiId=").append(apiId);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramDescribe=").append(paramDescribe);
        sb.append(", paramType=").append(paramType);
        sb.append(", testValue=").append(testValue);
        sb.append(", isoptional=").append(isoptional);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}