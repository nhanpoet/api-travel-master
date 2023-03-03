package com.example.ProjectTravelMaster.Model.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_post_image")
public class UserPostImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int upiId;
	private String upiName;
	private String upiUrl;
	private int upId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="upId", referencedColumnName = "upId", insertable = false, updatable = false)    
    @JsonBackReference
    private UserPost user_post;
			
	public int getUpiId() {
		return upiId;
	}
	public void setUpiId(int upiId) {
		this.upiId = upiId;
	}
	public String getUpiName() {
		return upiName;
	}
	public void setUpiName(String upiName) {
		this.upiName = upiName;
	}
	public String getUpiUrl() {
		return upiUrl;
	}
	public void setUpiUrl(String upiUrl) {
		this.upiUrl = upiUrl;
	}
	public int getUpId() {
		return upId;
	}
	public void setUpId(int upId) {
		this.upId = upId;
	}
	
	public UserPost getUser_post() {
		return user_post;
	}
	public void setUser_post(UserPost user_post) {
		this.user_post = user_post;
	}	
}
