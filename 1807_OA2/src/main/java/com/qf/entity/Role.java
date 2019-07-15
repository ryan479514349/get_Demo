package com.qf.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Role {
    
    @Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", state=" + state
				+ ", createdDate=" + createdDate + "]";
	}

	private Long roleId;

   
    private String roleName; //角色名称

    private String roleDesc; //角色描述

    private Short state; //角色状态
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdDate; //创建时间

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.ROLE_NAME
     *
     * @return the value of sys_role.ROLE_NAME
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.ROLE_NAME
     *
     * @param roleName the value for sys_role.ROLE_NAME
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.ROLE_DESC
     *
     * @return the value of sys_role.ROLE_DESC
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.ROLE_DESC
     *
     * @param roleDesc the value for sys_role.ROLE_DESC
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.STATE
     *
     * @return the value of sys_role.STATE
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public Short getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.STATE
     *
     * @param state the value for sys_role.STATE
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public void setState(Short state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.CREATED_DATE
     *
     * @return the value of sys_role.CREATED_DATE
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.CREATED_DATE
     *
     * @param createdDate the value for sys_role.CREATED_DATE
     *
     * @mbggenerated Fri Dec 07 19:05:19 CST 2018
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}