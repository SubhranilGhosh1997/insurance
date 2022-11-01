package com.einsurance.insurence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einsurance.insurence.model.Agent;
import com.einsurance.insurence.model.Customer;
import com.einsurance.insurence.model.Employee;
import com.einsurance.insurence.service.AgentService;
import com.einsurance.insurence.service.CityService;
import com.einsurance.insurence.service.CustomerService;
import com.einsurance.insurence.service.EmployeeService;
import com.einsurance.insurence.service.InsurancePlanService;
import com.einsurance.insurence.service.InsuranceSchemeService;
import com.einsurance.insurence.service.InsuranceSettingsService;
import com.einsurance.insurence.service.InsuranceTypeService;
import com.einsurance.insurence.service.StateService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	CustomerService customerService;

	@Autowired
	AgentService agentService;

	@Autowired
	CityService cityService;

	@Autowired
	StateService stateService;

	@Autowired
	InsuranceSettingsService insuranceSettingsService;

	@Autowired
	InsuranceTypeService insuranceTypeService;

	@Autowired
	InsurancePlanService insurancePlanService;

	@Autowired
	InsuranceSchemeService insuranceSchemeService;

	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/getCustomers")
	public ResponseEntity<?> getCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getCustomer(), HttpStatus.OK);
	}

	@PostMapping("/addAgent")
	public ResponseEntity<?> addAgent(@RequestBody Agent agent ) {
		agent.setAgentId(0);
		return new ResponseEntity<Agent>(agentService.addAgent(agent), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAgents")
	public ResponseEntity<?> getAgents() {
		return new ResponseEntity<List<Agent>>(agentService.getAgent(), HttpStatus.OK);
	}
	
	@PutMapping("/updateAgent")
	public ResponseEntity<?> updateAgent(@RequestBody Agent agent) {
		return new ResponseEntity<Agent>(agentService.addAgent(agent), HttpStatus.CREATED);
	}

}
