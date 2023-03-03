package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnterpriseAccountRepository extends JpaRepository<EnterpriseAccount, Integer>{
	
	
	@Query("SELECT ec FROM EnterpriseAccount ec WHERE ec.ecEmail = ?1 and ec.ecPassword = ?2")
	List<EnterpriseAccount> findAccountLogin(String ec_email,String ec_password);
}
