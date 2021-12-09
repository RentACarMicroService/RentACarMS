package com.appsdeveloperblog.rentalapp.api.rentals.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentalapp.api.rentals.business.abstracts.ColorService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.SuccessDataResult;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.results.SuccessResult;
import com.appsdeveloperblog.rentalapp.api.rentals.dataAccess.ColorRepository;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Brand;
import com.appsdeveloperblog.rentalapp.api.rentals.entities.Color;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.CreateColorRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.DeleteColorRequestModel;
import com.appsdeveloperblog.rentalapp.api.rentals.models.color.UpdateColorRequestModel;

@Service
public class ColorManager implements ColorService {

	private ColorRepository colorRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorRepository colorRepository, ModelMapperService modelMapperService) {
		this.colorRepository = colorRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorRepository.findAll());
	}

	@Override
	public Result add(CreateColorRequestModel createColorRequestModel) {
		Color color = modelMapperService.forRequest().map(createColorRequestModel, Color.class);
		this.colorRepository.save(color);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateColorRequestModel updateColorRequestModel) {
		Color color = modelMapperService.forRequest().map(updateColorRequestModel, Color.class);
		this.colorRepository.save(color);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteColorRequestModel deleteColorRequestModel) {
		Color color = modelMapperService.forRequest().map(deleteColorRequestModel, Color.class);
		this.colorRepository.delete(color);
		return new SuccessResult();
	}

}
