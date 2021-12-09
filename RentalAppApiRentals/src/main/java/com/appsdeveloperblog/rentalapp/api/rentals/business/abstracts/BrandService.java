package com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.CreateBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.DeleteBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.brand.UpdateBrandRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.DeleteCarRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.car.UpdateCarRequestModel;

public interface BrandService {
	DataResult<List<Brand>> getAll();
	Result add(CreateBrandRequestModel createBrandRequestModel);
	Result update(UpdateBrandRequestModel updateBrandRequestModel);
	Result delete(DeleteBrandRequestModel deleteBrandRequestModel);
}
