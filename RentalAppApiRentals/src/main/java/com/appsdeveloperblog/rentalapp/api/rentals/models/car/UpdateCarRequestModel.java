package com.appsdeveloperblog.rentalapp.api.rentals.models.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequestModel {
	private int carId;

    private int colorId;

    private int brandId;

    private int modelYear;

    private int dailyPrice;

    private String description;
}
