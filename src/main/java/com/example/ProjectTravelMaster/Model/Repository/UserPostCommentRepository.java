package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.UserPostComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostCommentRepository extends JpaRepository<UserPostComment, Integer>{
	List<UserPostComment> findByUpId(int up_id);
}
