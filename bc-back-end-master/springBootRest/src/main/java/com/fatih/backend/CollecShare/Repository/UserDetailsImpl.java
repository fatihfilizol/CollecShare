package com.fatih.backend.CollecShare.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatih.backend.CollecShare.Entity.Kullanicilar;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String ad_soyad;

	private int id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(int id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities, String ad_soyad) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.ad_soyad=ad_soyad;
	}

	public static UserDetailsImpl build(Kullanicilar user) {
	
				
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(), 
				authorities,
				user.getAdSoyad());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}


	public String getAd_soyad() {
		return ad_soyad;
	}

	public void setAd_soyad(String ad_soyad) {
		this.ad_soyad = ad_soyad;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
