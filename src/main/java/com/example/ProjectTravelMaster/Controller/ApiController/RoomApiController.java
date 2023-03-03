package com.example.ProjectTravelMaster.Controller.ApiController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectTravelMaster.Model.Entity.Room;
import com.example.ProjectTravelMaster.Model.Repository.RoomRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RoomApiController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/room")
    public List<Room> getAllHotel() {
        return roomRepository.findRoomByRoom();
    }

    @GetMapping("room/{id}")
    public Optional<Room> GetHotelById(@PathVariable Integer id) {

        return roomRepository.findById(id);
    }

}