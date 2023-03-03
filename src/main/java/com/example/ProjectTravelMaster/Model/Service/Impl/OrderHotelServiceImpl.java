package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;
import com.example.ProjectTravelMaster.Model.Repository.OrderHotelRepository;
import com.example.ProjectTravelMaster.Model.Service.OrderHotelService;

@Service
public class OrderHotelServiceImpl implements OrderHotelService {

    @Autowired
    OrderHotelRepository orderHotelRepository;

    public OrderHotel createOrderHotel(OrderHotel orderHotel) {
        try {
            return orderHotelRepository.save(orderHotel);
        } catch (Exception e) {
            return null;
        }

    }

    public OrderHotel findOrderHotelByIdRoom(int roomId) {
        try {
            return orderHotelRepository.findOrderHotelByIdRoom(roomId);
        } catch (Exception e) {
            return null;
        }
    }
    public OrderHotel findOrderHotelByIdRoomCheckin(int roomId) {
        try {
            return orderHotelRepository.findOrderHotelByIdRoomCheckin(roomId);
        } catch (Exception e) {
            return null;
        }
    }

    public long sumDayHotel(Date ohTimeCheckin) {
        try {

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      
            Date currentDate = new Date();
                  //PLus 24h
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());  
            cal.add(Calendar.HOUR, 24);
          
            Date date1 = null;
            Date date2 = null;
    
            String startDate = ohTimeCheckin.toString();
            String endDate = simpleDateFormat.format(currentDate);
         
            date1 = simpleDateFormat.parse(startDate);
            date2 = simpleDateFormat.parse(endDate);
         
            long getDiff = date2.getTime() - date1.getTime();
         
            // using TimeUnit class from java.util.concurrent package
            long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);  

            return getDaysDiff;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public long sumDayBookingUserHotel(String startD,String endD) {
        try {

            DateFormat simpleDateFormat = new SimpleDateFormat("DD-MMM-yyyy");  
            // Date currentDate = new Date();
            //       //PLus 24h
            // Calendar cal = Calendar.getInstance();
            // cal.setTime(new Date());  
            // cal.add(Calendar.HOUR, 24);
        
            // String startDate = startD.toString();
            // String endDate = endD.toString();

            Date date1 = null;
            Date date2 = null;
            date1 = simpleDateFormat.parse(startD);
            date2 = simpleDateFormat.parse(endD);
         
            long getDiff = date2.getTime() - date1.getTime();
         
            // using TimeUnit class from java.util.concurrent package
            long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);  

            return getDaysDiff;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public OrderHotel updaHotelCheckout(OrderHotel orderHotel){
        try {
			String _id = String.valueOf(orderHotel.getOhId());
			if (_id == null || orderHotel == null) {
				return null;
			} else {
				Optional<OrderHotel> ohData = orderHotelRepository.findById(orderHotel.getOhId());
				OrderHotel _orderhotel = ohData.get();
				// _enterprise.setEnterprise_type(enterprise.getEnterprise_type());
                _orderhotel.setOhStatus(orderHotel.getOhStatus());
                _orderhotel.setOhTotalprice(orderHotel.getOhTotalprice());
				return orderHotelRepository.save(_orderhotel);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }

    public OrderHotel updaHotelCheckin(OrderHotel orderHotel){
        try {
			String _id = String.valueOf(orderHotel.getOhId());
			if (_id == null || orderHotel == null) {
				return null;
			} else {
				Optional<OrderHotel> ohData = orderHotelRepository.findById(orderHotel.getOhId());
				OrderHotel _orderhotel = ohData.get();
				// _enterprise.setEnterprise_type(enterprise.getEnterprise_type());
                _orderhotel.setOhStatus(orderHotel.getOhStatus());
                _orderhotel.setOhTotalprice(orderHotel.getOhTotalprice());
				return orderHotelRepository.save(_orderhotel);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }

}
