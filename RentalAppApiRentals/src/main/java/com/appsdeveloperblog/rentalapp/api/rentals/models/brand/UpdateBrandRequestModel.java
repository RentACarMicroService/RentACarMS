package com.appsdeveloperblog.rentalapp.api.rentals.models.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequestModel {

	private int brandId;
	private String brandName;
}
