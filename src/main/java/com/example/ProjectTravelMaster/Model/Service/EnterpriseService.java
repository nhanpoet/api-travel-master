package com.example.ProjectTravelMaster.Model.Service;


import java.util.List;
import com.example.ProjectTravelMaster.Model.Entity.Enterprise;


public interface EnterpriseService {

	List<Enterprise> getAllEnterprise();

	Enterprise getEnterpriseById(String en_id);

	List<Enterprise> createEnterprise(Enterprise enterprise);
	
	Enterprise updateEnterprise(int id, Enterprise enterprise);

	String deleteEnterprise(int id);

}
