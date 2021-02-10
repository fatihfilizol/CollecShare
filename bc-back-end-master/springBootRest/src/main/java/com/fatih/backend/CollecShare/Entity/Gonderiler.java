package com.fatih.backend.CollecShare.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="gonderiler")
public class Gonderiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="kullanici_id", referencedColumnName = "id")
	private Kullanicilar kullaniciId;
	
	@Column(name="gorsel")
	private String gorsel;
	
	@Column(name="aciklama")
	private String aciklama;
	
	@Column(name="paylasimTarihi")
	private Date paylasimTarihi;
	
	public Gonderiler() {
		
	}
	
	public Gonderiler(int id, Kullanicilar kullaniciId, String gorsel, String aciklama, Date paylasimTarihi) {
		super();
		this.id = id;
		this.kullaniciId = kullaniciId;
		this.gorsel = gorsel;
		this.aciklama = aciklama;
		this.paylasimTarihi = paylasimTarihi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Kullanicilar getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(Kullanicilar kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public String getGorsel() {
		return gorsel;
	}
	public void setGorsel(String gorsel) {
		this.gorsel = gorsel;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public Date getPaylasimTarihi() {
		return paylasimTarihi;
	}
	public void setPaylasimTarihi(Date paylasimTarihi) {
		this.paylasimTarihi = paylasimTarihi;
	}

}
