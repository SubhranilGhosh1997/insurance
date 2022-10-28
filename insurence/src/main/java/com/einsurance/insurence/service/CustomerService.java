package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.UserNotValidException;
import com.einsurance.insurence.model.Customer;



public interface CustomerService {
	Customer addCustomer(Customer customer);

	List<Customer> getCustomer();

	Customer login(String emailId, String password) throws UserNotValidException;
}
