package com.example.ProjectTravelMaster.Controller.ApiController;

import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.util.ViewNames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    
	@RequestMapping(ViewNames.HOME)
    public String Home() {
    	return "home_admin";
	}    
}
