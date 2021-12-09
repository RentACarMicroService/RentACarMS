package com.appsdeveloperblog.rentalapp.api.rentals.models.car;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequestModel {

	@NotNull
	private int modelYear;

	@NotNull
	private int dailyPrice;

	@NotNull
	@Size(min = 2, max = 100)
	private String description;

	@NotNull
	private int colorId;

	@NotNull
	private int brandId;
}
