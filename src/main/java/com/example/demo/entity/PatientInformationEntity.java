package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient_information", schema = "medical_camera", catalog = "")
public class PatientInformationEntity {
    private long oid;
    private String name;
    private String gender;
    private String birthday;
    private String pictureIds;
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
    @Column(name = "name", nullable = true, length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 60)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = true, length = 60)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

        PatientInformationEntity that = (PatientInformationEntity) o;

        if (oid != that.oid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (pictureIds != null ? !pictureIds.equals(that.pictureIds) : that.pictureIds != null) return false;
        if (createRegisterUserId != null ? !createRegisterUserId.equals(that.createRegisterUserId) : that.createRegisterUserId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (oid ^ (oid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (pictureIds != null ? pictureIds.hashCode() : 0);
        result = 31 * result + (createRegisterUserId != null ? createRegisterUserId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
