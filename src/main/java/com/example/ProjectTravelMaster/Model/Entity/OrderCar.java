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
@Table(name = "order_car")
public class OrderCar {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ocId;	
    private int ocQuantity;
	private double ocTotalprice;
	private String ocCode;
	private Date ocTimecheckin;
	private Date ocTimecheckout;		
	private Boolean ocStatus;	
	private int boId;
	private int carId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boId", referencedColumnName = "boId", insertable = false, updatable = false)    
    @JsonBackReference
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="carId", referencedColumnName = "carId", insertable = false, updatable = false)    
    @JsonBackReference
    private Cars cars;

    public int getOcId() {
        return ocId;
    }
    public void setOcId(int ocId) {
        this.ocId = ocId;
    }
    public int getOcQuantity() {
        return ocQuantity;
    }
    public void setOcQuantity(int ocQuantity) {
        this.ocQuantity = ocQuantity;
    }
    public double getOcTotalprice() {
        return ocTotalprice;
    }
    public void setOcTotalprice(double ocTotalprice) {
        this.ocTotalprice = ocTotalprice;
    }
    public String getOcCode() {
        return ocCode;
    }
    public void setOcCode(String ocCode) {
        this.ocCode = ocCode;
    }
    public Date getOcTimecheckin() {
        return ocTimecheckin;
    }
    public void setOcTimecheckin(Date ocTimecheckin) {
        this.ocTimecheckin = ocTimecheckin;
    }
    public Date getOcTimecheckout() {
        return ocTimecheckout;
    }
    public void setOcTimecheckout(Date ocTimecheckout) {
        this.ocTimecheckout = ocTimecheckout;
    }
    public Boolean getOcStatus() {
        return ocStatus;
    }
    public void setOcStatus(Boolean ocStatus) {
        this.ocStatus = ocStatus;
    }
    
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public int getBoId() {
        return boId;
    }
    public void setBoId(int boId) {
        this.boId = boId;
    }
    public int getCarId() {
        return carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }	







}
