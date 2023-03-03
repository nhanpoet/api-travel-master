package com.example.ProjectTravelMaster.Model.Service;


import java.util.List;
import java.util.Optional;

import com.example.ProjectTravelMaster.Model.Entity.Booking;

public interface BookingService {
    Booking CreateBooking(Booking booking);
    Optional<Booking> FindBookingById(int boId);
    Booking UpdateBooking(Booking booking);
    Booking UpdateBookingCheckin(Booking booking);
}