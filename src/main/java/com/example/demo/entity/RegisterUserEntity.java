package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "register_user", schema = "medical_camera", catalog = "")
public class RegisterUserEntity {
    private long oid;
    private String uuid;
    private String loginPassword;
    private String userName;
    private String userPhoneNumber;
    private String userAuthentication;
    private String userAuthenticationState;
    private Long userOrganizationId;
    private String registerTime;

    @Id
    @Column(name = "id", nullable = false)
    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "uuid", nullable = true, length = 32)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "login_password", nullable = true, length = 60)
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 60)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_phone_number", nullable = true, length = 60)
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Basic
    @Column(name = "user_authentication", nullable = true, length = 200)
    public String getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(String userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    @Basic
    @Column(name = "user_authentication_state", nullable = true, length = 60)
    public String getUserAuthenticationState() {
        return userAuthenticationState;
    }

    public void setUserAuthenticationState(String userAuthenticationState) {
        this.userAuthenticationState = userAuthenticationState;
    }

    @Basic
    @Column(name = "user_organization_id", nullable = true)
    public Long getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(Long userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    @Basic
    @Column(name = "register_time", nullable = true, length = 60)
    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterUserEntity that = (RegisterUserEntity) o;

        if (oid != that.oid) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (loginPassword != null ? !loginPassword.equals(that.loginPassword) : that.loginPassword != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPhoneNumber != null ? !userPhoneNumber.equals(that.userPhoneNumber) : that.userPhoneNumber != null)
            return false;
        if (userAuthentication != null ? !userAuthentication.equals(that.userAuthentication) : that.userAuthentication != null)
            return false;
        if (userAuthenticationState != null ? !userAuthenticationState.equals(that.userAuthenticationState) : that.userAuthenticationState != null)
            return false;
        if (userOrganizationId != null ? !userOrganizationId.equals(that.userOrganizationId) : that.userOrganizationId != null)
            return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (oid ^ (oid >>> 32));
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (loginPassword != null ? loginPassword.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhoneNumber != null ? userPhoneNumber.hashCode() : 0);
        result = 31 * result + (userAuthentication != null ? userAuthentication.hashCode() : 0);
        result = 31 * result + (userAuthenticationState != null ? userAuthenticationState.hashCode() : 0);
        result = 31 * result + (userOrganizationId != null ? userOrganizationId.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        return result;
    }
}
