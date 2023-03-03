package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Repository.EnterpriseAccountRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.Model.Service.LoginRegisterService;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

	@Autowired
	EnterpriseAccountRepository repacc;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> loginUser(String email, String password) {
		try {
			if (email != null && password != null) {
				List<User> user = userRepository.findAccountLogin(email, password);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<EnterpriseAccount> loginEnterprise(String code, String email, String password) {
		try {
			if (code != null && email != null && password != null) {
				List<EnterpriseAccount> enterpriseAccount = repacc.findAccountLogin(email, password);
				if (enterpriseAccount.get(0).getEnterprise().getEnCode().equals(code)) {
					return enterpriseAccount;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
