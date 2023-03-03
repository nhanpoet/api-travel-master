package com.example.ProjectTravelMaster.Model.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enterprise")
public class Enterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enId;
	private String enNamecompany;
	private String enDetail;
	private String enCode;
	private String enEmail;
	private String enPhone;
	private String enAddress;
	private String enWard;
	private String enDistrict;
	private String enProvince;
	private String enCountry;
	private String enPostalcode;
	private Boolean enStatus;
	// private int etId;

	// @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	// @JoinColumn(name = "etId", referencedColumnName = "etId",insertable = false,
	// updatable = false)
	// private EnterpriseType enterprise_type;

	// @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	// @JoinColumn(name="etId", nullable=false, insertable=false, updatable=false)
	// private List<EnterpriseType> enterprise_type;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<EnterprisePost> enterprise_post;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<EnterpriseType> enterprise_type;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EnterpriseAccount> enterprise_account;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<Hotel> hotel;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<Cars> cars;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<Experiences> experiences;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Booking> booking;

	@OneToMany(mappedBy="enterprise", cascade=CascadeType.ALL)
	private List<MessageChannel> messagechannel;

	

	public List<MessageChannel> getMessagechannel() {
		return messagechannel;
	}

	public void setMessagechannel(List<MessageChannel> messagechannel) {
		this.messagechannel = messagechannel;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}

	public int getEnId() {
		return enId;
	}

	public void setEnId(int enId) {
		this.enId = enId;
	}

	public String getEnNamecompany() {
		return enNamecompany;
	}

	public void setEnNamecompany(String enNamecompany) {
		this.enNamecompany = enNamecompany;
	}

	public String getEnDetail() {
		return enDetail;
	}

	public void setEnDetail(String enDetail) {
		this.enDetail = enDetail;
	}

	public String getEnCode() {
		return enCode;
	}

	public void setEnCode(String enCode) {
		this.enCode = enCode;
	}

	public String getEnEmail() {
		return enEmail;
	}

	public void setEnEmail(String enEmail) {
		this.enEmail = enEmail;
	}

	public String getEnPhone() {
		return enPhone;
	}

	public void setEnPhone(String enPhone) {
		this.enPhone = enPhone;
	}

	public String getEnAddress() {
		return enAddress;
	}

	public void setEnAddress(String enAddress) {
		this.enAddress = enAddress;
	}

	public String getEnWard() {
		return enWard;
	}

	public void setEnWard(String enWard) {
		this.enWard = enWard;
	}

	public String getEnDistrict() {
		return enDistrict;
	}

	public void setEnDistrict(String enDistrict) {
		this.enDistrict = enDistrict;
	}

	public String getEnProvince() {
		return enProvince;
	}

	public void setEnProvince(String enProvince) {
		this.enProvince = enProvince;
	}

	public String getEnCountry() {
		return enCountry;
	}

	public void setEnCountry(String enCountry) {
		this.enCountry = enCountry;
	}

	public String getEnPostalcode() {
		return enPostalcode;
	}

	public void setEnPostalcode(String enPostalcode) {
		this.enPostalcode = enPostalcode;
	}

	public Boolean getEnStatus() {
		return enStatus;
	}

	public void setEnStatus(Boolean enStatus) {
		this.enStatus = enStatus;
	}

	public List<EnterpriseType> getEnterprise_type() {
		return enterprise_type;
	}

	public void setEnterprise_type(List<EnterpriseType> enterprise_type) {
		this.enterprise_type = enterprise_type;
	}

	public List<EnterpriseAccount> getEnterprise_account() {
		return enterprise_account;
	}

	public void setEnterprise_account(List<EnterpriseAccount> enterprise_account) {
		this.enterprise_account = enterprise_account;
	}

	public List<EnterprisePost> getEnterprise_post() {
		return enterprise_post;
	}

	public void setEnterprise_post(List<EnterprisePost> enterprise_post) {
		this.enterprise_post = enterprise_post;
	}

	// public int getEtId() {
	// return etId;
	// }
	// public void setEtId(int etId) {
	// this.etId = etId;
	// }
	public List<Cars> getCars() {
		return cars;
	}

	public void setCars(List<Cars> cars) {
		this.cars = cars;
	}

}
