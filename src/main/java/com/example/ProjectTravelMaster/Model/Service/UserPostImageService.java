package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.UserPostImage;

public interface UserPostImageService {
    UserPostImage uploadImage(MultipartFile file, int up_id, HttpSession session) throws IOException;

}