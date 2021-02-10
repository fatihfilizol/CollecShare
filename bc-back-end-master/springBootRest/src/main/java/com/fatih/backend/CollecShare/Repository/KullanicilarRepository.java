package com.fatih.backend.CollecShare.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatih.backend.CollecShare.Entity.Kullanicilar;

public interface KullanicilarRepository extends JpaRepository<Kullanicilar, Integer> {

	Optional<Kullanicilar> findByUsername(String username);
	
	List<Kullanicilar> findById(int id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query("select u from Kullanicilar u where  u.adSoyad like %:adi% or u.username like %:adi% ")
	List<Kullanicilar> kullaniciGetir(String adi);


}
