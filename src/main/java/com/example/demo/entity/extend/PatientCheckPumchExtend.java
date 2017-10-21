package com.example.demo.entity.extend;

import com.example.demo.entity.PatientCheckPumchEntity;
import com.example.demo.entity.PictureInformationEntity;

import java.util.List;

public class PatientCheckPumchExtend {

    private long oid;
    private PatientInformationPumchExtend patientInformationPumchExtend;
    private String age;
    private String height;
    private String weight;
    private String diagnosis;
    private String remarks;
    private List<PictureInformationEntity> pictures;
    private String checkDate;
    private RegisterUserExtend createRegisterUser;
    private String createTime;
    private String updateTime;


    public static PatientCheckPumchExtend getExtendFromEntity(PatientCheckPumchEntity entity, PatientCheckPumchExtend extend) {
        extend.setOid(entity.getOid());
        extend.setAge(entity.getAge());
        extend.setHeight(entity.getHeight());
        extend.setWeight(entity.getWeight());
        extend.setDiagnosis(entity.getDiagnosis());
        extend.setRemarks(entity.getRemarks());
        extend.setCheckDate(entity.getCheckDate());
        extend.setCreateTime(entity.getCreateTime());
        extend.setUpdateTime(entity.getUpdateTime());
        return extend;
    }

    public PatientCheckPumchExtend() {
    }

    public PatientCheckPumchExtend(long oid, PatientInformationPumchExtend patientInformationPumchExtend, String age, String height, String weight, String diagnosis, String remarks, List<PictureInformationEntity> pictures, String checkDate, RegisterUserExtend createRegisterUser, String createTime, String updateTime) {
        this.oid = oid;
        this.patientInformationPumchExtend = patientInformationPumchExtend;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.diagnosis = diagnosis;
        this.remarks = remarks;
        this.pictures = pictures;
        this.checkDate = checkDate;
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

    public PatientInformationPumchExtend getPatientInformationPumchExtend() {
        return patientInformationPumchExtend;
    }

    public void setPatientInformationPumchExtend(PatientInformationPumchExtend patientInformationPumchExtend) {
        this.patientInformationPumchExtend = patientInformationPumchExtend;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<PictureInformationEntity> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureInformationEntity> pictures) {
        this.pictures = pictures;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
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

