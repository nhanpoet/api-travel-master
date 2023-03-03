package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.UserPostImage;
import com.example.ProjectTravelMaster.Model.Repository.UserPostImageRepository;
import com.example.ProjectTravelMaster.Model.Service.UserPostImageService;

@Service
public class UserPostImageServiceImpl implements UserPostImageService {

	@Autowired
	private UserPostImageRepository UpiRepository;

	@Override
	public UserPostImage uploadImage(MultipartFile file, int up_id, HttpSession session) throws IOException {
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();

		try {
			file.transferTo(Path.of(path + "/" + "upload/image_post_user/" + fileName));
			UserPostImage image = new UserPostImage();
			image.setUpiName(fileName);
			image.setUpiUrl(fileName);
			image.setUpId(up_id);
			return UpiRepository.save(image);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
