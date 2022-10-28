package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.UserNotValidException;
import com.einsurance.insurence.model.Customer;
import com.einsurance.insurence.repo.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public Customer addCustomer(Customer customer) {
		customer.setRole("ROLE_Customer");
		Customer savedCustome = customerRepository.save(customer);
		
		return savedCustome;
	}
	@Override
	public List<Customer> getCustomer() {
		List<Customer> customerList = customerRepository.findAll();
		return customerList;
	}
	@Override
	public Customer login(String emailId, String password) throws UserNotValidException {
		Optional<Customer> customersOptional=customerRepository.findAllByEmailIdAndPassword(emailId, password);
		if(!customersOptional.isPresent())
		{
			throw new UserNotValidException("Username & Password invalid"); 
		}
		return	customersOptional.get();
	}

}
