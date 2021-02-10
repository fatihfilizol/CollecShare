package com.fatih.backend.CollecShare.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.http.HttpHeaders;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fatih.backend.CollecShare.Entity.Kullanicilar;
import com.fatih.backend.CollecShare.Repository.KullanicilarRepository;
import com.fatih.backend.CollecShare.Repository.UploadManager;
import com.sun.net.httpserver.Headers;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ImageController {

	@Autowired
	private UploadManager storageService;

	@Autowired
	private ServletContext servletContext;
	
	

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String upload(@RequestParam MultipartFile file) {

		storageService.uploadFile(file, "images/urunler/");

		return "success";
	}

	@GetMapping(value = "/getGonderiImage/{img_url}")
	public ResponseEntity<byte[]> getImageWithMediaType(@PathVariable String img_url) throws IOException {
	
	
		byte[] deneme=storageService.getUrun("images/posts/"+img_url);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(deneme);
		
	}

	@RequestMapping(value = "/uploadTasarim", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadTasarim(@RequestParam MultipartFile file) {
		storageService.uploadFile(file, "images/tasarim/");
		return "success";
	}

	@RequestMapping(value = "/uploadPost", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadGorsel(@RequestParam MultipartFile file) {

		storageService.uploadFile(file, "images/posts/");

		return "success";
	}

	@RequestMapping(value = "/uploadKampanya", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadKampanya(@RequestParam MultipartFile file) {

		storageService.uploadFile(file, "images/kampanyalar/");

		return "success";
	}

//	@GetMapping(value = "/getTasarimGorseller")
//	@PreAuthorize("hasRole('ROLE_GRAFIKER')")
//	public ResponseEntity<InputStreamResource> getTasarimGorseller(HttpServletRequest request,
//			HttpServletResponse response) throws IOException {

//		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
//	        System.out.println("fileName: " + fileName);
//	        System.out.println("mediaType: " + mediaType);
//	 
//	        File file = new File(DIRECTORY + "/" + fileName);
//	        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//	 
//	        return ResponseEntity.ok()
//	                // Content-Disposition
//	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//	                // Content-Type
//	                .contentType(mediaType)
//	                // Contet-Length
//	                .contentLength(file.length()) //
//	                .body(resource);
//	}

	@PostMapping(value = "/getTasarimGorseller")
	public ResponseEntity<byte[]> downloadFile1(@RequestBody Map<String,Object> body) throws IOException {
		byte[] image = storageService.getUrun("images/gorseller/"+ body.get("imgUrl").toString() );
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);

	}
	
	@PostMapping(value = "/getTasarim")
	public ResponseEntity<byte[]> downloadFile2(@RequestBody Map<String,Object> body) throws IOException {
		byte[] image = storageService.getUrun("images/tasarim/" + body.get("imgUrl").toString() );
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);

	}

	@GetMapping(value = "/kampanya/{imgUrl}")
	public ResponseEntity<byte[]> getkampanya(@PathVariable String imgUrl) throws IOException {
		byte[] image = storageService.getUrun("images/kampanyalar/" + imgUrl);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

}
