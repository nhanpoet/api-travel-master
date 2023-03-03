package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.Room;

public interface RoomService {
    Page<Room> findPaginated(Pageable pageable, String id);

    String UploadFileImageRoom(MultipartFile file, HttpSession session) throws IOException;

    String getHsIdFormRoom(String id);

    Room getRoomBooking(String enId, String hsId, String roomId);

    Room UpdateBookingRoom(Room room);

    Room updateRoomCheckout(Room room);
    Room CreateRoomHotel(Room room);
    Room UpdateBookingUserRoom(Room room);
    
}
