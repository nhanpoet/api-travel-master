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
@Table(name = "experiences")
public class Experiences {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int exId;
	private String exName;
	private String exDetail;
	private String exDescription;
	private String exType;
	private double exPrice;
	private int enId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="enId", referencedColumnName = "enId", insertable = false, updatable = false)    
    @JsonBackReference
    private Enterprise enterprise;

    @OneToMany(mappedBy="experiences", cascade=CascadeType.ALL)
	private List<OrderExperiences> order_experiences;

    public List<OrderExperiences> getOrder_experiences() {
        return order_experiences;
    }
    public void setOrder_experiences(List<OrderExperiences> order_experiences) {
        this.order_experiences = order_experiences;
    }
    public int getExId() {
        return exId;
    }
    public void setExId(int exId) {
        this.exId = exId;
    }
    public String getExName() {
        return exName;
    }
    public void setExName(String exName) {
        this.exName = exName;
    }
    public String getExDetail() {
        return exDetail;
    }
    public void setExDetail(String exDetail) {
        this.exDetail = exDetail;
    }
    public String getExDescription() {
        return exDescription;
    }
    public void setExDescription(String exDescription) {
        this.exDescription = exDescription;
    }
    public String getExType() {
        return exType;
    }
    public void setExType(String exType) {
        this.exType = exType;
    }
    public double getExPrice() {
        return exPrice;
    }
    public void setExPrice(double exPrice) {
        this.exPrice = exPrice;
    }
    public int getEnId() {
        return enId;
    }
    public void setEnId(int enId) {
        this.enId = enId;
    }

    






}
