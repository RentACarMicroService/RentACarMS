package com.appsdeveloperblog.rentalapp.api.rentals.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{

}
