package com.example.ProjectTravelMaster.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectTravelMaster.Model.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    
}
