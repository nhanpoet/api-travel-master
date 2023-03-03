package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterprisePostRepository extends JpaRepository<EnterprisePost, Integer>{
	List<EnterprisePost> findByEpName(String ep_name);
	List<EnterprisePost> findByEnId(int en_id);
}
