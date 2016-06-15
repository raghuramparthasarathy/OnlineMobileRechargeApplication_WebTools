package com.neu.edu.pojo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class RechargeModel {
	
	
			private long rechargeID;
			private float amount;
			private PhoneNumber servicePhoneNumber;	
			private User userId;
			public long getRechargeID() {
				return rechargeID;
			}
			public void setRechargeID(long rechargeID) {
				this.rechargeID = rechargeID;
			}
			public float getAmount() {
				return amount;
			}
			public void setAmount(float amount) {
				this.amount = amount;
			}
			public PhoneNumber getServicePhoneNumber() {
				return servicePhoneNumber;
			}
			public void setServicePhoneNumber(PhoneNumber phoneNumber) {
				this.servicePhoneNumber = phoneNumber;
			}
			public User getUserId() {
				return userId;
			}
			public void setUserId(User userId) {
				this.userId = userId;
			}
		
		
		
}
