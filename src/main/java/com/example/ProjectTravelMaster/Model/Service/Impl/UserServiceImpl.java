package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.Other.UpdateProfileUser;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.Model.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository urep;

	// get user
	@Override
	public List<User> getAllUser(String user_id, String user_name) throws IOException {
		try {
			List<User> user = new ArrayList<User>();

			if (user_id != null && user_name == null) {
				int iduser = Integer.valueOf(user_id);
				urep.findByUserId(iduser).forEach(user::add);
			}
			if (user_name != null && user_id == null) {
				urep.findByUserName(user_name).forEach(user::add);
			}
			if (user_name == null && user_id == null) {
				urep.findAll().forEach(user::add);
			}
			if (user.isEmpty()) {
				return null;
			}
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public User createUser(User emp) throws IOException {
		try {
			if (emp == null) {
				return null;
			} else {
				User _emp = urep.save(emp);
				return _emp;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public User updateUser(int id, UpdateProfileUser emp) throws IOException {
		try {
			if (emp == null || id == 0) {
				return null;
			} else {
				Optional<User> empdata = urep.findById(id);
				User _emp = empdata.get();
				if(emp.getUserName() != null){
					_emp.setUserName(emp.getUserName());				
				}if (emp.getUserEmail() != null) {
					_emp.setUserEmail(emp.getUserEmail());				
				}if (emp.getUserPhone() != null) {
					_emp.setUserPhone(emp.getUserPhone());				
				}if (emp.getUserAvatar() != null) {
					_emp.setUserAvatar(emp.getUserAvatar());
				}if (emp.getUserUsername() != null) {
					_emp.setUserUsername(emp.getUserUsername());
				}if (emp.getUserPassword() != null) {
				_emp.setUserPassword(emp.getUserPassword());					
				}
				return urep.save(_emp);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public String deleteUser(int id) throws IOException {
		try {
			if (id == 0) {
				return null;
			} else {
				urep.deleteById(id);
				return "OK";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
