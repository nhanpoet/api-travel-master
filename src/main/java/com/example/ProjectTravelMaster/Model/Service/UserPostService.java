package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.UserPost;

public interface UserPostService {

	UserPost creatUserPost(UserPost userpost) throws IOException;
	
	UserPost updateUserPost(UserPost userpost, int id) throws IOException;

	String deleteUserPost(int id) throws IOException;

	List<UserPost> getUserPost(String up_id, String up_name) throws IOException;

}
