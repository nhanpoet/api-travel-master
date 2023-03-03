package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectTravelMaster.Model.Entity.MessageChannel;

public interface MessageChannelRepository extends JpaRepository<MessageChannel, Integer>{
    List<MessageChannel> findByMcId(int mcId);
}
