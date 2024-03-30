package com.webbh.dmBanhang.Model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Validated
public class account {

    private Integer aid;

    @NotEmpty(message = "Name is required")
    private String username;

    @NotEmpty(message = "Name is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String pass;

    private Integer issell;

    private Integer isadmin;

//    @NotEmpty(message = "Name is required")
//    @Email(message = "...@gmail.com")
    private String email;
    
//    @NotEmpty(message = "Name is required")
    private String repass;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIssell() {
        return issell;
    }

    public void setIssell(Integer issell) {
        this.issell = issell;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}
    
    
}