package com.example.demo.entity.extend;

import com.example.demo.entity.PatientInformationPumchEntity;

public class PatientInformationPumchExtend {

    private long oid;
    private String hospitalId;
    private String name;
    private String gender;
    private String birthday;
    private String nativePlace;
    private String nationality;
    private RegisterUserExtend createRegisterUser;
    private String createTime;
    private String updateTime;

    public static PatientInformationPumchExtend getExtendFromEntity(PatientInformationPumchEntity entity, PatientInformationPumchExtend extend) {
        extend.setOid(entity.getOid());
        extend.setHospitalId(entity.getHospitalId());
        extend.setName(entity.getName());
        extend.setGender(entity.getGender());
        extend.setBirthday(entity.getBirthday());
        extend.setNativePlace(entity.getNativePlace());
        extend.setNationality(entity.getNationality());
        extend.setCreateTime(entity.getCreateTime());
        extend.setUpdateTime(entity.getUpdateTime());
        return extend;
    }

    public PatientInformationPumchExtend() {
    }

    public PatientInformationPumchExtend(long oid, String hospitalId, String name, String gender, String birthday, String nativePlace, String nationality, RegisterUserExtend createRegisterUser, String createTime, String updateTime) {
        this.oid = oid;
        this.hospitalId = hospitalId;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
        this.nationality = nationality;
        this.createRegisterUser = createRegisterUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public RegisterUserExtend getCreateRegisterUser() {
        return createRegisterUser;
    }

    public void setCreateRegisterUser(RegisterUserExtend createRegisterUser) {
        this.createRegisterUser = createRegisterUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
