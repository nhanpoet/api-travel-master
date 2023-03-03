package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.EnterpriseAccount;
import com.example.ProjectTravelMaster.Model.Entity.EnterprisePost;
import com.example.ProjectTravelMaster.Model.Entity.Other.Post;

public interface EnterprisePostService{

	List<EnterprisePost> getAllEnterprisePost()throws IOException;

	List<EnterprisePost> getEnterprisePostby(String ep_name, String en_id) throws IOException;

	EnterprisePost createEnterprisePost(EnterprisePost enterprisePost)throws IOException;

	EnterprisePost updateEnterprisePost(int id, EnterprisePost enterprisePost) throws IOException;

	String deleteEnterprisePost(int id) throws IOException;

	List<Post> GetPostEnterprise(List<EnterprisePost> enterprisePost,List<EnterpriseAccount> enterpriseAccount) throws IOException;
	String UploadFileImagePost(MultipartFile file, HttpSession session) throws IOException;
}
