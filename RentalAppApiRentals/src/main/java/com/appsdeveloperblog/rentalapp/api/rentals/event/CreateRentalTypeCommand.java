package com.appsdeveloperblog.rentalapp.api.rentals.event;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateRentalTypeCommand {
    @TargetAggregateIdentifier
    private final String rentalTypeId;
    private final String rentalName;
    private final double price;
    private final String description;
}
