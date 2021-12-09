package com.appsdeveloperblog.rentalapp.api.rentals.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentalapp.api.rentals.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
