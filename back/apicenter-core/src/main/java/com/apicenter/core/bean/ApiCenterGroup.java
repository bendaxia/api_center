package com.apicenter.core.bean;

import java.io.Serializable;

public class ApiCenterGroup implements Serializable {
    private int id;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 分组创建人
     */
    private int founderUserId;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getFounderUserId() {
        return founderUserId;
    }

    public void setFounderUserId(int founderUserId) {
        this.founderUserId = founderUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupName=").append(groupName);
        sb.append(", createTime=").append(createTime);
        sb.append(", founderUserId=").append(founderUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}