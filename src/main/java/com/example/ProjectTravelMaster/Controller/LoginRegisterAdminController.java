package com.example.ProjectTravelMaster.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseTypeRepository;
import com.example.ProjectTravelMaster.Model.Service.LoginRegisterService;
import com.example.ProjectTravelMaster.util.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginRegisterAdminController {
	
	@Autowired
	LoginRegisterService loginRegisterService;

    @Autowired
	EnterpriseTypeRepository rep;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String Login(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise, Model model) {
        Cookie cookie = new Cookie("setEnterprise", setEnterprise);
        model.addAttribute("cookieValue", cookie);
    	return "login";
    }
	
	@RequestMapping(value="register", method = RequestMethod.GET)
    public String Register() {
    	return "register";
    }
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String showSignUpForm(@ModelAttribute(name="loginForm")LoginForm loginForm,Model model, @CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
	HttpServletResponse response, HttpServletRequest request,HttpSession session) {

        if(loginForm.getCode().equals("admin") && loginForm.getEmail().equals("hautay111@gmail.com") && loginForm.getPassword().equals("123")){
            return "home_admin";
        }else{
            List<EnterpriseAccount> _enterpriseAccount = loginRegisterService.loginEnterprise(loginForm.getCode(),loginForm.getEmail(),loginForm.getPassword());		
            if (_enterpriseAccount != null) {	
                if(_enterpriseAccount.get(0).getEnterprise().getEnterprise_type().get(0).getEtName().equals("Hotel")){
                    
                   if (_enterpriseAccount.get(0).getEnterprise().getEnId() != 0)
                    setEnterprise = String.valueOf(_enterpriseAccount.get(0).getEnterprise().getEnId());
                    
                    // create cookie and set it in response
                    Cookie cookie = new Cookie("setEnterprise", setEnterprise);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                    session.setAttribute("mySessionAttribute", _enterpriseAccount.get(0).getEcName());
                    model.addAttribute("message", "Login success. Welcome ");                 
                    return "redirect:/hotel_list";
                }if (_enterpriseAccount.get(0).getEnterprise().getEnterprise_type().get(0).getEtName().equals("Car")) {
                    if (_enterpriseAccount.get(0).getEnterprise().getEnId() != 0)
                    setEnterprise = String.valueOf(_enterpriseAccount.get(0).getEnterprise().getEnId());
                    
                    // create cookie and set it in response
                    Cookie cookie = new Cookie("setEnterprise", setEnterprise);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);

                    model.addAttribute("message", "Login success. Welcome "); 
                    return "home_enterprise_car";
                } if(_enterpriseAccount.get(0).getEnterprise().getEnterprise_type().get(0).getEtName().equals("Experiences")) {
                    if (_enterpriseAccount.get(0).getEnterprise().getEnId() != 0)
                    setEnterprise = String.valueOf(_enterpriseAccount.get(0).getEnterprise().getEnId());
                    
                    // create cookie and set it in response
                    Cookie cookie = new Cookie("setEnterprise", setEnterprise);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);

                    model.addAttribute("message", "Login success. Welcome "); 
                    return "home_enterprise_experiences";
                }else{
                  return "redirect:/login";                
                }
            } else { 
                model.addAttribute("message", "Login failed. Try again.");
                return "login";
            }            
        }

    }

    @RequestMapping(value="register_enterprise", method = RequestMethod.GET)
    public String RegisterEnterprise(Model model) {
        model.addAttribute("enterprise_types", rep.findAll());
        return "register_enterprise";
    }
				// try {		
		// 	List<EnterpriseAccount> _enterpriseAccount = loginRegisterService.loginEnterprise(loginForm.getCode(),loginForm.getEmail(),loginForm.getPassword());
		// 	if (_enterpriseAccount != null) {
		// 		Cookie cookie = new Cookie("setEnterprise_Email", _enterpriseAccount.get(0).getEcName());
		// 		model.addAttribute("Name_Enterprise", cookie);
		// 		response.addCookie(cookie);
        // 		return "home_admin";   		
		// 	}
		// 	else {
		// 		model.addAttribute("loginError", "Wrong user or password!");
		// 		return "login";
		// 	}
		// } catch (Exception e) {
		// 	model.addAttribute("loginError", "Wrong user or password!");
		// 	return "login";
		// }
                        // //get all cookies
                // Cookie[] cookies = request.getCookies();
                // //iterate each cookie
                // for (Cookie ck : cookies) {
                //     //display only the cookie with the name 'setEnterprise'
                //     if (ck.getName().equals("setEnterprise")) {
                //         model.addAttribute("cookieValue", ck);
                //         break;
                //     } else {
                //         ck.setValue("");
                //         model.addAttribute("cookieValue", ck);
                //         break;
                //     }
                // }

    
	
}
