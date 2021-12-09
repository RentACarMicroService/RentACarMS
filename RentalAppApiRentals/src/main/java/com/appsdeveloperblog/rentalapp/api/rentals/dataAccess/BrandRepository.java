package com.appsdeveloperblog.rentalapp.api.rentals.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
