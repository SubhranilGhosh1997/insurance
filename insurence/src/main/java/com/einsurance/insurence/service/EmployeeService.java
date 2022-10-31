package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.EmployeeNotFoundException;
import com.einsurance.insurence.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);

	List<Employee> getEmployees();

	void deleteEmployee(long employeeId) throws EmployeeNotFoundException;

	Employee getEmployeeById(long employeeId) throws EmployeeNotFoundException;

	

}
