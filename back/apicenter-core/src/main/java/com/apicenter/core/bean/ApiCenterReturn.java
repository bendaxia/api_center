package com.apicenter.core.bean;

import java.io.Serializable;

public class ApiCenterReturn implements Serializable {
    private int id;

    /**
     * 返回名
     */
    private String returnName;

    /**
     * 返回描述
     */
    private String returnDescribe;

    /**
     * 返回类型
     */
    private String returnType;

    /**
     * 所属apiid
     */
    private int apiId;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnDescribe() {
        return returnDescribe;
    }

    public void setReturnDescribe(String returnDescribe) {
        this.returnDescribe = returnDescribe;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", returnName=").append(returnName);
        sb.append(", returnDescribe=").append(returnDescribe);
        sb.append(", returnType=").append(returnType);
        sb.append(", apiId=").append(apiId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}