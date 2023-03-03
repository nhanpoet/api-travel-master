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
@Table(name = "enterprise_post_image")
public class EnterprisePostImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int epiId;
	private String epiName;
	private String epiUrl;
	private int epId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="epId", referencedColumnName = "epId", insertable = false, updatable = false)    
    @JsonBackReference
    private EnterprisePost enterprise_post;
	
	public int getEpiId() {
		return epiId;
	}
	public void setEpiId(int epiId) {
		this.epiId = epiId;
	}
	public String getEpiName() {
		return epiName;
	}
	public void setEpiName(String epiName) {
		this.epiName = epiName;
	}
	public String getEpiUrl() {
		return epiUrl;
	}
	public void setEpiUrl(String epiUrl) {
		this.epiUrl = epiUrl;
	}
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	
	
}
