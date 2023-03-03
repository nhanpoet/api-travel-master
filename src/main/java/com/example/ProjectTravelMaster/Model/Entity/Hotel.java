package com.example.ProjectTravelMaster.Model.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hsId;
    private String hsName;
    private String hsDetail;
    private String hsDescription;
    private float hsPrice;
    private String hsAddress;
    private String hsWard;
    private String hsDistrict;
    private String hsProvince;
    private String hsCountry;
    private String hsPostalcode;
    private Boolean hsStatus;
    private String hsImg;
    private int hsBed;
    private int hsReviewCount;
    private float hsReviewStar;
    private String hsSaleOff;
    private int enId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "enId", referencedColumnName = "enId", insertable = false, updatable = false)
    @JsonBackReference
    private Enterprise enterprise;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> room;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Hotel_Img> hotelImg;

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public int getHsId() {
        return hsId;
    }

    public void setHsId(int hsId) {
        this.hsId = hsId;
    }

    public String getHsName() {
        return hsName;
    }

    public void setHsName(String hsName) {
        this.hsName = hsName;
    }

    public String getHsDetail() {
        return hsDetail;
    }

    public void setHsDetail(String hsDetail) {
        this.hsDetail = hsDetail;
    }

    public String getHsDescription() {
        return hsDescription;
    }

    public void setHsDescription(String hsDescription) {
        this.hsDescription = hsDescription;
    }

    

    public String getHsAddress() {
        return hsAddress;
    }

    public void setHsAddress(String hsAddress) {
        this.hsAddress = hsAddress;
    }

    public String getHsWard() {
        return hsWard;
    }

    public void setHsWard(String hsWard) {
        this.hsWard = hsWard;
    }

    public String getHsDistrict() {
        return hsDistrict;
    }

    public void setHsDistrict(String hsDistrict) {
        this.hsDistrict = hsDistrict;
    }

    public String getHsProvince() {
        return hsProvince;
    }

    public void setHsProvince(String hsProvince) {
        this.hsProvince = hsProvince;
    }

    public String getHsCountry() {
        return hsCountry;
    }

    public void setHsCountry(String hsCountry) {
        this.hsCountry = hsCountry;
    }

    public String getHsPostalcode() {
        return hsPostalcode;
    }

    public void setHsPostalcode(String hsPostalcode) {
        this.hsPostalcode = hsPostalcode;
    }

    public Boolean getHsStatus() {
        return hsStatus;
    }

    public void setHsStatus(Boolean hsStatus) {
        this.hsStatus = hsStatus;
    }

    
    public String getHsImg() {
        return hsImg;
    }

    public void setHsImg(String hsImg) {
        this.hsImg = hsImg;
    }

    public int getHsBed() {
        return hsBed;
    }

    public void setHsBed(int hsBed) {
        this.hsBed = hsBed;
    }

    public int getHsReviewCount() {
        return hsReviewCount;
    }

    public void setHsReviewCount(int hsReviewCount) {
        this.hsReviewCount = hsReviewCount;
    }

    public float getHsReviewStar() {
        return hsReviewStar;
    }

    public void setHsReviewStar(float hsReviewStar) {
        this.hsReviewStar = hsReviewStar;
    }

    public String getHsSaleOff() {
        return hsSaleOff;
    }

    public void setHsSaleOff(String hsSaleOff) {
        this.hsSaleOff = hsSaleOff;
    }

    public int getEnId() {
        return enId;
    }

    public void setEnId(int enId) {
        this.enId = enId;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Hotel_Img> getHotelImg() {
        return hotelImg;
    }

    public void setHotelImg(List<Hotel_Img> hotelImg) {
        this.hotelImg = hotelImg;
    }

    public float getHsPrice() {
        return hsPrice;
    }

    public void setHsPrice(float hsPrice) {
        this.hsPrice = hsPrice;
    }

    

}
