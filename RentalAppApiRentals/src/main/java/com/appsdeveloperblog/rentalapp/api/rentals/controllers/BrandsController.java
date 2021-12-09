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

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.BrandService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.BrandDto;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.CreateBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.DeleteBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.UpdateBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;

@RestController
@RequestMapping("/brands")
public class BrandsController {

	BrandService brandService;
	private Environment environment;

	@Autowired
	public BrandsController(BrandService brandService, Environment environment) {
		this.brandService = brandService;
		this.environment = environment;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Brand>> getAll() {
		return this.brandService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateBrandRequestModel createBrandRequestModel ) {
		return this.brandService.add(createBrandRequestModel);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateBrandRequestModel updateBrandRequestModel) {
		return this.brandService.update(updateBrandRequestModel);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteBrandRequestModel deleteBrandRequestModel) {
		return this.brandService.delete(deleteBrandRequestModel);
	}
}
