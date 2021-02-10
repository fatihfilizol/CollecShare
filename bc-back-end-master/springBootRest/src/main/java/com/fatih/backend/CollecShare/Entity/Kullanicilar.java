package com.fatih.backend.CollecShare.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="kullanicilar", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
	})
public class Kullanicilar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="adSoyad")
	private String adSoyad;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="kayitTarihi")
	private Date kayitTarihi;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kullaniciId")
	private List<Gonderiler> gonderiler=new ArrayList<Gonderiler>();
	

	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "takipEdenId")
	private List<Takip> takipeden;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "takipEdilenId")
	private List<Takip> takipedilen;
	
	public Kullanicilar() {
		
	}
	
	public Kullanicilar(String username, String email, String password) {

		this.email = email;
		
		this.username = username;
		this.password = password;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
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

	public Date getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	

}
