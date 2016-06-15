package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactiontable")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="transactionID", unique=true, nullable=false)
	private int transactionID;
	
	@ManyToOne
	@JoinColumn (name ="rechargeID")
    private RechargeDetails rechargeID;
	
	@ManyToOne
	@JoinColumn (name ="amount")
    private RechargeDetails amount;
	
	@Column(name="card")
	private String card;
	
	@Column(name="cardNumber", unique=true, nullable=false)
	private long cardNumber;
	
	@Column(name="expMonth")
	private String expMonth;
	
	@Column(name="expYear")
	private int expYear;
	
	@Column(name="cvv", unique=true, nullable=false)
	private int cvv;
	
	@Column(name="message")
	private String message;
	
	public TransactionDetails(int transactionID,RechargeDetails rechargeID,RechargeDetails amount, String card,long cardNumber, String expMonth,int expYear, int cvv,String message ){
		
		this.transactionID=transactionID;
		this.rechargeID=rechargeID;
		this.amount=amount;
		this.card=card;
		this.cardNumber=cardNumber;
		this.expMonth=expMonth;
		this.cvv=cvv;
		this.expYear=expYear;
		this.message=message;
	}
	
public TransactionDetails(){
		
	}

public int getTransactionID() {
	return transactionID;
}

public void setTransactionID(int transactionID) {
	this.transactionID = transactionID;
}

public RechargeDetails getRechargeID() {
	return rechargeID;
}

public void setRechargeID(RechargeDetails rechargeID) {
	this.rechargeID = rechargeID;
}


public RechargeDetails getAmount() {
	return amount;
}

public void setAmount(RechargeDetails amount) {
	this.amount = amount;
}

public String getCard() {
	return card;
}

public void setCard(String card) {
	this.card = card;
}


public long getCardNumber() {
	return cardNumber;
}

public void setCardNumber(long cardNumber) {
	this.cardNumber = cardNumber;
}

public String getExpMonth() {
	return expMonth;
}

public void setExpMonth(String expMonth) {
	this.expMonth = expMonth;
}


public int getExpYear() {
	return expYear;
}

public void setExpYear(int expYear) {
	this.expYear = expYear;
}

public int getCvv() {
	return cvv;
}

public void setCvv(int cvv) {
	this.cvv = cvv;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

	

}
