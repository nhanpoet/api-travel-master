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
@Table(name = "cars")
public class Cars {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
    private String carName;
    private String carDetail;
    private String carType;
    private int carSeats;
    private String carAutomaker;
    private int enId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="enId", referencedColumnName = "enId", insertable = false, updatable = false)    
    @JsonBackReference
    private Enterprise enterprise;

    @OneToMany(mappedBy="cars", cascade=CascadeType.ALL)
	private List<OrderCar> order_car;

    public int getCarId() {
        return carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarDetail() {
        return carDetail;
    }
    public void setCarDetail(String carDetail) {
        this.carDetail = carDetail;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public int getCarSeats() {
        return carSeats;
    }
    public void setCarSeats(int carSeats) {
        this.carSeats = carSeats;
    }
    public String getCarAutomaker() {
        return carAutomaker;
    }
    public void setCarAutomaker(String carAutomaker) {
        this.carAutomaker = carAutomaker;
    }
    public int getEnId() {
        return enId;
    }
    public void setEnId(int enId) {
        this.enId = enId;
    }

    

}
