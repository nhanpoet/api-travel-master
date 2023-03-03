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
@Table(name = "enterprise_type")
public class EnterpriseType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int etId;
	private String etName;
	private int enId;

	// @OneToMany(mappedBy = "enterprise_type",cascade = CascadeType.ALL,
	// orphanRemoval = true)
	// private List<Enterprise> enterprise;

	// public List<Enterprise> getEnterprise() {
	// return enterprise;
	// }

	// public void setEnterprise(List<Enterprise> enterprise) {
	// this.enterprise = enterprise;
	// }

	public int getEnId() {
		return enId;
	}

	public void setEnId(int enId) {
		this.enId = enId;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "enId", referencedColumnName = "enId", insertable = false, updatable = false)
	@JsonBackReference
	private Enterprise enterprise;

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public int getEtId() {
		return etId;
	}

	public void setEtId(int etId) {
		this.etId = etId;
	}

	public String getEtName() {
		return etName;
	}

	public void setEtName(String etName) {
		this.etName = etName;
	}

}
