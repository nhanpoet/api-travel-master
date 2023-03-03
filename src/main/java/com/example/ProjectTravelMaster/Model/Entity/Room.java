package com.example.ProjectTravelMaster.Model.Entity;

import java.util.List;

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

@Entity
@Table(name = "room")
public class Room {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
    private String roomNumber;
    private String roomDetail;
    private String roomDescription;
    private int roomBed;
    private int roomGuestsnumber;
    private double roomPrice;
    private String roomType;
    private String roomImage;
    private int roomStatus;
    private int hsId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="hsId", referencedColumnName = "hsId", insertable = false, updatable = false)    
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy="room", cascade=CascadeType.ALL)
	private List<OrderHotel> order_hotel; 

    public List<OrderHotel> getOrder_hotel() {
        return order_hotel;
    }
    public void setOrder_hotel(List<OrderHotel> order_hotel) {
        this.order_hotel = order_hotel;
    }

    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomDetail() {
        return roomDetail;
    }
    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }
    public String getRoomDescription() {
        return roomDescription;
    }
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    public int getRoomBed() {
        return roomBed;
    }
    public void setRoomBed(int roomBed) {
        this.roomBed = roomBed;
    }
    public int getRoomGuestsnumber() {
        return roomGuestsnumber;
    }
    public void setRoomGuestsnumber(int roomGuestsnumber) {
        this.roomGuestsnumber = roomGuestsnumber;
    }
    public double getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }
    
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }   
    public String getRoomImage() {
        return roomImage;
    }
    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }
    public int getRoomStatus() {
        return roomStatus;
    }
    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
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
