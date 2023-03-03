package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.Booking;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public Booking CreateBooking(Booking booking) {
        try {
            if (booking.getUserId() == 0) {
                booking.setUserId(1);
                booking.setBoStatus(true);
                return bookingRepository.save(booking);
            } else {
                booking.setBoStatus(true);
                return bookingRepository.save(booking);
            }
        } catch (Exception e) {
            return null;
        }

    }

    public Optional<Booking> FindBookingById(int boId) {
        try {
            return bookingRepository.findById(boId);
        } catch (Exception e) {
            return null;
        }

    }

    public Booking UpdateBooking(Booking booking){
        try {
			String _id = String.valueOf(booking.getBoId());
			if (_id == null || booking == null) {
				return null;
			} else {
				Optional<Booking> bookingData = bookingRepository.findById(booking.getBoId());
				Booking _booking = bookingData.get();
                _booking.setBoName(booking.getBoName());
                _booking.setBoPhone(booking.getBoPhone());
                _booking.setBoStatus(false);
                _booking.setBoTotalprice(booking.getBoTotalprice());
				return bookingRepository.save(_booking);
			}
		} catch (Exception e) {
			return null;
		}
    }
    public Booking UpdateBookingCheckin(Booking booking){
        try {
			String _id = String.valueOf(booking.getBoId());
			if (_id == null || booking == null) {
				return null;
			} else {
				Optional<Booking> bookingData = bookingRepository.findById(booking.getBoId());
				Booking _booking = bookingData.get();
                _booking.setBoName(booking.getBoName());
                _booking.setBoPhone(booking.getBoPhone());
                _booking.setBoStatus(true);
                _booking.setBoTotalprice(booking.getBoTotalprice());
				return bookingRepository.save(_booking);
			}
		} catch (Exception e) {
			return null;
		}
    }

}
