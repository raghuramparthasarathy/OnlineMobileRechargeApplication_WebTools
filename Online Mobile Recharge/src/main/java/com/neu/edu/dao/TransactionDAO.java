package com.neu.edu.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.RechargeDetails;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.TransactionDetails;
import com.neu.edu.pojo.User;




public class TransactionDAO extends DAO {

    public TransactionDAO() {
    }
    
     
    
    public TransactionDetails get(int transactionID) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from TransactionDetails where transactionID= :id");
            q.setInteger("id",transactionID);
            TransactionDetails tn=(TransactionDetails)q.uniqueResult();
            commit();
            return tn;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + transactionID + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from TransactionDetails");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the transaction details", e);
        }
    }

   
    public TransactionDetails create(int transactionID,RechargeDetails rechargeID,RechargeDetails amount,String card,long cardNumber, String expMonth,int expYear, int cvv,String message)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
//            Query query=getSession().createQuery("from ServiceProvider where serviceProviderName=:providerName");
//            query.setString("providerName", serviceProviderName);
//            ServiceProvider sp=(ServiceProvider)query.uniqueResult();
        	
        
            TransactionDetails transactionDetails=new TransactionDetails( transactionID,rechargeID,amount, card, cardNumber, expMonth,expYear,cvv,message);           
            getSession().save(transactionDetails);
            
            commit();
            return transactionDetails;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

   }