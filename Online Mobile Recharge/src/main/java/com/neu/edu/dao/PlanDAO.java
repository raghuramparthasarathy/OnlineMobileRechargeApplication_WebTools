package com.neu.edu.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.AjaxModel;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.Plan;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.User;




public class PlanDAO extends DAO {

    public PlanDAO() {
    }
   
    public List<AjaxModel> getPlans() throws Exception{
    	Query q=getSession().createQuery("from Plan");
    	List<Plan> list=q.list();
    	List<AjaxModel> am= new ArrayList<AjaxModel>();
    	for(Plan p:list){
    		AjaxModel ajax=new AjaxModel();
    		ajax.setPlanName(p.getPlanName());
    		ajax.setPrice(p.getPrice());
    		ajax.setServiceProviderName(p.getServiceProviderName());
    		am.add(ajax);
    		
    		
    		
    	}
		return am;
    	
    }
     
    
    public Plan get(long planID) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Plan where planID= :pn");
            q.setLong("pn",planID);
            Plan plan=(Plan)q.uniqueResult();
            commit();
            return plan;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + planID + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Plan");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the provider Name", e);
        }
    }

   
    public Plan create(String serviceProviderName, long planID,String planName,float price)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            Query query=getSession().createQuery("from ServiceProvider where serviceProviderName=:providerID");
            System.out.print("inside query" +query);
            query.setString("providerID", serviceProviderName);
            ServiceProvider sp=(ServiceProvider)query.uniqueResult();
            System.out.print("sp query" +sp);
            System.out.print(" query" +query);
        
            Plan plan=new Plan(sp,serviceProviderName, planID, planName, price);           
            getSession().save(plan);
//            System.out.print("DAO" +sp.getServiceProviderID());
            
            commit();
            return plan;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

   }