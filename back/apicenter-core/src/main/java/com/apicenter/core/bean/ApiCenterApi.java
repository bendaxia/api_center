package com.apicenter.core.bean;

import java.io.Serializable;

public class ApiCenterApi implements Serializable {
    private int id;

    /**
     * api名称
     */
    private String apiName;

    /**
     * api协议
     */
    private String apiAgreement;

    /**
     * 请求方式
     */
    private String apiMode;

    /**
     * 域名
     */
    private String apiDomain;

    /**
     * api地址
     */
    private String apiAddress;

    /**
     * 描述
     */
    private String apiDescribe;

    /**
     * api创建人
     */
    private int founderUserId;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * api所属分组
     */
    private int apiGroupId;

    private String apiResultData;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiAgreement() {
        return apiAgreement;
    }

    public void setApiAgreement(String apiAgreement) {
        this.apiAgreement = apiAgreement;
    }

    public String getApiMode() {
        return apiMode;
    }

    public void setApiMode(String apiMode) {
        this.apiMode = apiMode;
    }

    public String getApiDomain() {
        return apiDomain;
    }

    public void setApiDomain(String apiDomain) {
        this.apiDomain = apiDomain;
    }

    public String getApiAddress() {
        return apiAddress;
    }

    public void setApiAddress(String apiAddress) {
        this.apiAddress = apiAddress;
    }

    public String getApiDescribe() {
        return apiDescribe;
    }

    public void setApiDescribe(String apiDescribe) {
        this.apiDescribe = apiDescribe;
    }

    public int getFounderUserId() {
        return founderUserId;
    }

    public void setFounderUserId(int founderUserId) {
        this.founderUserId = founderUserId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getApiGroupId() {
        return apiGroupId;
    }

    public void setApiGroupId(int apiGroupId) {
        this.apiGroupId = apiGroupId;
    }

    public String getApiResultData() {
        return apiResultData;
    }

    public void setApiResultData(String apiResultData) {
        this.apiResultData = apiResultData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apiName=").append(apiName);
        sb.append(", apiAgreement=").append(apiAgreement);
        sb.append(", apiMode=").append(apiMode);
        sb.append(", apiDomain=").append(apiDomain);
        sb.append(", apiAddress=").append(apiAddress);
        sb.append(", apiDescribe=").append(apiDescribe);
        sb.append(", founderUserId=").append(founderUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", apiGroupId=").append(apiGroupId);
        sb.append(", apiResultData=").append(apiResultData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}