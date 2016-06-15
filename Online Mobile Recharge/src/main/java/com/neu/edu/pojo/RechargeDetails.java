package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rechargetable")
public class RechargeDetails {

	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="rechargeID", unique=true, nullable=false)
	private long rechargeID;
	
    @ManyToOne
	@JoinColumn(name="userId")
    private User userId;
		
	@ManyToOne
	@JoinColumn (name ="servicePhoneNumber")
    private PhoneNumber servicePhoneNumber;	
	
	@Column(name="amount")
	private float amount;
	
	public RechargeDetails( long rechargeID,User userId,PhoneNumber servicePhoneNumber, float amount  ) {
		this.rechargeID = rechargeID;
        this.userId = userId; 
        this.servicePhoneNumber = servicePhoneNumber; 
        this.amount=amount;
        
    }
	public RechargeDetails(){
		
	}
	public long getRechargeID() {
		return rechargeID;
	}
	public void setRechargeID(long rechargeID) {
		this.rechargeID = rechargeID;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public PhoneNumber getServicePhoneNumber() {
		return servicePhoneNumber;
	}
	public void setServicePhoneNumber(PhoneNumber servicePhoneNumber) {
		this.servicePhoneNumber = servicePhoneNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
