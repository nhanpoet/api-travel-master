package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.UserPost;
import com.example.ProjectTravelMaster.Model.Repository.UserPostRepository;
import com.example.ProjectTravelMaster.Model.Service.UserPostService;

@Service
public class UserPostServiceImpl implements UserPostService {

	@Autowired
	UserPostRepository uprep;

	// search & get post user

	@Override
	public List<UserPost> getUserPost(String up_id, String up_name) throws IOException {

		List<UserPost> user_post = new ArrayList<UserPost>();
		if (up_id != null && up_name == null) {
			int idpost = Integer.valueOf(up_id);
			uprep.findByUpId(idpost).forEach(user_post::add);
		}
		if (up_name != null && up_id == null) {
			uprep.findByUpName(up_name).forEach(user_post::add);
		}
		if (up_name == null && up_id == null) {
			uprep.findAllPost().forEach(user_post::add);
		}
		if (user_post.isEmpty()) {
			return null;
		}
		return user_post;
	}

	// add post user
	@Override
	public UserPost creatUserPost(UserPost userpost) throws IOException {
		UserPost _userpost = uprep.save(userpost);
		return _userpost;
	}

	// update post user
	@Override
	public UserPost updateUserPost(UserPost userpost, int id) throws IOException {
		try {
			Optional<UserPost> postuserdata = uprep.findById(id);
			UserPost _userpost = postuserdata.get();
			_userpost.setUp_name(userpost.getUp_name());
			_userpost.setUp_detail(userpost.getUp_detail());
			_userpost.setUp_report(userpost.getUp_report());
			_userpost.setUser_id(userpost.getUser_id());
			return uprep.save(_userpost);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	// delete
	@Override
	public String deleteUserPost(int id) throws IOException {
		try {
			if (id > 0) {
				uprep.deleteById(id);
				return "OK";
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
