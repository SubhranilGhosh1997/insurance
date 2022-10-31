package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.EmployeeNotFoundException;
import com.einsurance.insurence.model.Employee;
import com.einsurance.insurence.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

	@Override
	public void deleteEmployee(long employeeId) throws EmployeeNotFoundException {
		employeeRepository.delete(getEmployeeById(employeeId));
	}

	@Override
	public Employee getEmployeeById(long employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		return employee.get();
	}

}
