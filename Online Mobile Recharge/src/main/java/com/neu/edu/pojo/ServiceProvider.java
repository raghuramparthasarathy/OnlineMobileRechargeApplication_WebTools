package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="sptable", uniqueConstraints = {@UniqueConstraint(columnNames = {"serviceProviderName"})} )
@Inheritance(strategy=InheritanceType.JOINED)

public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="serviceProviderID", unique=true, nullable=false)
	private long serviceProviderID;
	@Column (name ="serviceProviderName", unique=true)
    private String serviceProviderName;
	@OneToMany(fetch= FetchType.LAZY,mappedBy="serviceProviderID")
	private Set<PhoneNumber> pn = new HashSet<PhoneNumber>();
	
	@OneToMany(fetch= FetchType.LAZY,mappedBy="serviceProviderID")
    private Set<Plan> plan = new HashSet<Plan>();
			
	public ServiceProvider(){
		
	}
	public ServiceProvider(long serviceProviderID, String serviceProviderName) {
		this.serviceProviderID = serviceProviderID;
		this.serviceProviderName = serviceProviderName;
        this.pn = new HashSet<PhoneNumber>();
      this.plan = new HashSet<Plan>();
        
	}

	public long getServiceProviderID() {
		return serviceProviderID;
	}

	public void setServiceProviderID(long serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	public Set<Plan> getPlan() {
		return plan;
	}
	public void setPlan(Set<Plan> plan) {
		this.plan = plan;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public Set<PhoneNumber> getPn() {
		return pn;
	}

	public void setPn(Set<PhoneNumber> pn) {
		this.pn = pn;
	}
	
	
		
}
