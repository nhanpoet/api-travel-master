package com.example.ProjectTravelMaster.Model.Entity;

import java.util.Date;
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
@Table(name = "enterprise_post")
public class EnterprisePost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int epId;
	
	private String epName;
	private String epDetail;
	private String epDescription;
	private Date epTime;
	private int epLike;
	private int enId;
	private int ecId;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="enId", referencedColumnName = "enId", insertable = false, updatable = false)    
    @JsonBackReference
    private Enterprise enterprise;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="ecId", referencedColumnName = "ecId", insertable = false, updatable = false)    
    @JsonBackReference
    private EnterpriseAccount enterprise_account;
	
	public EnterpriseAccount getEnterprise_account() {
		return enterprise_account;
	}
	public void setEnterprise_account(EnterpriseAccount enterprise_account) {
		this.enterprise_account = enterprise_account;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	@OneToMany(mappedBy="enterprise_post", cascade=CascadeType.ALL)
	private List<EnterprisePostComment> enterprise_post_comment;
	
	@OneToMany(mappedBy="enterprise_post", cascade=CascadeType.ALL)
	private List<EnterprisePostImage> enterprise_post_image;
		
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public String getEpDetail() {
		return epDetail;
	}
	public void setEpDetail(String epDetail) {
		this.epDetail = epDetail;
	}
	public String getEpDescription() {
		return epDescription;
	}
	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}
	
	public int getEnId() {
		return enId;
	}
	public void setEnId(int enId) {
		this.enId = enId;
	}
	public int getEcId() {
		return ecId;
	}
	public void setEcId(int ecId) {
		this.ecId = ecId;
	}
	public List<EnterprisePostImage> getEnterprise_post_image() {
		return enterprise_post_image;
	}
	public void setEnterprise_post_image(List<EnterprisePostImage> enterprise_post_image) {
		this.enterprise_post_image = enterprise_post_image;
	}
	public List<EnterprisePostComment> getEnterprise_post_comment() {
		return enterprise_post_comment;
	}
	public void setEnterprise_post_comment(List<EnterprisePostComment> enterprise_post_comment) {
		this.enterprise_post_comment = enterprise_post_comment;
	}
	public Date getEpTime() {
		return epTime;
	}
	public void setEpTime(Date epTime) {
		this.epTime = epTime;
	}
	public int getEpLike() {
		return epLike;
	}
	public void setEpLike(int epLike) {
		this.epLike = epLike;
	}
	
	
	
}
