package com.example.ProjectTravelMaster.Controller.EnterpriseController;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.Booking;
import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostComment;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostImage;
import com.example.ProjectTravelMaster.Model.Entity.Hotel;
import com.example.ProjectTravelMaster.Model.Entity.Message;
import com.example.ProjectTravelMaster.Model.Entity.MessageChannel;
import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;
import com.example.ProjectTravelMaster.Model.Entity.Room;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.Other.Post;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Repository.EnterprisePostImageRepository;
import com.example.ProjectTravelMaster.Model.Repository.MessageChannelRepository;
import com.example.ProjectTravelMaster.Model.Repository.MessageRepository;
import com.example.ProjectTravelMaster.Model.Repository.OrderHotelRepository;
import com.example.ProjectTravelMaster.Model.Repository.RoomRepository;
import com.example.ProjectTravelMaster.Model.Service.BookingService;
import com.example.ProjectTravelMaster.Model.Service.EnterprisePostCommentService;
import com.example.ProjectTravelMaster.Model.Service.EnterprisePostService;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;
import com.example.ProjectTravelMaster.Model.Service.OrderHotelService;
import com.example.ProjectTravelMaster.Model.Service.RoomService;

@Controller
public class HotelEnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    EnterprisePostService enterprisePostService;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomService roomService;

    @Autowired
    BookingService bookingService;

    @Autowired
    OrderHotelService orderHotelService;

    @RequestMapping(value = "hotel_list", method = RequestMethod.GET)
    public String Enterprise_hotel_list(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Room> roomPage = roomService.findPaginated(PageRequest.of(currentPage - 1, pageSize), setEnterprise);

        model.addAttribute("RoomHotel", roomPage);

        int totalPages = roomPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("hsId", roomService.getHsIdFormRoom(setEnterprise));
        model.addAttribute("enId", setEnterprise);

        return "enterprise_hotel_list";
    }

    @RequestMapping(value = "/hotel_search", method = RequestMethod.POST)
    public String SearchRoom(Model model, String roomNumber, String enId, String hsId) {
        int iden = Integer.valueOf(enId);
        int idhs = Integer.valueOf(hsId);
        Room room = roomRepository.findRoomByEnterprise(roomNumber, idhs, iden);
        model.addAttribute("RoomHotel", room);
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        return "enterprise_hotel_list";
    }

    @RequestMapping(value = "/hotel_add", method = RequestMethod.GET)
    public String HotelAdd_View(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
            Model model) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(setEnterprise);
        List<Hotel> hotels = enterprise.getHotel();
        model.addAttribute("hsId", hotels.get(0).getHsId());

        return "enterprise_hotel_add";
    }

    @RequestMapping(value = "/hotel_room_create", method = RequestMethod.POST)
    public String HotelAdd(Room room, Model model, @RequestParam("image") MultipartFile file, HttpSession session)
            throws IOException {

        String namefile = roomService.UploadFileImageRoom(file, session);
        room.setRoomImage(namefile);
        // room.setHsId(Integer.valueOf(Idhs));
        roomService.CreateRoomHotel(room);

        return "redirect:/hotel_list";
    }

    @RequestMapping(value = "/hotel_booking", method = RequestMethod.POST)
    public String HotelBooking(Model model, String enId, String hsId, String roomId) {
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        model.addAttribute("RoomHotel", room);
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        model.addAttribute("NumberRanDom", randomWithNextInt);
        return "enterprise_hotel_booking";
    }

    @Autowired
    OrderHotelRepository orderHotelRepository;

    @RequestMapping(value = "/hotel_room_booking", method = RequestMethod.POST)
    public String HotelBookingRoom(Model model, Booking booking, Room room, OrderHotel orderhotel) {

        // create booking
        booking.setBoTotalprice(room.getRoomPrice());
        Booking bo = bookingService.CreateBooking(booking);
        // set id from booking
        orderhotel.setOhQuantity(1);
        orderhotel.setOhTotalprice(room.getRoomPrice());
        orderhotel.setBoId(bo.getBoId());
        orderhotel.setOhStatus(1);
        orderhotel.setRoomId(room.getRoomId());
        // create order hotel
        orderHotelService.createOrderHotel(orderhotel);
        // update status room
        roomService.UpdateBookingRoom(room);
        return "redirect:/hotel_list";
    }

    @RequestMapping(value = "/hotel_checkin", method = RequestMethod.POST)
    public String HotelCheckin(Model model, String enId, String hsId, String roomId) {
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        OrderHotel orderHotel = orderHotelService.findOrderHotelByIdRoomCheckin(room.getRoomId());
        Booking booking = orderHotel.getBooking();
        booking.getBoId();
        User user = booking.getUser();

        model.addAttribute("OrderHotel", orderHotel);
        model.addAttribute("BookingHotel", booking);
        model.addAttribute("UserHotel", user);
        model.addAttribute("RoomHotel", room);
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);

        return "enterprise_hotel_checkin";
    }

    @RequestMapping(value = "/hotel_room_checkin", method = RequestMethod.POST)
    public String HotelCheckinRoom(Model model, Booking booking, Room room, OrderHotel orderhotel) {

        // update checkin
        booking.setBoTotalprice(room.getRoomPrice());
        Booking bo = bookingService.UpdateBookingCheckin(booking);
        // set id from booking
        orderhotel.setOhQuantity(1);
        orderhotel.setOhTotalprice(room.getRoomPrice());
        orderhotel.setBoId(booking.getBoId());
        orderhotel.setOhStatus(1);
        orderhotel.setRoomId(room.getRoomId());
        // create order hotel
        orderHotelService.updaHotelCheckin(orderhotel);
        // update status room
        roomService.UpdateBookingRoom(room);
        return "redirect:/hotel_list";
    }

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping(value = "/hotel_checkout", method = RequestMethod.POST)
    public String HotelCheckout(Model model, String enId, String hsId, String roomId) {
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        OrderHotel orderHotel = orderHotelService.findOrderHotelByIdRoom(room.getRoomId());
        model.addAttribute("RoomHotel", room);
        model.addAttribute("OrderHotel", orderHotel);
        model.addAttribute("BookingHotel", orderHotel.getBooking());
        model.addAttribute("EnterpriseHotel", orderHotel.getBooking().getEnterprise());
        model.addAttribute("UserHotel", orderHotel.getBooking().getUser());
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        model.addAttribute("roomId", roomId);
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        model.addAttribute("NumberRanDom", randomWithNextInt);
        // sum day booking hotel
        long sumdate = 0;
        sumdate = orderHotelService.sumDayHotel(orderHotel.getOhTimecheckin());
        if (sumdate == 0) {
            sumdate = 1;
        }
        double Subtotal = sumdate * room.getRoomPrice();
        float Tax = (float) (Subtotal * (9.3 / 100));
        double Total = Subtotal + Tax;
        model.addAttribute("Day", sumdate);
        model.addAttribute("Subtotal", Subtotal);
        model.addAttribute("Tax", Tax);
        model.addAttribute("Total", Total);
        return "enterprise_hotel_checkout";
    }

    @RequestMapping(value = "/hotel_checkout_print", method = RequestMethod.POST)
    public String HotelCheckoutPrint(Model model, String enId, String hsId, String roomId, String NumberRanDom) {
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        OrderHotel orderHotel = orderHotelService.findOrderHotelByIdRoom(room.getRoomId());
        model.addAttribute("RoomHotel", room);
        model.addAttribute("OrderHotel", orderHotel);
        model.addAttribute("BookingHotel", orderHotel.getBooking());
        model.addAttribute("EnterpriseHotel", orderHotel.getBooking().getEnterprise());
        model.addAttribute("UserHotel", orderHotel.getBooking().getUser());
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        model.addAttribute("NumberRanDom", randomWithNextInt);

        // sum day booking hotel
        long sumdate = 0;
        sumdate = orderHotelService.sumDayHotel(orderHotel.getOhTimecheckin());
        if (sumdate == 0) {
            sumdate = 1;
        }
        double Subtotal = sumdate * room.getRoomPrice();
        float Tax = (float) (Subtotal * (9.3 / 100));
        double Total = Subtotal + Tax;
        model.addAttribute("Day", sumdate);
        model.addAttribute("Subtotal", Subtotal);
        model.addAttribute("Tax", Tax);
        model.addAttribute("Total", Total);

        // update booking
        Booking _booking = orderHotel.getBooking();
        _booking.setBoTotalprice(Total);
        _booking.setBoName(NumberRanDom);
        bookingService.UpdateBooking(_booking);

        // update order hotel
        OrderHotel _orderhotel = orderHotel;
        _orderhotel.setOhTotalprice(Total);
        _orderhotel.setOhStatus(0);
        orderHotelService.updaHotelCheckout(_orderhotel);

        // update status room
        Room _room = room;
        roomService.updateRoomCheckout(_room);

        return "enterprise_hotel_checkout_print";
    }

    @RequestMapping(value = "/hotel_checkout_pay", method = RequestMethod.POST)
    public String HotelCheckoutPay(Model model, String enId, String hsId, String roomId, String NumberRanDom) {
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        OrderHotel orderHotel = orderHotelService.findOrderHotelByIdRoom(room.getRoomId());
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        model.addAttribute("NumberRanDom", randomWithNextInt);
        // sum day booking hotel
        long sumdate = 0;
        sumdate = orderHotelService.sumDayHotel(orderHotel.getOhTimecheckin());
        if (sumdate == 0) {
            sumdate = 1;
        }
        double Subtotal = sumdate * room.getRoomPrice();
        float Tax = (float) (Subtotal * (9.3 / 100));
        double Total = Subtotal + Tax;

        // update booking
        Booking _booking = orderHotel.getBooking();
        _booking.setBoTotalprice(Total);
        _booking.setBoName(NumberRanDom);
        bookingService.UpdateBooking(_booking);

        // update order hotel
        OrderHotel _orderhotel = orderHotel;
        _orderhotel.setOhTotalprice(Total);
        _orderhotel.setOhStatus(0);
        orderHotelService.updaHotelCheckout(_orderhotel);

        // update status room
        Room _room = room;
        roomService.updateRoomCheckout(_room);
        return "redirect:/hotel_list";
    }


    @RequestMapping(value = "/hotel_post", method = RequestMethod.GET)
    public String HotelPost_View(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
            Model model) {

        Enterprise enterprise = enterpriseService.getEnterpriseById(setEnterprise);
        model.addAttribute("PostHotel", enterprise.getEnterprise_post());
        model.addAttribute("CountCmt", enterprise.getEnterprise_post().get(0).getEnterprise_post_comment().size());

        return "enterprise_hotel_post";
    }

    @RequestMapping(value = "/hotel_post_add", method = RequestMethod.GET)
    public String HotelPostCreate_View(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
            Model model) {

        Enterprise enterprise = enterpriseService.getEnterpriseById(setEnterprise);
        model.addAttribute("ecId", enterprise.getEnterprise_account().get(0).getEcId());
        model.addAttribute("enId", enterprise.getEnId());

        return "enterprise_hotel_post_add";
    }

    @Autowired
    EnterprisePostImageRepository enterprisePostImageRepository;
    @RequestMapping(value = "/hotel_post_create", method = RequestMethod.POST)
    public String HotelPostCreate(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,EnterprisePost enterprisePost,
            Model model, @RequestParam("image") MultipartFile file,HttpSession session) {

            try {
                // List<EnterprisePostImage> images = enterprisePostImageRepository.save("")
                // enterprisePost.setEnterprise_post_image(images);
                // String namefile = enterprisePostService.UploadFileImagePost(file, session);
                EnterprisePost _enterprisePost = enterprisePostService.createEnterprisePost(enterprisePost);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return "redirect:/hotel_post";
    }

    @Autowired
    MessageChannelRepository messageChannelRepository;

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(value = "/hotel_message", method = RequestMethod.GET)
    public String HotelMessage_View(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
            String mcId, String mesTitle,
            Model model) {

        Enterprise enterprise = enterpriseService.getEnterpriseById(setEnterprise);
        model.addAttribute("Message", enterprise.getMessagechannel());

        if (mcId != null && mesTitle == null) {
            int id = Integer.parseInt(mcId);
            model.addAttribute("MessageUser", messageChannelRepository.findByMcId(id));
        }
        if (mesTitle != null && mcId != null) {
            int id = Integer.parseInt(mcId);
            model.addAttribute("MessageUser", messageChannelRepository.findByMcId(id));
            Message message = new Message();
            message.setMcId(id);
            message.setMesTitle(mesTitle);
            message.setMesType(2);
            message.setMesSender(enterprise.getEnNamecompany());

            Date date = new Date(System.currentTimeMillis());
            message.setMesTime(date);
            messageRepository.save(message);

        }

        return "enterprise_hotel_message";
    }

    @Autowired
    EnterprisePostCommentService _enterprisePostCommentService;

    @RequestMapping(value = "/postcomment", method = RequestMethod.POST)
    public String HotelPostComment(EnterprisePostComment enterprisePostComment) {

        try {
            EnterprisePostComment _enterprisePostComment = _enterprisePostCommentService.createEnterprisePostComment(enterprisePostComment);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/hotel_post";
    }

    // @RequestMapping(value = "/messageuser/{id}", method = RequestMethod.GET)
    // public String HotelMessageUser_View(@CookieValue(value = "setEnterprise",
    // defaultValue = "") String setEnterprise,Model model,@PathVariable String id)
    // {

    // Enterprise enterprise = enterpriseService.getEnterpriseById(setEnterprise);

    // model.addAttribute("Message", enterprise.getMessagechannel());
    // int idm = Integer.valueOf(id);
    // model.addAttribute("MessageUser", messageChannelRepository.findByMcId(idm));

    // return "enterprise_hotel_message";
    // }

}
