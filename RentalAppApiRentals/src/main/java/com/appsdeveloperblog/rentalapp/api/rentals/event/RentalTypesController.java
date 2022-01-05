package com.appsdeveloperblog.rentalapp.api.rentals.event;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/rentaltypes")
public class RentalTypesController {
    private CommandGateway commandGateway;

    @Autowired
    public RentalTypesController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createRentalType(@RequestBody CreateRentalTypeRestModel createRentalTypeRestModel) {

        //Rest modeli command'e çevir.
        //Axon cqrs bus ile yaşam döngüsüne sok.

        CreateRentalTypeCommand command =	CreateRentalTypeCommand.builder()
                .price(createRentalTypeRestModel.getPrice())
                .rentalName(createRentalTypeRestModel.getRentalName())
                .description(createRentalTypeRestModel.getDescription())
                .rentalTypeId(UUID.randomUUID().toString())
                .build();

        String returnValue = this.commandGateway.sendAndWait(command);
        //Find Command Handler and run it

        return returnValue;
    }

    @PutMapping
    public String updateRentalType() {
        return "Http put handler";
    }

    @DeleteMapping
    public String deleteRentalType() {
        return "Http delete handler";
    }

    @GetMapping
    public String listRentalType() {
        return "Http get handler";
    }
}
