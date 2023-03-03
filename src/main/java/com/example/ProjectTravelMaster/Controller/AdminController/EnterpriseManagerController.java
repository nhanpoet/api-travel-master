package com.example.ProjectTravelMaster.Controller.AdminController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.EnterpriseType;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseTypeRepository;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;

@Controller
public class EnterpriseManagerController {
    
	@Autowired
	EnterpriseService enterpriseService;

    @Autowired
	EnterpriseTypeRepository repEnterpriseType;

    @RequestMapping(value = "/enterprise_list",method = RequestMethod.GET)
    public String EnterpriseList_view(Model model){
        List<Enterprise> enterprises =enterpriseService.getAllEnterprise();
        if (enterprises != null) {
            model.addAttribute("dataEnterprise", enterprises);
        }else {
            model.addAttribute("dataEnterprise", null);
        }   
        return "enterprise_list";
    }

    @RequestMapping(value = "/enterprise_add",method = RequestMethod.GET)
    public String EnterpriseAdd_view(Model model){
        model.addAttribute("enterprise_types", repEnterpriseType.findAll());
        Enterprise enterprise = new Enterprise();
        model.addAttribute("dataEnterprise", enterprise);
        return "enterprise_add";
    }

    @RequestMapping(value = "/enterprise_create",method = RequestMethod.POST)
    public String EnterpriseCreate(@ModelAttribute(name="Enterprise")Enterprise enterprise,Model model){
        List<Enterprise> enterprise_create =enterpriseService.createEnterprise(enterprise);
        if (enterprise_create != null) {
            List<Enterprise> enterprises =enterpriseService.getAllEnterprise();
            model.addAttribute("dataEnterprise", enterprises);
        }else {
            model.addAttribute("dataEnterprise", null);
        }  
        return "redirect:/enterprise_list";
    }



    @RequestMapping(value = "/enterprise_edit",method = RequestMethod.POST)
    public String EnterpriseEdit_view(@ModelAttribute(name="Enterprise")Enterprise enterprise,Model model){
        String id_enterprise = String.valueOf(enterprise.getEnId());
        Enterprise enterprise_detail =enterpriseService.getEnterpriseById(id_enterprise);

        if (enterprise_detail != null) {
            EnterpriseType enterpriseType = enterprise_detail.getEnterprise_type().get(0);
            model.addAttribute("dataEnterpriseDetail", enterprise_detail);
            model.addAttribute("enterprise_types", repEnterpriseType.findAll());
            model.addAttribute("entertype", enterpriseType);
        }else{
            return "redirect:/enterprise_list";
        }
        return "enterprise_edit";
    }

    @RequestMapping(value = "/enterprise_update",method = RequestMethod.POST)
    public String EnterpriseEdit(@ModelAttribute(name="Enterprise")Enterprise enterprise,Model model,String etId){
        Enterprise _enterprise =enterpriseService.updateEnterprise(enterprise.getEnId(),enterprise);
        
        if (_enterprise != null) { 
            int id = _enterprise.getEnterprise_type().get(0).getEtId();
            
            List<Enterprise> enterprises =enterpriseService.getAllEnterprise();
            model.addAttribute("dataEnterpriseDetail", enterprises);
            return "redirect:/enterprise_list";
        }else {
            String id_enterprise = String.valueOf(enterprise.getEnId());
            Enterprise enterprise_detail =enterpriseService.getEnterpriseById(id_enterprise);
            model.addAttribute("enterprise_types", repEnterpriseType.findAll());
            model.addAttribute("dataEnterpriseDetail", enterprise_detail);
            return "enterprise_edit";
        }   
    }
    // @RequestMapping(value = "/enterprise_delete",method = RequestMethod.POST)
    // public String EnterpriseDelete(@ModelAttribute(name="Enterprise")Enterprise enterprise,Model model){
    //     String id = String.valueOf(enterprise.getEnId());
    //     if (id != null) { 
    //         enterpriseService.deleteEnterprise(enterprise.getEnId());
    //         return "redirect:/enterprise_list";
    //     }else {
    //         return "enterprise_edit";
    //     }   
    // }

}
