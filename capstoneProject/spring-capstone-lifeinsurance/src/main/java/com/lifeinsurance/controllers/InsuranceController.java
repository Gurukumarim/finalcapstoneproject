package com.lifeinsurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifeinsurance.model.Insurance;
import com.lifeinsurance.service.IInsuranceService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("lifeinsurance-api")
public class InsuranceController {
	
	@Autowired
	IInsuranceService insuranceService;
	
	@PostMapping("/insurances")
	public ResponseEntity<Void> addInsurance(@RequestBody Insurance insurance) {
		insuranceService.addInsurance(insurance);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/insurances")
	public ResponseEntity<Void> updateInsurance(@RequestBody Insurance insurance){
		insuranceService.updateInsurance(insurance);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
		
	@DeleteMapping("/insurances/{insuranceId}")
	public ResponseEntity<String> deleteInsurance(@PathVariable("insuranceId") int insuranceId){
		insuranceService.deleteInsurance(insuranceId);
		return ResponseEntity.accepted().body("Updated");
	}
	
	@GetMapping("/insurances")
	public ResponseEntity<List<Insurance>> getAll(){
		List<Insurance> insurances= insuranceService.getAll();
//		HttpHeaders httpHeaders=new HttpHeaders();
//		httpHeaders.add("desc", "Getting By all");
//		httpHeaders.add("info", "Getting By all info");
		
		ResponseEntity<List<Insurance>> responseEntity=new ResponseEntity<List<Insurance>>(insurances,  HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/insurances/name/{name}")
	public ResponseEntity<List<Insurance>> getByName(@PathVariable("name") String insuranceName){
		List<Insurance> insurances= insuranceService.getByName(insuranceName);
		ResponseEntity<List<Insurance>> responseEntity=new ResponseEntity<List<Insurance>>(insurances,  HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/insurances/id/{insuranceId}")
	public ResponseEntity<Insurance> getById(@PathVariable("insuranceId") int insuranceId){
		Insurance insurances= insuranceService.getById(insuranceId);
		ResponseEntity<Insurance> responseEntity=new ResponseEntity<Insurance>(insurances, HttpStatus.OK);	
		return responseEntity;
		
	}
	@GetMapping("/insurances/plans/{plan}")
	public ResponseEntity<List<Insurance>> getByPlan(@PathVariable("plan") String plan){
		List<Insurance> insurances= insuranceService.getByPlan(plan);
		ResponseEntity<List<Insurance>> responseEntity=new ResponseEntity<List<Insurance>>(insurances, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/insurances/client/{clientName}")
	public ResponseEntity<List<Insurance>> getByClients(@PathVariable("clientName") String clientName){
		List<Insurance> insurances= insuranceService.getByClients(clientName);
		ResponseEntity<List<Insurance>> responseEntity=new ResponseEntity<List<Insurance>>(insurances, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/insurances/plans")
	public ResponseEntity<List<String>> getAllPlans(){
		List<String> plans= insuranceService.getAllPlan();
		ResponseEntity<List<String>> responseEntity=new ResponseEntity<List<String>>(plans, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/insurances/names")
	public ResponseEntity<List<String>> getByName(){
		List<String> insuranceNames= insuranceService.getAllNames();
		ResponseEntity<List<String>> responseEntity=new ResponseEntity<List<String>>(insuranceNames,  HttpStatus.OK);
		return responseEntity;
		
	}
}
