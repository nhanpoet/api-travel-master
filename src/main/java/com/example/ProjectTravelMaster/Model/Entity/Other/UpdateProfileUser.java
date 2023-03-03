package com.example.ProjectTravelMaster.Model.Entity.Other;


public class UpdateProfileUser {
    private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userUsername;
	private String userPassword;
	private String userAvatar;


    public UpdateProfileUser(int userId, String userName, String userEmail, String userPhone, String userUsername,
            String userPassword, String userAvatar) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userAvatar = userAvatar;
    }
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserUsername() {
        return userUsername;
    }
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserAvatar() {
        return userAvatar;
    }
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }


    
}
