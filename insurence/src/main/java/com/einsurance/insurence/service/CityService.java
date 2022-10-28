package com.einsurance.insurence.service;

import java.util.List;

import com.einsurance.insurence.exceptions.CityAlreadyExistException;
import com.einsurance.insurence.exceptions.CityNotPresentException;
import com.einsurance.insurence.model.City;

public interface CityService {
	City addCity(City city) throws CityAlreadyExistException;

	City updateStatus(String status, long cityId) throws CityNotPresentException;

	City getCityById(long cityId) throws CityNotPresentException;

	List<City> getCities();

	void deleteCity(long cityId) throws CityNotPresentException;
}
