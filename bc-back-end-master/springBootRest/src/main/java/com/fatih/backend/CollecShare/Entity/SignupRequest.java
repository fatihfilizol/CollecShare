package com.fatih.backend.CollecShare.Entity;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
	
	private int id=0;
	

	private String ad_soyad;



	@NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    

	public String getAd_soyad() {
		return ad_soyad;
	}

	public void setAd_soyad(String ad_soyad) {
		this.ad_soyad = ad_soyad;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
