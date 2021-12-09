package com.appsdeveloperblog.rentalapp.api.rentals.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.CarService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;

@RestController
@RequestMapping("/cars")
public class CarsController {

	CarService carService;
	private Environment environment;
	
	@Autowired
	public CarsController(CarService carService, Environment environment) {
		this.carService = carService;
		this.environment = environment;
	}
	
	@GetMapping("status/check")
	public String status() {
		return "working on : " + environment.getProperty("local.server.port");
	}
	
	@GetMapping("getAll")
	public DataResult<List<CarDto>> getAll() {
		return this.carService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCarRequestModel createCarRequestModel ) {
		return this.carService.add(createCarRequestModel);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateCarRequestModel updateCarRequestModel) {
		return this.carService.update(updateCarRequestModel);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteCarRequestModel deleteCarRequestModel) {
		return this.carService.delete(deleteCarRequestModel);
	}
	
}
