package com.example.ProjectTravelMaster.Model.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "hotel_img")
public class Hotel_Img {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hiId;
    private String hiUrlImg;
    private int hsId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hsId", referencedColumnName = "hsId", insertable = false, updatable = false)
    @JsonBackReference
    private Hotel hotel;

    public Hotel_Img() {
    }

    public int getHiId() {
        return hiId;
    }

    public void setHiId(int hiId) {
        this.hiId = hiId;
    }

    public String getHiUrlImg() {
        return hiUrlImg;
    }

    public void setHiUrlImg(String hiUrlImg) {
        this.hiUrlImg = hiUrlImg;
    }

    public int getHsId() {
        return hsId;
    }

    public void setHsId(int hsId) {
        this.hsId = hsId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
