package com.einsurance.insurence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einsurance.insurence.exceptions.UserNotValidException;
import com.einsurance.insurence.model.Customer;
import com.einsurance.insurence.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/unauth")
public class UnauthController {
	@Autowired
    CustomerService customerService;
	@PostMapping("/register")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(0);
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
		
	}
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getCustomer(), HttpStatus.OK);
	}
	
	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<?> login(@PathVariable("email") String emailId,@PathVariable("password") String password) {
		
		Customer customer;
		try {
			customer = customerService.login(emailId,password);
			return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		} catch (UserNotValidException e) {

			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}		
		
		
	}
}
