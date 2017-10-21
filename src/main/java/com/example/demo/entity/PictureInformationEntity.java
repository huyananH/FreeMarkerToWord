package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "picture_information", schema = "medical_camera", catalog = "")
public class PictureInformationEntity {
    private long oid;
    private String pictureFileName;
    private String pictureDescription;
    private String photoTime;
    private Long createRegisterUserId;

    @Id
    @Column(name = "id", nullable = false)
    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "picture_file_name", nullable = true, length = 200)
    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    @Basic
    @Column(name = "picture_description", nullable = true, length = 120)
    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    @Basic
    @Column(name = "photo_time", nullable = true, length = 60)
    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime;
    }

    @Basic
    @Column(name = "create_register_user_id", nullable = true)
    public Long getCreateRegisterUserId() {
        return createRegisterUserId;
    }

    public void setCreateRegisterUserId(Long createRegisterUserId) {
        this.createRegisterUserId = createRegisterUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PictureInformationEntity that = (PictureInformationEntity) o;

        if (oid != that.oid) return false;
        if (pictureFileName != null ? !pictureFileName.equals(that.pictureFileName) : that.pictureFileName != null)
            return false;
        if (pictureDescription != null ? !pictureDescription.equals(that.pictureDescription) : that.pictureDescription != null)
            return false;
        if (photoTime != null ? !photoTime.equals(that.photoTime) : that.photoTime != null) return false;
        if (createRegisterUserId != null ? !createRegisterUserId.equals(that.createRegisterUserId) : that.createRegisterUserId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (oid ^ (oid >>> 32));
        result = 31 * result + (pictureFileName != null ? pictureFileName.hashCode() : 0);
        result = 31 * result + (pictureDescription != null ? pictureDescription.hashCode() : 0);
        result = 31 * result + (photoTime != null ? photoTime.hashCode() : 0);
        result = 31 * result + (createRegisterUserId != null ? createRegisterUserId.hashCode() : 0);
        return result;
    }
}
