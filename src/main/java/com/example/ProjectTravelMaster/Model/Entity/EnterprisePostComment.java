package com.example.ProjectTravelMaster.Model.Entity;

import java.util.Date;

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
@Table(name="enterprise_post_comment")
public class EnterprisePostComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int epcId;	
	private String epc_detail;
	private String epc_report; 
	private Date epc_time;
	private int epc_parentid;
	private int userId;
	private int epId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="epId", referencedColumnName = "epId", insertable = false, updatable = false)    
    @JsonBackReference
    private EnterprisePost enterprise_post;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="userId", referencedColumnName = "userId", insertable = false, updatable = false)    
    @JsonBackReference
    private User user;
	
	
	public EnterprisePost getEnterprise_post() {
		return enterprise_post;
	}
	public void setEnterprise_post(EnterprisePost enterprise_post) {
		this.enterprise_post = enterprise_post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getEpc_detail() {
		return epc_detail;
	}
	public void setEpc_detail(String epc_detail) {
		this.epc_detail = epc_detail;
	}
	public String getEpc_report() {
		return epc_report;
	}
	public void setEpc_report(String epc_report) {
		this.epc_report = epc_report;
	}
	public Date getEpc_time() {
		return epc_time;
	}
	public void setEpc_time(Date epc_time) {
		this.epc_time = epc_time;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public int getEpc_parentid() {
		return epc_parentid;
	}
	public void setEpc_parentid(int epc_parentid) {
		this.epc_parentid = epc_parentid;
	}

	
}
