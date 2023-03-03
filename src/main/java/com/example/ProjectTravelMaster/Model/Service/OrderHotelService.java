package com.example.ProjectTravelMaster.Model.Service;

import java.util.Date;

import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;

public interface OrderHotelService {
    OrderHotel createOrderHotel(OrderHotel orderHotel);
    OrderHotel findOrderHotelByIdRoom(int roomId);
    OrderHotel findOrderHotelByIdRoomCheckin(int roomId);
    long sumDayHotel(Date ohTimeCheckin);
    OrderHotel updaHotelCheckout(OrderHotel orderHotel);
    OrderHotel updaHotelCheckin(OrderHotel orderHotel);
    long sumDayBookingUserHotel(String startD,String endD);
}
