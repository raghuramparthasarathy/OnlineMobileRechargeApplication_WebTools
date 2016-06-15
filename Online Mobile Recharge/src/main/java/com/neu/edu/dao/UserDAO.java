package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.User;



public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(User user)
            throws AdException {
        try {
        	boolean result;
            begin();
            Query q = getSession().createQuery("from User where username = :nameOfUser");
            q.setString("nameOfUser", user.getUsername());
            System.out.println("query if"+q);
            System.out.println("name"+user.getUsername());
            User queryResult = (User) q.uniqueResult();
            commit();
            System.out.println("queryresult" +queryResult);
            if(queryResult != null){
            	System.out.println("queryresult1" +queryResult);
            	if(queryResult.getUsername().equals(user.getUsername()) && (queryResult.getPassword().equals(user.getPassword()))){
            		System.out.println("inside if");
            		user = queryResult;
            	}
            	}
            	

           return user;
           
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + e);
        }
    }

    public User create(String name, long phone, String email, String username, String password, String confirmPassword, String picName)
            throws AdException {
        try {
        	String role="customer";
            begin();
            System.out.println("inside DAO");
        
            User user=new User(name, phone, email,username, password, confirmPassword,role,picName);
            
          
            
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getName(), e);
        }
    }
}