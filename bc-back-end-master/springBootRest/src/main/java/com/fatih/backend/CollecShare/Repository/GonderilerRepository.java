package com.fatih.backend.CollecShare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatih.backend.CollecShare.Entity.Gonderiler;

public interface GonderilerRepository extends JpaRepository<Gonderiler, Integer> {
	
	@Query("select u from Gonderiler u where u.kullaniciId.id=?1")
	List<Gonderiler> gonderileriGetir(int id);
	
	@Query("SELECT g FROM Gonderiler g left join Takip t on t.takipEdilenId.id=g.kullaniciId.id where t.takipEdenId.id=:id")
	List<Gonderiler> anasayfa(int id);

}
