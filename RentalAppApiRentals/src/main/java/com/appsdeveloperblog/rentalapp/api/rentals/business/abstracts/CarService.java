package com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentalapp.api.rentals.business.dtos.CarDto;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.CreateCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;

public interface CarService {
	DataResult<List<CarDto>> getAll();
	Result add(CreateCarRequestModel createCarRequestModel);
	Result update(UpdateCarRequestModel updateCarRequestModel);
	Result delete(DeleteCarRequestModel deleteCarRequestModel);
}
