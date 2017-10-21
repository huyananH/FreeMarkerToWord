package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient_check_pumch", schema = "medical_camera", catalog = "")
public class PatientCheckPumchEntity {
    private long oid;
    private Long patientInformationPumchId;
    private String age;
    private String height;
    private String weight;
    private String diagnosis;
    private String remarks;
    private String pictureIds;
    private String checkDate;
    private Long createRegisterUserId;
    private String createTime;
    private String updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "patient_information_pumch_id", nullable = true)
    public Long getPatientInformationPumchId() {
        return patientInformationPumchId;
    }

    public void setPatientInformationPumchId(Long patientInformationPumchId) {
        this.patientInformationPumchId = patientInformationPumchId;
    }

    @Basic
    @Column(name = "age", nullable = true, length = 60)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "height", nullable = true, length = 60)
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }


    @Basic
    @Column(name = "weight", nullable = true, length = 60)
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    @Basic
    @Column(name = "diagnosis", nullable = true, length = 60)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "remarks", nullable = true, length = 60)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "picture_ids", nullable = true, length = 60)
    public String getPictureIds() {
        return pictureIds;
    }

    public void setPictureIds(String pictureIds) {
        this.pictureIds = pictureIds;
    }

    @Basic
    @Column(name = "check_date", nullable = true, length = 60)
    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "create_register_user_id", nullable = true)
    public Long getCreateRegisterUserId() {
        return createRegisterUserId;
    }

    public void setCreateRegisterUserId(Long createRegisterUserId) {
        this.createRegisterUserId = createRegisterUserId;
    }

    @Basic
    @Column(name = "create_time", nullable = true, length = 60)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true, length = 60)
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientCheckPumchEntity that = (PatientCheckPumchEntity) o;

        if (oid != that.oid) return false;
        if (patientInformationPumchId != null ? !patientInformationPumchId.equals(that.patientInformationPumchId) : that.patientInformationPumchId != null)
            return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;

        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (pictureIds != null ? !pictureIds.equals(that.pictureIds) : that.pictureIds != null) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (createRegisterUserId != null ? !createRegisterUserId.equals(that.createRegisterUserId) : that.createRegisterUserId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (oid ^ (oid >>> 32));
        result = 31 * result + (patientInformationPumchId != null ? patientInformationPumchId.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (pictureIds != null ? pictureIds.hashCode() : 0);
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (createRegisterUserId != null ? createRegisterUserId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
