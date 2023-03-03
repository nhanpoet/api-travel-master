package com.example.ProjectTravelMaster.Model.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_post")
public class UserPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int upId;	
	private String upName;
	
	private String upDetail;
	
	private String upReport;
	
	private int userId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="userId", referencedColumnName = "userId", insertable = false, updatable = false)    
    @JsonBackReference
    private User user;
	
	@OneToMany(mappedBy="user_post", cascade=CascadeType.ALL)
	private List<UserPostComment> user_post_comment;
	
	@OneToMany(mappedBy="user_post", cascade=CascadeType.ALL)
	private List<UserPostImage> user_post_image;
	
	public int getUp_id() {
		return upId;
	}

	public void setUp_id(int up_id) {
		this.upId = up_id;
	}

	public String getUp_name() {
		return upName;
	}

	public void setUp_name(String up_name) {
		this.upName = up_name;
	}

	public String getUp_detail() {
		return upDetail;
	}

	public void setUp_detail(String up_detail) {
		this.upDetail = up_detail;
	}

	public String getUp_report() {
		return upReport;
	}

	public void setUp_report(String up_report) {
		this.upReport = up_report;
	}
	

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public List<UserPostImage> getUser_post_image() {
		return user_post_image;
	}
	
	public void setUser_post_image(List<UserPostImage> user_post_image) {
		this.user_post_image = user_post_image;
	}

	public List<UserPostComment> getUser_post_comment() {
		return user_post_comment;
	}

	public void setUser_post_comment(List<UserPostComment> user_post_comment) {
		this.user_post_comment = user_post_comment;
	}
	
	
}
