package com.qf.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
   
	@Override
	public String toString() {
		return "User [userId=" + userId + ", orgId=" + orgId + ", orgName=" + orgName + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", mobilePhone=" + mobilePhone + ", email=" + email
				+ ", userChName=" + userChName + ", userBirthday=" + userBirthday + ", userSex=" + userSex
				+ ", userPhotoUrl=" + userPhotoUrl + ", provinceId=" + provinceId + ", provinceName=" + provinceName
				+ ", cityId=" + cityId + ", cityName=" + cityName + ", countryId=" + countryId + ", contryName="
				+ contryName + ", hobby=" + hobby + ", introduce=" + introduce + ", createdDate=" + createdDate + "]";
	}

	private Long userId;  //用户id

    private Long orgId; //用户部门id
    
    private String  orgName; //用户部门名称
    
 

    public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	private String userName; //姓名

    private String userPassword; //密码

    private String mobilePhone; //手机号码
    
    private String email;	//邮箱

    private String userChName;  //别名
    //解决日期问题
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userBirthday;  //生日

    private Short userSex;  //性别

    private String userPhotoUrl; //头像

    private Integer provinceId;  //省份id

    private String provinceName; //省名称

    private Integer cityId;  //城市id

    private String cityName; //城市名称

    private Integer countryId; //县,镇id

    private String contryName; //县,镇名称

    private String hobby; //爱好

    private String introduce;

    private Date createdDate;  //创建时间

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserChName() {
        return userChName;
    }

    public void setUserChName(String userChName) {
        this.userChName = userChName == null ? null : userChName.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Short getUserSex() {
        return userSex;
    }

    public void setUserSex(Short userSex) {
        this.userSex = userSex;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl == null ? null : userPhotoUrl.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getContryName() {
        return contryName;
    }

    public void setContryName(String contryName) {
        this.contryName = contryName == null ? null : contryName.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}