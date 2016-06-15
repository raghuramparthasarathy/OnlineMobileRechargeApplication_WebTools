package com.neu.edu.pojo;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
@Table(name="usertable")
public class User{
	
	@Id
	@GeneratedValue
	@Column(name="userId")
	private long userId;
	@Column(name="name")
    private String name;
	
	@Column(name="phone")
    private long phone;
	
	@Column(name="email")
    private String email;
	@Column(name="username")
    private String username;
	@Column(name="password")
    private String password;
	@Column(name="confirmPassword")
    private String confirmPassword;
	@Column(name="role")
    private String role;
	
	@Column(name="picName")
	private String picName;
	
	@Transient
	@Column(name="photo")
	private MultipartFile pic;
	
	public String getPicName() {
		return picName;
	}


	public void setPicName(String picName) {
		this.picName = picName;
	}


	public MultipartFile getPic() {
		return pic;
	}


	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	

    public User(String name,long phone, String email, String username, String password, String confirmPassword,String role, String picName) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
        this.picName = picName;
    }


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	User() {
    }

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPassword() {
        return password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}