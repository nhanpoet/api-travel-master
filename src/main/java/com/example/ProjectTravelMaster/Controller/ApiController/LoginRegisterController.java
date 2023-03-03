package com.example.ProjectTravelMaster.Controller.ApiController;


import java.util.List;
import java.util.Optional;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.Other.LoginRegister;
import com.example.ProjectTravelMaster.Model.Service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginRegisterController {

	
	@Autowired
	LoginRegisterService loginRegisterService;



	@PostMapping("/login_user")
	public ResponseEntity<List<User>> loginUser(@RequestParam String userEmail,String userPassword) {	
		try {		
			List<User> user = loginRegisterService.loginUser(userEmail, userPassword);
			if (user != null) {
        		return new ResponseEntity<> (user,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<> (null,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/login")
	public ResponseEntity<List<EnterpriseAccount>> loginEnterprise(@RequestParam String enCode , String ecEmail,String ecPassword) {	
		try {		
			List<EnterpriseAccount> _enterpriseAccount = loginRegisterService.loginEnterprise(enCode,ecEmail,ecPassword);
			if (_enterpriseAccount != null) {
        		return new ResponseEntity<> (_enterpriseAccount,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<> (null,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	
}
