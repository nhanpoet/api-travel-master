package com.example.ProjectTravelMaster.Model.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int posId;
	private String posName;

	// @OneToOne(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval =
	// true)
	// private EnterpriseAccount enterprise_account;

	@OneToMany(mappedBy = "position")
	private Set<EnterpriseAccount> enterprise_account;

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

}
