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
@Table(name = "order_experiences")
public class OrderExperiences {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oeId;	
    private int oeQuantity;
	private double oeTotalprice;
	private String oeCode;
	private Date oeTimecheckin;
	private Date oeTimecheckout;		
	private Boolean oeStatus;	
	private int boId;
	private int exId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="boId", referencedColumnName = "boId", insertable = false, updatable = false)    
    @JsonBackReference
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="exId", referencedColumnName = "exId", insertable = false, updatable = false)    
    @JsonBackReference
    private Experiences experiences;
  
    public int getOeId() {
        return oeId;
    }
    public void setOeId(int oeId) {
        this.oeId = oeId;
    }
    public int getOeQuantity() {
        return oeQuantity;
    }
    public void setOeQuantity(int oeQuantity) {
        this.oeQuantity = oeQuantity;
    }
    public double getOeTotalprice() {
        return oeTotalprice;
    }
    public void setOeTotalprice(double oeTotalprice) {
        this.oeTotalprice = oeTotalprice;
    }
    public String getOeCode() {
        return oeCode;
    }
    public void setOeCode(String oeCode) {
        this.oeCode = oeCode;
    }
    
    public Date getOeTimecheckin() {
        return oeTimecheckin;
    }
    public void setOeTimecheckin(Date oeTimecheckin) {
        this.oeTimecheckin = oeTimecheckin;
    }
    public Date getOeTimecheckout() {
        return oeTimecheckout;
    }
    public void setOeTimecheckout(Date oeTimecheckout) {
        this.oeTimecheckout = oeTimecheckout;
    }
    public Boolean getOeStatus() {
        return oeStatus;
    }
    public void setOeStatus(Boolean oeStatus) {
        this.oeStatus = oeStatus;
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
    public int getExId() {
        return exId;
    }
    public void setExId(int exId) {
        this.exId = exId;
    }	







}
