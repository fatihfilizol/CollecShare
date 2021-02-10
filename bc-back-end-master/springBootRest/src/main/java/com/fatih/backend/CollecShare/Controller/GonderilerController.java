package com.fatih.backend.CollecShare.Controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatih.backend.CollecShare.Entity.Gonderiler;
import com.fatih.backend.CollecShare.Repository.GonderilerRepository;
import com.fatih.backend.CollecShare.Repository.KullanicilarRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class GonderilerController {
	
	@Autowired
	private GonderilerRepository gonderilerRepository;

	
	@PostMapping("/gonderiEkle")
	public Gonderiler gonderiEkle(@Valid @RequestBody Gonderiler gonderiler ){
		Date date=new Date();
		gonderiler.setPaylasimTarihi(date);
		
		return gonderilerRepository.save(gonderiler);
	}
	
	@GetMapping("/listGonderi/{id}")
	public List<Gonderiler> gonderiList(@PathVariable int id ){
		return gonderilerRepository.gonderileriGetir(id);
	}
	
	@GetMapping("/anasayfa/{id}")
	public List<Gonderiler> anasayfa(@PathVariable int id ){
		return gonderilerRepository.anasayfa(id);
	}
	
	



}
