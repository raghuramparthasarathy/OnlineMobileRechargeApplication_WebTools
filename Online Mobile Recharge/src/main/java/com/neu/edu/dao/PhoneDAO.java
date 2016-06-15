package com.neu.edu.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.User;




public class PhoneDAO extends DAO {

    public PhoneDAO() {
    }
    
     
    
    public PhoneNumber get(long servicePhoneNumber) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from PhoneNumber where servicePhoneNumber= :spn");
            q.setLong("spn",servicePhoneNumber);
            PhoneNumber pn=(PhoneNumber)q.uniqueResult();
            commit();
            return pn;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + servicePhoneNumber + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from PhoneNumber");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the provider Name", e);
        }
    }

   
    public PhoneNumber create(long servicePhoneNumber,String serviceProviderName,User user)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            Query query=getSession().createQuery("from ServiceProvider where serviceProviderName=:providerName");
            query.setString("providerName", serviceProviderName);
            ServiceProvider sp=(ServiceProvider)query.uniqueResult();
        	
        
            PhoneNumber phone=new PhoneNumber( servicePhoneNumber,user, serviceProviderName, sp);           
            getSession().save(phone);
            
            commit();
            return phone;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

   }