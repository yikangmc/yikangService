package com.yikangyiliao.pension.entity;

public class Adept {
    private Long adeptId;

    private String adeptName;

    private Long createTime;

    private Long updateTime;

    private Byte isDelete;

    private Integer type;
    
    /**
     * @author liushuaic
     * @date 2016-03-16 17:49
     * **/
    private Integer isCheck;
    
    

    public Long getAdeptId() {
        return adeptId;
    }

    public void setAdeptId(Long adeptId) {
        this.adeptId = adeptId;
    }

    public String getAdeptName() {
        return adeptName;
    }

    public void setAdeptName(String adeptName) {
        this.adeptName = adeptName == null ? null : adeptName.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}
	public static void main(String[] args) {
		System.out.println((int)'a');
	}
}