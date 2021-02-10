package com.fatih.backend.CollecShare.Repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fatih.backend.CollecShare.Entity.Kullanicilar;


@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
	@Autowired
	KullanicilarRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanicilar user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
