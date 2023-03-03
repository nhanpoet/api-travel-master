package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer>{

	 List<User> findByUserId(int user_id);
	 List<User> findByUserName(String user_name);

	 @Query("SELECT u FROM User u WHERE u.userEmail = ?1 and u.userPassword = ?2")
	 List<User> findAccountLogin(String user_email,String user_password);
	 
}
