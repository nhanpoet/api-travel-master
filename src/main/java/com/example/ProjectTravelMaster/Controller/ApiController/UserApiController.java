package com.example.ProjectTravelMaster.Controller.ApiController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Convert;

import com.example.ProjectTravelMaster.Model.Entity.Booking;
import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;
import com.example.ProjectTravelMaster.Model.Entity.Room;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.UserPost;
import com.example.ProjectTravelMaster.Model.Entity.Other.BookingUser;
import com.example.ProjectTravelMaster.Model.Entity.Other.UpdateProfileUser;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Repository.RoomRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserPostRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.Model.Service.BookingService;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;
import com.example.ProjectTravelMaster.Model.Service.OrderHotelService;
import com.example.ProjectTravelMaster.Model.Service.RoomService;
import com.example.ProjectTravelMaster.Model.Service.Impl.UserServiceImpl;
import com.example.ProjectTravelMaster.util.Mappings;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** @author Tran Nhan Hau **/

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserApiController {

	@Autowired
	UserRepository urep;

	@Autowired
	UserServiceImpl userService;

	@Autowired
    EnterpriseService enterpriseService;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomService roomService;

    @Autowired
    BookingService bookingService;

    @Autowired
    OrderHotelService orderHotelService;

	// get all user
	@GetMapping(Mappings.API_User)
	public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String user_id, String user_name) {

		try {
			List<User> user = new ArrayList<User>();
			user = userService.getAllUser(user_id, user_name);
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// add user
	@PostMapping(Mappings.API_User)
	public ResponseEntity<User> createUser(@RequestBody(required = true) User emp) {
		try {
			User _emp = userService.createUser(emp);
			if (_emp != null) {
				return new ResponseEntity<>(_emp, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// update user
	@PutMapping(value = Mappings.API_UserGetId, consumes = { "application/json" })
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UpdateProfileUser userData) {
		try {
			User users = userService.updateUser(id, userData);
			if (users == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(users, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete user
	@DeleteMapping(Mappings.API_UserGetId)
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		try {
			String bool = userService.deleteUser(id);
			if (bool != null) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("user/{id}")
	public Optional<User> GetHotelById(@PathVariable Integer id) {

		return urep.findById(id);
	}

	@PostMapping("/user-booking")
	Integer newBooking(@RequestBody String id) {

		try {
			Gson gson = new Gson();
			BookingUser bookingUser = gson.fromJson(id, BookingUser.class);
			Room room = roomRepository.findById(Integer.parseInt(bookingUser.getRoomId())).get();
			Booking booking = new Booking();

			DateFormat simpleDateFormat = new SimpleDateFormat("DD-MMM-yyyy");               
            Date date1 = null;
            Date date2 = null;
            date1 = simpleDateFormat.parse(bookingUser.getStartD());
            date2 = simpleDateFormat.parse(bookingUser.getEndD());

			//sum date
			long sumdate = 0;
			sumdate = orderHotelService.sumDayBookingUserHotel(bookingUser.getStartD(),bookingUser.getEndD());
			if (sumdate == 0) {
				sumdate = 1;
			}
			double Subtotal = sumdate * room.getRoomPrice();
			// create booking
			booking.setBoTotalprice(Subtotal);
			booking.setUserId(Integer.parseInt(bookingUser.getUserId()));
			booking.setEnId(room.getHotel().getEnId());
			Booking bo = bookingService.CreateBooking(booking);
			// get id from booking
			OrderHotel orderhotel = new OrderHotel();
			orderhotel.setOhCode(bookingUser.getBookingCode());
			orderhotel.setOhQuantity(1);
			orderhotel.setOhTotalprice(room.getRoomPrice());
			orderhotel.setBoId(bo.getBoId());
			orderhotel.setOhStatus(2);
			orderhotel.setOhTimecheckin(date1);
			orderhotel.setOhTimecheckout(date2);
			orderhotel.setRoomId(room.getRoomId());
			// create order hotel
			orderHotelService.createOrderHotel(orderhotel);
			// update status room n
			roomService.UpdateBookingUserRoom(room);
		} catch (Exception e) {
			e.toString();
			// TODO: handle exception
		}	
		return 1;
	}

	@Autowired
	BookingRepository bookingRepository;


	@GetMapping("/getbooking/{id}")
	public ResponseEntity<List<Booking>> getBookingUser(@PathVariable int id) {

		try {
			List<Booking> bookings = new ArrayList<Booking>();
			bookings = bookingRepository.findByUserId(id);
			if (bookings != null) {
				return new ResponseEntity<>(bookings, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getroombooking/{id}")
	public ResponseEntity<Room> getRoomUser(@PathVariable int id) {

		try {
			
			Optional<Booking> booking = bookingRepository.findById(id);
			int idroom = booking.get().getOrder_hotel().get(0).getRoomId();
			Room rooms = new Room();
			Optional<Room> room = roomRepository.findById(idroom);

			rooms.setRoomDescription(room.get().getRoomDescription());
			rooms.setRoomDetail(room.get().getRoomDetail());
			rooms.setRoomGuestsnumber(room.get().getRoomGuestsnumber());
			rooms.setRoomId(room.get().getRoomId());
			rooms.setHsId(room.get().getHsId());
			rooms.setRoomBed(room.get().getRoomBed());
			rooms.setRoomImage(room.get().getRoomImage());
			rooms.setRoomNumber(room.get().getRoomNumber());
			rooms.setRoomPrice(room.get().getRoomPrice());
			rooms.setRoomStatus(room.get().getRoomStatus());
			rooms.setRoomType(room.get().getRoomType());
			
			return new ResponseEntity<>(rooms, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
