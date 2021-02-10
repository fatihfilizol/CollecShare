package com.fatih.backend.CollecShare.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name= "takip")
public class Takip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="takipEdenId", referencedColumnName = "id")
	private Kullanicilar takipEdenId;
	
	@ManyToOne
	@JoinColumn(name="takipEdilenId", referencedColumnName = "id")
	private Kullanicilar takipEdilenId;
	
	@Column(name="takipTarihi")
	private Date takipTarihi;
	
	
	public Takip() {
		
	}
	
	public Takip(int id, Kullanicilar takipEdenId, Kullanicilar takipEdilenId, Date takipTarihi) {
		super();
		this.id = id;
		this.takipEdenId = takipEdenId;
		this.takipEdilenId = takipEdilenId;
		this.takipTarihi = takipTarihi;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Kullanicilar getTakipEdenId() {
		return takipEdenId;
	}
	public void setTakipEdenId(Kullanicilar takipEdenId) {
		this.takipEdenId = takipEdenId;
	}
	public Kullanicilar getTakipEdilenId() {
		return takipEdilenId;
	}
	public void setTakipEdilenId(Kullanicilar takipEdilenId) {
		this.takipEdilenId = takipEdilenId;
	}
	public Date getTakipTarihi() {
		return takipTarihi;
	}
	public void setTakipTarihi(Date takipTarihi) {
		this.takipTarihi = takipTarihi;
	}
	
}
