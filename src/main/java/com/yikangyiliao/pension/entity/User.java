package com.yikangyiliao.pension.entity;

public class User {
    private Long userId;

    private String userName;

    private String loginName;

    private String loginPassword;

    private String salt;

    private String accessTiket;

    private Long createTime;

    private Long loginTime;

    private String invitationCode;

    private String pushAlias;
    
    private Byte infoWrite;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getAccessTiket() {
        return accessTiket;
    }

    public void setAccessTiket(String accessTiket) {
        this.accessTiket = accessTiket == null ? null : accessTiket.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public String getPushAlias() {
        return pushAlias;
    }

    public void setPushAlias(String pushAlias) {
        this.pushAlias = pushAlias == null ? null : pushAlias.trim();
    }

	public Byte getInfoWrite() {
		return infoWrite;
	}

	public void setInfoWrite(Byte infoWrite) {
		this.infoWrite = infoWrite;
	}
}