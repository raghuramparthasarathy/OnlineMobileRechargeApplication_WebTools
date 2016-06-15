package com.neu.edu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="phonetable")
public class PhoneNumber    {
    @Id
	@Column (name ="servicePhoneNumber")
    private long servicePhoneNumber;
    
	@ManyToOne
	
    @JoinColumn(name="userId")
    private User userId;	
	
	@ManyToOne(fetch= FetchType.LAZY,cascade=CascadeType.ALL)
	@Transient//property wont be saved to db
    private String serviceProviderName;
	
	@ManyToOne
	 @JoinColumn(name="serviceProviderID")
	 private ServiceProvider serviceProviderID ;	
	PhoneNumber(){		
	}
	public PhoneNumber( long servicePhoneNumber,User userId,String serviceProviderName,ServiceProvider serviceProviderID  ) {
		this.userId = userId;
        this.servicePhoneNumber = servicePhoneNumber; 
        this.serviceProviderID = serviceProviderID; 
        this.serviceProviderName = serviceProviderName; 
        
    }
	public long getServicePhoneNumber() {
		return servicePhoneNumber;
	}
	public void setServicePhoneNumber(long servicePhoneNumber) {
		this.servicePhoneNumber = servicePhoneNumber;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public ServiceProvider getServiceProviderID() {
		return serviceProviderID;
	}
	public void setServiceProviderID(ServiceProvider serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}
	
	
	
}
