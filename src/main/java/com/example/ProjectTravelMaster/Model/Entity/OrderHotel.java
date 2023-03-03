package com.example.ProjectTravelMaster.Model.Entity;

import java.util.Date;
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
@Table(name = "order_hotel")
public class OrderHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ohId;
    private int ohQuantity;
    private double ohTotalprice;
    private String ohCode;
    private Date ohTimecheckin;
    private Date ohTimecheckout;
    private int ohStatus;
    private int boId;
    private int roomId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "boId", referencedColumnName = "boId", insertable = false, updatable = false)
    @JsonBackReference
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", insertable = false, updatable = false)
    @JsonBackReference
    private Room room;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getOhId() {
        return ohId;
    }

    public void setOhId(int ohId) {
        this.ohId = ohId;
    }

    public int getOhQuantity() {
        return ohQuantity;
    }

    public void setOhQuantity(int ohQuantity) {
        this.ohQuantity = ohQuantity;
    }

    public double getOhTotalprice() {
        return ohTotalprice;
    }

    public void setOhTotalprice(double ohTotalprice) {
        this.ohTotalprice = ohTotalprice;
    }

    public String getOhCode() {
        return ohCode;
    }

    public void setOhCode(String ohCode) {
        this.ohCode = ohCode;
    }

    public Date getOhTimecheckin() {
        return ohTimecheckin;
    }

    public void setOhTimecheckin(Date ohTimecheckin) {
        this.ohTimecheckin = ohTimecheckin;
    }

    public Date getOhTimecheckout() {
        return ohTimecheckout;
    }

    public void setOhTimecheckout(Date ohTimecheckout) {
        this.ohTimecheckout = ohTimecheckout;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getBoId() {
        return boId;
    }

    public void setBoId(int boId) {
        this.boId = boId;
    }

    public int getOhStatus() {
        return ohStatus;
    }

    public void setOhStatus(int ohStatus) {
        this.ohStatus = ohStatus;
    }

}
