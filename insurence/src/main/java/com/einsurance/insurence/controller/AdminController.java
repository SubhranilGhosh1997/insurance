package com.einsurance.insurence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einsurance.insurence.exceptions.CityAlreadyExistException;
import com.einsurance.insurence.exceptions.CityNotPresentException;
import com.einsurance.insurence.exceptions.EmployeeNotFoundException;
import com.einsurance.insurence.exceptions.InsuranceAlreadyExistsException;
import com.einsurance.insurence.exceptions.InsurancePlanalredyExistException;
import com.einsurance.insurence.exceptions.InsuranceSchemealredyExistException;
import com.einsurance.insurence.exceptions.InsuranceTypeNotPresentException;
import com.einsurance.insurence.exceptions.PlanNotPresentException;
import com.einsurance.insurence.exceptions.SchemeNotPresentException;
import com.einsurance.insurence.exceptions.StateAlreadyExistException;
import com.einsurance.insurence.exceptions.StateNotPresentException;
import com.einsurance.insurence.model.City;
import com.einsurance.insurence.model.Employee;
import com.einsurance.insurence.model.InsurancePlan;
import com.einsurance.insurence.model.InsuranceScheme;
import com.einsurance.insurence.model.InsuranceSettings;
import com.einsurance.insurence.model.InsuranceType;
import com.einsurance.insurence.model.State;
import com.einsurance.insurence.service.CityService;
import com.einsurance.insurence.service.EmployeeService;
import com.einsurance.insurence.service.InsurancePlanService;
import com.einsurance.insurence.service.InsuranceSchemeService;
import com.einsurance.insurence.service.InsuranceSettingsService;
import com.einsurance.insurence.service.InsuranceTypeService;
import com.einsurance.insurence.service.StateService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	EmployeeService employeeService;

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

	@PostMapping("/createemployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(0);
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/getEmployees")
	public ResponseEntity<?> addEmployee() {
		return new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.CREATED);
	}

	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<?> addEmployee(@PathVariable long employeeId) {
		try {
			return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.CREATED);
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/removeEmployee/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long employeeId) {
		try {
			employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addState")
	public ResponseEntity<?> addState(@RequestBody State state) {
		try {
			return new ResponseEntity<State>(stateService.addState(state), HttpStatus.CREATED);
		} catch (StateAlreadyExistException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updateStatestatus/{status}/{stateId}")
	public ResponseEntity<?> updateStatestatus(@PathVariable("status") String status,
			@PathVariable("stateId") long stateId) {
		try {
			return new ResponseEntity<State>(stateService.updateStatus(status, stateId), HttpStatus.CREATED);
		} catch (StateNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/removeState/{stateId}")
	public ResponseEntity<?> deleteState(@PathVariable long stateId) {
		try {
			stateService.deleteState(stateId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (StateNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addCity")
	public ResponseEntity<?> addCity(@RequestBody City city) {
		try {
			return new ResponseEntity<City>(cityService.addCity(city), HttpStatus.CREATED);
		} catch (CityAlreadyExistException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updateCitystatus/{status}/{cityId}")
	public ResponseEntity<?> updateCitytatus(@PathVariable("status") String status,
			@PathVariable("cityId") long cityId) {
		try {
			return new ResponseEntity<City>(cityService.updateStatus(status, cityId), HttpStatus.CREATED);
		} catch (CityNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/removeCity/{cityId}")
	public ResponseEntity<?> deleteCity(@PathVariable long cityId) {
		try {
			cityService.deleteCity(cityId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (CityNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateInsuranceSetting")
	public ResponseEntity<?> updateInsurenceSetting(@RequestBody InsuranceSettings insuranceSettings) {
		return new ResponseEntity<InsuranceSettings>(insuranceSettingsService.updateSetting(insuranceSettings),
				HttpStatus.CREATED);
	}

	@PutMapping("/updateTax")
	public ResponseEntity<?> updateTax(@RequestBody InsuranceSettings insuranceSettings) {
		return new ResponseEntity<InsuranceSettings>(insuranceSettingsService.updateTax(insuranceSettings),
				HttpStatus.CREATED);
	}

	@PostMapping("/addInsuranceType")
	public ResponseEntity<?> addInsuranceType(@RequestBody InsuranceType insuranceType) {
		insuranceType.setInsuranceTypeId(0);
		try {
			return new ResponseEntity<InsuranceType>(insuranceTypeService.addInsuranceType(insuranceType),
					HttpStatus.CREATED);
		} catch (InsuranceAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getInsurenceTypeList")
	public ResponseEntity<?> getAllInsuranceTypes() {
			return new ResponseEntity<List<InsuranceType>>(insuranceTypeService.getAllInsuranceTypes(),
					HttpStatus.OK);
		
	}
	@PutMapping("/updateInsuranceType")
	public ResponseEntity<?> updateInsuranceType(@RequestBody InsuranceType insuranceType) {
		try {
			return new ResponseEntity<InsuranceType>(insuranceTypeService.updateInsuranceType(insuranceType),
					HttpStatus.CREATED);
		} catch (InsuranceTypeNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addInsuranceScheme")
	public ResponseEntity<?> addInsurancecheme(@RequestBody InsuranceScheme insuranceSchme) {
		insuranceSchme.setInsuranceSchemeId(0);
		try {
			try {
				return new ResponseEntity<InsuranceScheme>(insuranceSchemeService.addInsuranceScheme(insuranceSchme),
						HttpStatus.CREATED);
			} catch (InsuranceTypeNotPresentException e) {
				return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
			}
		} catch (InsuranceSchemealredyExistException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getInsurenceSchemeList")
	public ResponseEntity<?> getAllInsuranceScheme() {
			return new ResponseEntity<List<InsuranceScheme>>(insuranceSchemeService.getAllInsuranceScheme(),
					HttpStatus.OK);
		
	}
	@PutMapping("/updateInsuranceScheme")
	public ResponseEntity<?> updateInsuranceScheme(@RequestBody InsuranceScheme insuranceSchme) {
		try {
			return new ResponseEntity<InsuranceScheme>(insuranceSchemeService.updateInsuranceScheme(insuranceSchme),
					HttpStatus.CREATED);
		} catch (SchemeNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	} 
	
	@PostMapping("/addInsurancePlan")
	public ResponseEntity<?> addInsurancePlan(@RequestBody InsurancePlan insurancePlan) {
		insurancePlan.setInsurancePlanId(0);
		try {
			return new ResponseEntity<InsurancePlan>(insurancePlanService.addInsurancePlan(insurancePlan),
					HttpStatus.CREATED);
		} catch (InsurancePlanalredyExistException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getInsurencePlanList")
	public ResponseEntity<?> getAllInsurancePlans() {
			return new ResponseEntity<List<InsurancePlan>>(insurancePlanService.getAllInsurancePlan(),
					HttpStatus.OK);
		
	}
	@PutMapping("/updateInsurancePlan")
	public ResponseEntity<?> updateInsurancePlan(@RequestBody InsurancePlan insurancePlan) {
		try {
			return new ResponseEntity<InsurancePlan>(insurancePlanService.updateInsurancePlan(insurancePlan),
					HttpStatus.CREATED);
		} catch (PlanNotPresentException e) {
			return new ResponseEntity<String>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
		}
	}
}
