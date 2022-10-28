package com.einsurance.insurence.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Optional<Customer> findAllByEmailIdAndPassword(String emailId, String password);

//    User findByEmail(String email);

}
