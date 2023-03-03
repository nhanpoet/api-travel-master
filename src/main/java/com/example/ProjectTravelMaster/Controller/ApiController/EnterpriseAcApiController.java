package com.example.ProjectTravelMaster.Controller.ApiController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseAccountRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EnterpriseAcApiController {

    @Autowired
    private EnterpriseAccountRepository enterpriseAccountRepository;

    @GetMapping("/enac")
    public List<EnterpriseAccount> getAllHotel() {
        return enterpriseAccountRepository.findAll();
    }

    @GetMapping("enac/{id}")
    public Optional<EnterpriseAccount> GetHotelById(@PathVariable Integer id) {

        return enterpriseAccountRepository.findById(id);
    }
}