package com.appsdeveloperblog.rentalapp.api.rentals.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorDto {
	
	private int colorId;
	private String colorName;
}
