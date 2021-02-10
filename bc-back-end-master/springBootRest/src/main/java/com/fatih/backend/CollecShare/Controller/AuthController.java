package com.fatih.backend.CollecShare.Controller;

import com.fatih.backend.CollecShare.Entity.Gonderiler;
import com.fatih.backend.CollecShare.Entity.JwtResponse;
import com.fatih.backend.CollecShare.Entity.Kullanicilar;
import com.fatih.backend.CollecShare.Entity.LoginRequest;
import com.fatih.backend.CollecShare.Entity.MessageResponse;
import com.fatih.backend.CollecShare.Entity.SignupRequest;
import com.fatih.backend.CollecShare.Repository.*;
import com.fatih.backend.CollecShare.Security.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;



	@Autowired
	KullanicilarRepository userRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(), roles, userDetails.getAd_soyad()));
	}


	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		System.out.println(signUpRequest.getId());
		Kullanicilar user;
		System.out.println(signUpRequest.getId());
		if (userRepository.existsByUsername(signUpRequest.getUsername()) && signUpRequest.getId() == 0) {

			return ResponseEntity.badRequest().body(new MessageResponse("Hata: Kullanıcı adı zaten alınmış!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail()) && signUpRequest.getId() == 0) {

			return ResponseEntity.badRequest().body(new MessageResponse("Hata: E-posta zaten kullanımda!"));
		}
		if (signUpRequest.getId() == 0) {

			user = new Kullanicilar(signUpRequest.getUsername(), signUpRequest.getEmail(),
					encoder.encode(signUpRequest.getPassword()));
		} else {

			user = userRepository.getOne(signUpRequest.getId());
			user.setUsername(signUpRequest.getUsername());
			user.setPassword(encoder.encode(signUpRequest.getPassword()));
			user.setEmail(signUpRequest.getEmail());
			user.setId(signUpRequest.getId());
		}

		
		
		user.setAdSoyad(signUpRequest.getAd_soyad());

	
		Date date = new Date();
		user.setKayitTarihi(date);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Kayıt Başarılı"));
	}
	
	@GetMapping("/kullanicilar/{adi}")
	public List<Kullanicilar> kullaniciGetir(@PathVariable String adi ){
		return userRepository.kullaniciGetir(adi);
	}
	
	@GetMapping("/kullanicilar/id/{id}")
	public List<Kullanicilar> getByid(@PathVariable int id ){
		return userRepository.findById(id);
	}
}