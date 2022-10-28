package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
