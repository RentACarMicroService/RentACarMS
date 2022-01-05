package com.appsdeveloperblog.rentalapp.api.rentals.event;

import lombok.Data;

@Data
public class CreateRentalTypeRestModel {
    private  String rentalName;
    private  double price;
    private  String description;
}
