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
@Table(name = "message")
public class Message {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mesId;
	private String mesSender;
	private String mesTitle;
	private int mesType;
	private Date mesTime;
	private int mcId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="mcId", referencedColumnName = "mcId", insertable = false, updatable = false)    
    @JsonBackReference
    private MessageChannel message_channel;

    public MessageChannel getMessage_channel() {
        return message_channel;
    }
    public void setMessage_channel(MessageChannel message_channel) {
        this.message_channel = message_channel;
    }
    public int getMesId() {
        return mesId;
    }
    public void setMesId(int mesId) {
        this.mesId = mesId;
    }
    public String getMesSender() {
        return mesSender;
    }
    public void setMesSender(String mesSender) {
        this.mesSender = mesSender;
    }
    public String getMesTitle() {
        return mesTitle;
    }
    public void setMesTitle(String mesTitle) {
        this.mesTitle = mesTitle;
    }
    public int getMesType() {
        return mesType;
    }
    public void setMesType(int mesType) {
        this.mesType = mesType;
    }
    
    public int getMcId() {
        return mcId;
    }
    public void setMcId(int mcId) {
        this.mcId = mcId;
    }
    public Date getMesTime() {
        return mesTime;
    }
    public void setMesTime(Date mesTime) {
        this.mesTime = mesTime;
    }


    

}
