package com.neu.edu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class AjaxModel {
	
	
		private String planName;
		private float price;
		private String serviceProviderName;
		
		
		public String getPlanName() {
			return planName;
		}
		public void setPlanName(String planName) {
			this.planName = planName;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getServiceProviderName() {
			return serviceProviderName;
		}
		public void setServiceProviderName(String serviceProviderName) {
			this.serviceProviderName = serviceProviderName;
		}

}
