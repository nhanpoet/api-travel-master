package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePostComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterprisePostCommentRepository extends JpaRepository<EnterprisePostComment, Integer>{

	List<EnterprisePostComment> findByEpId(int id);
	
}
