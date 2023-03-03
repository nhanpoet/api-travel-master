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
@Table(name = "booking")
public class Booking {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boId;	
	private String boName;
	private String boPhone;
	private double boTotalprice;
	private Boolean boStatus;	
	private int enId;
	private int userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="enId", referencedColumnName = "enId", insertable = false, updatable = false)    
    @JsonBackReference
    private Enterprise enterprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="userId", referencedColumnName = "userId", insertable = false, updatable = false)    
    @JsonBackReference
    private User user;

    public Enterprise getEnterprise() {
        return enterprise;
    }
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
	private List<OrderHotel> order_hotel;

    @OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
	private List<OrderCar> order_car;

    @OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
	private List<OrderExperiences> order_experiences;

    public List<OrderExperiences> getOrder_experiences() {
        return order_experiences;
    }
    public void setOrder_experiences(List<OrderExperiences> order_experiences) {
        this.order_experiences = order_experiences;
    }
    public List<OrderCar> getOrder_car() {
        return order_car;
    }
    public void setOrder_car(List<OrderCar> order_car) {
        this.order_car = order_car;
    }
    public List<OrderHotel> getOrder_hotel() {
        return order_hotel;
    }
    public void setOrder_hotel(List<OrderHotel> order_hotel) {
        this.order_hotel = order_hotel;
    }
    public int getBoId() {
        return boId;
    }
    public void setBoId(int boId) {
        this.boId = boId;
    }
    public String getBoName() {
        return boName;
    }
    public void setBoName(String boName) {
        this.boName = boName;
    }
    
    public String getBoPhone() {
        return boPhone;
    }
    public void setBoPhone(String boPhone) {
        this.boPhone = boPhone;
    }
    public double getBoTotalprice() {
        return boTotalprice;
    }
    public void setBoTotalprice(double boTotalprice) {
        this.boTotalprice = boTotalprice;
    }
    public Boolean getBoStatus() {
        return boStatus;
    }
    public void setBoStatus(Boolean boStatus) {
        this.boStatus = boStatus;
    }
    public int getEnId() {
        return enId;
    }
    public void setEnId(int enId) {
        this.enId = enId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    







}
