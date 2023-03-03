package com.example.ProjectTravelMaster.Model.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectTravelMaster.Model.Entity.Message;


public interface MessageRepository extends JpaRepository<Message, Integer>{
}
