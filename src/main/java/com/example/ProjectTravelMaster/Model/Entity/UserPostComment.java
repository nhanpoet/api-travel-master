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
@Table(name = "user_post_comment")
public class UserPostComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int upcId;	
	private String upcDetail;
	private String upcReport;	
	private int userId;	
	private int upId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="upId", referencedColumnName = "upId", insertable = false, updatable = false)    
    @JsonBackReference
    private UserPost user_post;
	
	public int getUpcId() {
		return upcId;
	}

	public void setUpcId(int upcId) {
		this.upcId = upcId;
	}

	public String getUpcDetail() {
		return upcDetail;
	}

	public void setUpcDetail(String upcDetail) {
		this.upcDetail = upcDetail;
	}

	public String getUpcReport() {
		return upcReport;
	}

	public void setUpcReport(String upcReport) {
		this.upcReport = upcReport;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
