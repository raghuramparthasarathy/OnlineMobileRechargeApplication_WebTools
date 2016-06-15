package com.neu.edu.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.ServiceProvider;




public class AdminDAO extends DAO {

    public AdminDAO() {
    }
    
     
    
    public ServiceProvider get(String serviceProvidername) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from ServiceProvider where serviceProvidername= :spn");
            q.setString("spn",serviceProvidername);
            ServiceProvider sp=(ServiceProvider)q.uniqueResult();
            commit();
            return sp;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + serviceProvidername + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from ServiceProvider");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the provider Name", e);
        }
    }

   
    public ServiceProvider create(long serviceProviderID, String serviceProviderName)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
        
            ServiceProvider sp=new ServiceProvider(serviceProviderID, serviceProviderName);           
            getSession().save(sp);
            
            commit();
            return sp;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

   }