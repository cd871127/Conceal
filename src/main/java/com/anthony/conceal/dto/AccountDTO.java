package com.anthony.conceal.dto;

import java.util.Date;

/**
 * Created by Anthony on 2016/12/22.
 */
public class AccountDTO {
    private String id;
    private String ownerId;
    private String accountName;
    private String accountPassWord;
    private String accountDesc;
    private String accountUrl;
    private String accountType;

    private Date createDate;
    private Date updateDate;
    private String dataState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassWord() {
        return accountPassWord;
    }

    public void setAccountPassWord(String accountPassWord) {
        this.accountPassWord = accountPassWord;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountPassWord='" + accountPassWord + '\'' +
                ", accountDesc='" + accountDesc + '\'' +
                ", accountUrl='" + accountUrl + '\'' +
                ", accountType='" + accountType + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", dataState='" + dataState + '\'' +
                '}';
    }
}
