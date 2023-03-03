package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.UserPostComment;
import com.example.ProjectTravelMaster.Model.Repository.UserPostCommentRepository;
import com.example.ProjectTravelMaster.Model.Service.UserPostCommentService;

@Service
public class UserPostCommentServiceImpl implements UserPostCommentService {

	@Autowired
	UserPostCommentRepository rep;

	@Override
	public List<UserPostComment> GetAllUserPostCommentByIdPost(int up_id) {
		try {
			if (up_id > 0) {
				List<UserPostComment> userPostComments = rep.findByUpId(up_id);
				return userPostComments;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public UserPostComment createUserPostComment(UserPostComment userpostcomment) {
		try {
			if (userpostcomment != null) {
				UserPostComment _userpostcomment = rep.save(userpostcomment);
				return _userpostcomment;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public UserPostComment updatteUserPostCommnet(int id, UserPostComment userpostcommnet) {

		try {
			Optional<UserPostComment> data = rep.findById(id);
			UserPostComment _userpostcomment = data.get();
			_userpostcomment.setUpcDetail(userpostcommnet.getUpcDetail());
			_userpostcomment.setUpcReport(userpostcommnet.getUpcReport());
			_userpostcomment.setUpId(userpostcommnet.getUpId());
			_userpostcomment.setUserId(userpostcommnet.getUserId());

			return rep.save(_userpostcomment);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public String deleteUserPostComment(int id) {
		try {
			rep.deleteById(id);
			return "OK";

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
