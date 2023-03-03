package com.example.ProjectTravelMaster.Model.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userUsername;
	private String userPassword;
	private String userAvatar;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<UserPost> user_post;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Booking> booking;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<MessageChannel> messagechannel;
	

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<EnterprisePostComment> enterprise_post_comment;

	public List<Booking> getBooking() {
		return booking;
	}



	public List<MessageChannel> getMessagechannel() {
		return messagechannel;
	}



	public void setMessagechannel(List<MessageChannel> messagechannel) {
		this.messagechannel = messagechannel;
	}



	public void setBooking(List<Booking> booking) {
		this.booking = booking;
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

	public List<UserPost> getUser_post() {
		return user_post;
	}

	public void setUser_post(List<UserPost> user_post) {
		this.user_post = user_post;
	}

	
	
	
	
}
