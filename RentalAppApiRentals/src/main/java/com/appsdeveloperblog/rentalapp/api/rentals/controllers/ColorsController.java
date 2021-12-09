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

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.ColorService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.CreateColorRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.DeleteColorRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.UpdateColorRequestModel;

@RestController
@RequestMapping("/colors")
public class ColorsController {

	ColorService colorService;
	private Environment environment;
	
	@Autowired
	public ColorsController(ColorService colorService, Environment environment) {
		this.colorService = colorService;
		this.environment = environment;
	}
	
	@GetMapping("status/check")
	public String status() {
		return "working on : " + environment.getProperty("local.server.port");
	}
	
	@GetMapping("getAll")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateColorRequestModel createColorRequestModel) {
		return this.colorService.add(createColorRequestModel);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateColorRequestModel updateColorRequestModel) {
		return this.colorService.update(updateColorRequestModel);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteColorRequestModel deleteColorRequestModel) {
		return this.colorService.delete(deleteColorRequestModel);
	}

}
