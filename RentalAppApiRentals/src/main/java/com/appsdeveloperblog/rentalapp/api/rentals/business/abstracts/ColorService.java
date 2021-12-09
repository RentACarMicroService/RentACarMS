package com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.CreateColorRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.DeleteColorRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.UpdateColorRequestModel;

public interface ColorService {
	DataResult<List<Color>> getAll();
	Result add(CreateColorRequestModel createColorRequestModel);
	Result update(UpdateColorRequestModel updateColorRequestModel);
	Result delete(DeleteColorRequestModel deleteColorRequestModel);
}
