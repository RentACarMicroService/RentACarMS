package com.appsdeveloperblog.rentalapp.api.rentals.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.CarService;
import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.SuccessDataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.SuccessResult;
import com.appsdeveloperblog.rentalapp.api.rentals.dataAccess.CarRepository;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Car;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;

@Service
public class CarManager implements CarService {

	private ModelMapperService modelMapperService;
	private CarRepository carRepository;

	@Autowired
	public CarManager(ModelMapperService modelMapperService, CarRepository carRepository) {
		this.modelMapperService = modelMapperService;
		this.carRepository = carRepository;
	}

	@Override
	public DataResult<List<CarDto>> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<CarDto> response = cars.stream().map(car -> modelMapperService.forDto().map(car, CarDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarDto>>(response);
	}

	@Override
	public Result add(CreateCarRequestModel createCarRequestModel) {
		Car car = modelMapperService.forRequest().map(createCarRequestModel, Car.class);
		this.carRepository.save(car);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateCarRequestModel updateCarRequestModel) {
		Car car = modelMapperService.forRequest().map(updateCarRequestModel, Car.class);
		this.carRepository.save(car);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteCarRequestModel deleteCarRequestModel) {
		Car car = modelMapperService.forRequest().map(deleteCarRequestModel, Car.class);
		this.carRepository.delete(car);
		return new SuccessResult();

	}

}
