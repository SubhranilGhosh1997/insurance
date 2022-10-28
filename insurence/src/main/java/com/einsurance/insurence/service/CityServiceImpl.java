package com.einsurance.insurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einsurance.insurence.exceptions.CityAlreadyExistException;
import com.einsurance.insurence.exceptions.CityNotPresentException;
import com.einsurance.insurence.model.City;
import com.einsurance.insurence.repo.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityRepository cityRepository;
	@Override
	public City addCity(City city) throws CityAlreadyExistException {
		List<City> cities = getCities();
		Optional<City> cityOptional = cities.stream().filter(e-> e.getCity().equals(city.getCity())).findAny();
		if(cityOptional.isPresent()) {
			throw new CityAlreadyExistException();
		}
		return cityRepository.save(city);
	}

	

	@Override
	public List<City> getCities() {
		List<City> cities = cityRepository.findAll();
		return cities;
	}



	@Override
	public City updateStatus(String status, long cityId) throws CityNotPresentException {
		City city = getCityById(cityId);
		city.setStatus(status);
		cityRepository.save(city);
		return city;
	}



	@Override
	public City getCityById(long cityId) throws CityNotPresentException {
		Optional<City> cityOptional = cityRepository.findById(cityId);
		if(!cityOptional.isPresent())
		{
			throw new CityNotPresentException();
		}
		return cityOptional.get();
	}



	@Override
	public void deleteCity(long cityId) throws CityNotPresentException {
		cityRepository.delete(getCityById(cityId));
	}

}
