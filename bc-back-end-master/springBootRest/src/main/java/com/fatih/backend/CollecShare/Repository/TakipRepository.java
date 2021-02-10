package com.fatih.backend.CollecShare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatih.backend.CollecShare.Entity.Takip;

public interface TakipRepository extends JpaRepository<Takip, Integer> {
	
	@Query("select u from Takip u where u.takipEdenId.id=:takipEdenId and u.takipEdilenId.id=:takipEdilenId")
	Takip kontrolTakip(int takipEdenId, int takipEdilenId);

}
