package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.Hotel;
import com.example.ProjectTravelMaster.Model.Entity.Room;
import com.example.ProjectTravelMaster.Model.Repository.RoomRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;
import com.example.ProjectTravelMaster.Model.Service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRep;

    @Autowired
    EnterpriseService enterpriseService;

    public Page<Room> findPaginated(Pageable pageable, String id) {

        Enterprise enterprises = enterpriseService.getEnterpriseById(id);
        List<Hotel> hotels = enterprises.getHotel();
        List<Room> rooms = hotels.get(0).getRoom();

        int pageSize = 9;
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Room> list;

        if (rooms.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, rooms.size());
            list = rooms.subList(startItem, toIndex);
        }
        Page<Room> roomPage = new PageImpl<Room>(list, PageRequest.of(currentPage, pageSize), rooms.size());

        return roomPage;
    }

    public String getHsIdFormRoom(String id) {
        Enterprise enterprises = enterpriseService.getEnterpriseById(id);
        String hsId = String.valueOf(enterprises.getHotel().get(0).getEnId());
        return hsId;
    }

    public String UploadFileImageRoom(MultipartFile file, HttpSession session) throws IOException {

        String path = session.getServletContext().getRealPath("/");
        String fileName = file.getOriginalFilename();
        file.transferTo(Path.of(path + "/" + "upload/image_room/" + fileName));
        return fileName;
    }

    public Room CreateRoomHotel(Room room){
        try {
            if (room != null) {
                return roomRep.save(room);
            } else {
                return null;
            }         
        } catch (Exception e) {
            return null;
            // TODO: handle exception
        }
    }

    public Room getRoomBooking(String enId, String hsId, String roomId) {
        int iden = Integer.valueOf(enId);
        int idhs = Integer.valueOf(hsId);
        int idroom = Integer.valueOf(roomId);
        Room room = roomRep.findRoomDetailByEnterprise(idroom, idhs, iden);
        return room;
    }

    public Room UpdateBookingRoom(Room room) {

        if (room.getRoomId() != 0) {
            Optional<Room> data = roomRep.findById(room.getRoomId());
            Room _room = data.get();
            _room.setRoomStatus(2);
            return roomRep.save(_room);
        } else {
            return null;
        }

    }

    public Room UpdateBookingUserRoom(Room room) {

        if (room.getRoomId() != 0) {
            Optional<Room> data = roomRep.findById(room.getRoomId());
            Room _room = data.get();
            _room.setRoomStatus(1);
            return roomRep.save(_room);
        } else {
            return null;
        }

    }

    public Room updateRoomCheckout(Room room){
        try {
			String _id = String.valueOf(room.getRoomId());
			if (_id == null || room == null) {
				return null;
			} else {
				Optional<Room> roomData = roomRep.findById(room.getRoomId());
				Room _room = roomData.get();
                _room.setRoomStatus(0);
				return roomRep.save(_room);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }
    // public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") +
    // "../upload/image_room";

    // public String UploadFileImageRoom(MultipartFile file) throws IOException{
    // StringBuilder fileNames = new StringBuilder();
    // Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY,
    // file.getOriginalFilename());
    // fileNames.append(file.getOriginalFilename());
    // Files.write(fileNameAndPath, file.getBytes());
    // return file.getName();
    // }

}