package com.example.demo.entity.extend;

import com.example.demo.entity.OrganizationEntity;
import com.example.demo.entity.RegisterUserEntity;

/**
 * Created by liliwang on 2017/5/22.
 */
public class RegisterUserExtend {
    private Long oid;
    private String uuid;
    private String loginPassword;
    private String userName;
    private String userPhoneNumber;
    private String userAuthentication;
    private String userAuthenticationState;
    private OrganizationEntity userOrganization;
    private String registerTime;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(String userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    public String getUserAuthenticationState() {
        return userAuthenticationState;
    }

    public void setUserAuthenticationState(String userAuthenticationState) {
        this.userAuthenticationState = userAuthenticationState;
    }

    public OrganizationEntity getUserOrganization() {
        return userOrganization;
    }

    public void setUserOrganization(OrganizationEntity userOrganization) {
        this.userOrganization = userOrganization;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public static RegisterUserExtend getExtendFromEntity(RegisterUserEntity entity, RegisterUserExtend extend) {
        extend.setOid(entity.getOid());
        extend.setUuid(entity.getUuid());
        extend.setLoginPassword(entity.getLoginPassword());
        extend.setUserName(entity.getUserName());
        extend.setUserPhoneNumber(entity.getUserPhoneNumber());
        extend.setUserAuthentication(entity.getUserAuthentication());
        extend.setUserAuthenticationState(entity.getUserAuthenticationState());
        extend.setRegisterTime(entity.getRegisterTime());
        return extend;
    }
}
