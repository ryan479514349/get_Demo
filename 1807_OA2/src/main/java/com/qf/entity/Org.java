package com.qf.entity;

import java.util.Date;

public class Org {
	private Long orgId;  //主键id

    private Long orgParentId;  //父类id

    private Short isParent; //是否父类

	private String orgParentName;//父类名称
	
	private Long subOrgId;//子部门的Id
    
	private String orgName;  //部门名称

    private String orgPath;  //部门路径

    private String orgDesc;  //部门描述

    private Short dispIndex;  //部门排序
   
    private Short state;  //是否可用

    private Date createdDate;  //创建时间

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    
    public Long getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(Long orgParentId) {
        this.orgParentId = orgParentId;
    }

    public Short getIsParent() {
        return isParent;
    }

    public void setIsParent(Short isParent) {
        this.isParent = isParent;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc == null ? null : orgDesc.trim();
    }

    public Short getDispIndex() {
        return dispIndex;
    }

    public void setDispIndex(Short dispIndex) {
        this.dispIndex = dispIndex;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

	@Override
	public String toString() {
		return "Org [orgId=" + orgId + ", orgParentId=" + orgParentId + ", isParent=" + isParent + ", orgName="
				+ orgName + ", orgPath=" + orgPath + ", orgDesc=" + orgDesc + ", dispIndex=" + dispIndex + ", state="
				+ state + ", createdDate=" + createdDate + "]";
	}

	public String getOrgParentName() {
		return orgParentName;
	}

	public void setOrgParentName(String orgParentName) {
		this.orgParentName = orgParentName;
	}

	public Long getSubOrgId() {
		return subOrgId;
	}

	public void setSubOrgId(Long subOrgId) {
		this.subOrgId = subOrgId;
	}
    
    
    
}