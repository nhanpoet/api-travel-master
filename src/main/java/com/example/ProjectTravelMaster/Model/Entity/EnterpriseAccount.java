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
@Table(name = "enterprise_account")
public class EnterpriseAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ecId;
	private String ecName;
	private String ecEmail;
	private String ecPhone;
	private String ecPassword;
	private String ecAvatar;
	private String ecAddress;
	private int enId;
	private int posId;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "posId", referencedColumnName = "posId",insertable =
	// false, updatable = false)
	// private Position position;

	@OneToMany(mappedBy="enterprise_account", cascade=CascadeType.ALL)
	private List<EnterprisePost> enterprise_post;

	public List<EnterprisePost> getEnterprise_post() {
		return enterprise_post;
	}

	public void setEnterprise_post(List<EnterprisePost> enterprise_post) {
		this.enterprise_post = enterprise_post;
	}

	@ManyToOne
	@JoinColumn(name = "posId", referencedColumnName = "posId", insertable = false, updatable = false)
	@JsonBackReference
	private Position position;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "enId", referencedColumnName = "enId", insertable = false, updatable = false)
	@JsonBackReference
	private Enterprise enterprise;



	public EnterpriseAccount() {
	}

	public int getEcId() {
		return ecId;
	}

	public void setEcId(int ecId) {
		this.ecId = ecId;
	}

	public String getEcName() {
		return ecName;
	}

	public void setEcName(String ecName) {
		this.ecName = ecName;
	}

	public String getEcEmail() {
		return ecEmail;
	}

	public void setEcEmail(String ecEmail) {
		this.ecEmail = ecEmail;
	}

	public String getEcPhone() {
		return ecPhone;
	}

	public void setEcPhone(String ecPhone) {
		this.ecPhone = ecPhone;
	}

	public String getEcPassword() {
		return ecPassword;
	}

	public void setEcPassword(String ecPassword) {
		this.ecPassword = ecPassword;
	}

	public String getEcAvatar() {
		return ecAvatar;
	}

	public void setEcAvatar(String ecAvatar) {
		this.ecAvatar = ecAvatar;
	}

	public String getEcAddress() {
		return ecAddress;
	}

	public void setEcAddress(String ecAddress) {
		this.ecAddress = ecAddress;
	}

	public int getEnId() {
		return enId;
	}

	public void setEnId(int enId) {
		this.enId = enId;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

}
