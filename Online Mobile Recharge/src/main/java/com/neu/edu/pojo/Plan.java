package com.neu.edu.pojo;



import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="plantable")
public class Plan{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column (name ="planID",unique=true, nullable=false)
    private long planID;
	
	@Column (name ="planName")
    private String planName;
	
	@Column (name ="price", unique=true, nullable=false)
    private float price;
	
	@ManyToOne(fetch= FetchType.LAZY,cascade=CascadeType.ALL)
	@Transient//property wont be saved to db
    private String serviceProviderName;
	
	@ManyToOne
	@JoinColumn(name="serviceProviderID")
	private ServiceProvider serviceProviderID ;	
	
	public Plan( ServiceProvider serviceProviderID, String serviceProviderName, long planID, String planName, float price  ) {
		System.out.print("pojo" +serviceProviderID);
		this.serviceProviderID = serviceProviderID;
        this.planID = planID; 
        this.planName = planName; 
        this.price = price; 
        this.serviceProviderName = serviceProviderName;
        
    }

	Plan(){		
	}
	
	public long getPlanID() {
		return planID;
	}


	public void setPlanID(long planID) {
		this.planID = planID;
	}


	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		this.planName = planName;
	}


	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public ServiceProvider getServiceProviderID() {
		return serviceProviderID;
	}


	public void setServiceProviderID(ServiceProvider serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}



}