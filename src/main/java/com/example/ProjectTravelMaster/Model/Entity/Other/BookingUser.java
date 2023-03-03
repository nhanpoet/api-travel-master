package com.example.ProjectTravelMaster.Model.Entity.Other;

public class BookingUser {

    private String bookingCode;
    private String userId;
    private String roomId;
    private String startD;
    private String endD;


    
    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStartD() {
        return startD;
    }

    public void setStartD(String startD) {
        this.startD = startD;
    }

    public String getEndD() {
        return endD;
    }

    public void setEndD(String endD) {
        this.endD = endD;
    }

}
