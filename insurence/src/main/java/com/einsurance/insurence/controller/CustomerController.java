package com.einsurance.insurence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einsurance.insurence.model.Documents;
import com.einsurance.insurence.model.InsurancePlan;
import com.einsurance.insurence.service.DocumentService;
import com.einsurance.insurence.service.InsurancePlanService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	InsurancePlanService insurancePlanService;
	@PostMapping("/addDocument/{customerId}")
	public ResponseEntity<?> addDocument(@PathVariable long customerId, @RequestBody Documents document){
		Documents newDocument = documentService.addDocumentByuserId(customerId,document);
		return new ResponseEntity<Documents>(newDocument,HttpStatus.CREATED);
	}
	@GetMapping("/getInsurencePlanList")
	public ResponseEntity<?> getAllInsurancePlans() {
			return new ResponseEntity<List<InsurancePlan>>(insurancePlanService.getAllInsurancePlan(),
					HttpStatus.OK);
		
	}
}

