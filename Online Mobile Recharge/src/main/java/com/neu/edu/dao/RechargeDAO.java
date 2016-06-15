package com.neu.edu.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.AjaxModel;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.Plan;
import com.neu.edu.pojo.RechargeDetails;
import com.neu.edu.pojo.RechargeModel;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.User;




public class RechargeDAO extends DAO {

    public RechargeDAO() {
    }
    
    public List<RechargeModel> getRecharges() throws Exception{
    	Query q=getSession().createQuery("from RechargeDetails");
    	List<RechargeDetails> list=q.list();
    	List<RechargeModel> am= new ArrayList<RechargeModel>();
    	for(RechargeDetails p:list){
    		RechargeModel ajax=new RechargeModel();
    		ajax.setRechargeID(p.getRechargeID());
    		ajax.setAmount(p.getAmount());
    		ajax.setServicePhoneNumber(p.getServicePhoneNumber());
    		ajax.setUserId(p.getUserId());
    		am.add(ajax);
    		
    		
    		
    	}
		return am;
    	
    }
    
    public RechargeDetails get(long rechargeID) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from RechargeDetails where rechargeID= :price");
            q.setLong("price",rechargeID);
            RechargeDetails pn=(RechargeDetails)q.uniqueResult();
            commit();
            return pn;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + rechargeID + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from RechargeDetails");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the recharge details", e);
        }
    }

   
    public RechargeDetails create(long rechargeID, User user, PhoneNumber phonenumber,float amount)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
//            Query query=getSession().createQuery("from ServiceProvider where serviceProviderName=:providerName");
//            query.setString("providerName", serviceProviderName);
//            ServiceProvider sp=(ServiceProvider)query.uniqueResult();
        	
        
            RechargeDetails rechargeDetails=new RechargeDetails( rechargeID, user, phonenumber, amount);           
            getSession().save(rechargeDetails);
            
            
            commit();
            return rechargeDetails;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

   }