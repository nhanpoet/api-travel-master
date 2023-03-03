package com.example.ProjectTravelMaster.Controller.ApiController;

import java.util.ArrayList;
import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;
import com.example.ProjectTravelMaster.util.Mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EnterpriseApiController {
	
	@Autowired
	EnterpriseService enterpriseService;
	
	@GetMapping(Mappings.API_Enterprise)
	public ResponseEntity<List<Enterprise>> getEnterprise(){
    	try {
        	List<Enterprise> user = new ArrayList<Enterprise>();
        	user = enterpriseService.getAllEnterprise();
        	if (user != null) {
        		return new ResponseEntity<> (user,HttpStatus.OK);  
			}else {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}   			    		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}             
	}
	// create enterprise
	@PostMapping(Mappings.API_Enterprise)
	public ResponseEntity<List<Enterprise>> createEnterprise(@RequestBody(required = true) Enterprise enterprise){
		try {
			List<Enterprise> _enterprise = new ArrayList<Enterprise>();
			_enterprise = enterpriseService.createEnterprise(enterprise); 
			if (_enterprise != null) {
				return new ResponseEntity<> (_enterprise,HttpStatus.OK); 
			} else {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// update enterprise by id
	@PutMapping(Mappings.API_EnterpriseGetId)
	public ResponseEntity<Enterprise> updateEnterprise(@RequestBody(required = true) int id, Enterprise enterprise){
		try {
			Enterprise _enterprise = enterpriseService.updateEnterprise(id,enterprise); 
			if (_enterprise != null) {
				return new ResponseEntity<> (_enterprise,HttpStatus.OK);
			} else {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// delete enterprise by id
	@DeleteMapping(Mappings.API_EnterpriseGetId)
	public String detletEnterprise(@RequestBody(required = true) int id) {
		try {			
			if (enterpriseService.deleteEnterprise(id) == "Ok") {
				return "OK";
			}else {
				return "Faild";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Faild";
		}
	}
	
	
}
