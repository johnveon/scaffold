package cn.huanqiu.scaffold.service.cms.sm.vo;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userName;

    private String userCode;

    private String userPwd;
    private String pwdChange;

    private String email;

    private String industry;
    
    private String[] industrys;
    private String[] industryNames;


    private Date createDate;

    private Date modifyDate;

    private String createUsear;

    private String modifyUser;

    private String status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateUsear() {
        return createUsear;
    }

    public void setCreateUsear(String createUsear) {
        this.createUsear = createUsear == null ? null : createUsear.trim();
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String[] getIndustrys() {
		return industrys;
	}

	public void setIndustrys(String[] industrys) {
		this.industrys = industrys;
	}

	public String[] getIndustryNames() {
		return industryNames;
	}

	public void setIndustryNames(String[] industryNames) {
		this.industryNames = industryNames;
	}

	public String getPwdChange() {
		return pwdChange;
	}

	public void setPwdChange(String pwdChange) {
		this.pwdChange = pwdChange;
	}

	
    
}