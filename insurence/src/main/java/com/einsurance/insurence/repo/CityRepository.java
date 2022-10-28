package com.einsurance.insurence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.einsurance.insurence.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
