package com.fatih.backend.CollecShare.Controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatih.backend.CollecShare.Entity.Takip;
import com.fatih.backend.CollecShare.Repository.TakipRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TakipController {
	
	@Autowired
	private TakipRepository TakipRepository;

	
	@PostMapping("/takipEt")
	public Takip takipEt(@RequestBody Takip takip ){
		Date tarih=new Date();
		takip.setTakipTarihi(tarih);
		return TakipRepository.save(takip);
	}
	
	@PostMapping("/takipKontrol")
	public Takip kontrolTakip(@RequestBody Map<String,Object> body) {
		
		return TakipRepository.kontrolTakip(Integer.parseInt(body.get("takipEdenId").toString()), Integer.parseInt(body.get("takipEdilenId").toString()));
	}
	
	
	



}
