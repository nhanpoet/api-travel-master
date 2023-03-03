package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostComment;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostImage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterprisePostImageRepository extends JpaRepository<EnterprisePostImage, Integer>{
	
}
