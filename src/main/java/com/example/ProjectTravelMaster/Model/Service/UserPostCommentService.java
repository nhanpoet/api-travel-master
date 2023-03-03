package com.example.ProjectTravelMaster.Model.Service;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.UserPostComment;

public interface UserPostCommentService {

	List<UserPostComment> GetAllUserPostCommentByIdPost(int up_id);

	UserPostComment createUserPostComment(UserPostComment userpostcomment);

	UserPostComment updatteUserPostCommnet(int id, UserPostComment userpostcommnet);

	String deleteUserPostComment(int id);

}
