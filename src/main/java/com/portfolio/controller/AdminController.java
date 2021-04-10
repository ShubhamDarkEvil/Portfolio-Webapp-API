package com.portfolio.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.UserEntity;
import com.portfolio.service.AdminService;
@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class AdminController {
	
	
	@Autowired
	AdminService adminservice;
	
	
	@GetMapping(value="/me")
	public String getMe()
	{
		return "This is really Working !!";
	}
	
	
	@GetMapping(value="/getallme")
	public List<UserEntity> getAllMyDetails() throws InterruptedException, ExecutionException {
		return adminservice.getAllAdmninDetails();
		
	}
	
	@GetMapping(value="/getme")
	public UserEntity getMyDetails(@RequestParam String name) throws InterruptedException, ExecutionException {
		return adminservice.getAdmninDetails(name);
		
	}
	
	@PostMapping(value="/addme")
	public String createAdmin(@RequestBody UserEntity userentity) throws InterruptedException, ExecutionException {
	
		return adminservice.addAdminDetails(userentity);
	}
	
	@PutMapping("/updateme")  
	 public String updatePatient(@RequestBody UserEntity userentity ) throws InterruptedException, ExecutionException {  
	 return adminservice.updateAdminDetails(userentity);  
	 }  
	 @DeleteMapping("/deleterecord")  
	 public String deletePatient(@RequestParam String name){  
	 return adminservice.deleteAdminRecord(name);  
	 }  
	
	
	
	}


