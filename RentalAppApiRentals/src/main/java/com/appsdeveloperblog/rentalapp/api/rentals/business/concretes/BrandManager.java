package com.appsdeveloperblog.rentalapp.api.rentals.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.BrandService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.SuccessDataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.SuccessResult;
import com.appsdeveloperblog.rentalapp.api.rentals.dataAccess.BrandRepository;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Car;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.CreateBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.DeleteBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.UpdateBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;

@Service
public class BrandManager implements BrandService {

	private ModelMapperService modelMapperService;
	private BrandRepository brandRepository;

	@Autowired
	public BrandManager(ModelMapperService modelMapperService, BrandRepository brandRepository) {
		this.modelMapperService = modelMapperService;
		this.brandRepository = brandRepository;
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(this.brandRepository.findAll());
	}

	@Override
	public Result add(CreateBrandRequestModel createBrandRequestModel) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequestModel, Brand.class);
		this.brandRepository.save(brand);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateBrandRequestModel updateBrandRequestModel) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequestModel, Brand.class);
		this.brandRepository.save(brand);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteBrandRequestModel deleteBrandRequestModel) {
		Brand brand = modelMapperService.forRequest().map(deleteBrandRequestModel, Brand.class);
		this.brandRepository.delete(brand);
		return new SuccessResult();
	}

}
