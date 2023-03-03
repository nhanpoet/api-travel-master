package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjectTravelMaster.Model.Entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
    //SELECT d FROM Employee e JOIN e.department d
    @Query("SELECT r FROM Room r WHERE r.roomNumber = ?1")
	Room findRoomByNumberRoom(String roomNumber);

    @Query("SELECT r FROM Room r WHERE r.roomStatus = 0")
	List<Room> findRoomByRoom();

    @Query("SELECT r FROM Room r LEFT JOIN Hotel h ON r.hsId = h.hsId LEFT JOIN Enterprise e ON h.enId = e.enId WHERE r.roomNumber = ?1 and h.hsId =?2 and e.enId = ?3")
	Room findRoomByEnterprise(String roomNumber,int hsId,int enId);

    @Query("SELECT r FROM Room r LEFT JOIN Hotel h ON r.hsId = h.hsId LEFT JOIN Enterprise e ON h.enId = e.enId WHERE r.roomId = ?1 and h.hsId =?2 and e.enId = ?3")
	Room findRoomDetailByEnterprise(int roomId,int hsId,int enId);

    @Query("SELECT r FROM Room r WHERE r.roomId = ?1")
    Room findByRoomId(int roomId);
}
