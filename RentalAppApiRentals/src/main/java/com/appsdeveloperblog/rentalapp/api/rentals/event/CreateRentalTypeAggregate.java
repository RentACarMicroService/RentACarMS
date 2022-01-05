package com.appsdeveloperblog.rentalapp.api.rentals.event;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateRentalTypeAggregate {

    @AggregateIdentifier
    private  String rentalTypeId;
    private  String rentalName;
    private  double price;
    private  String description;

    public CreateRentalTypeAggregate(){

    }

    @CommandHandler
    public CreateRentalTypeAggregate(CreateRentalTypeCommand createRentalTypeCommand) {
        //Validation
        if(createRentalTypeCommand.getPrice()<0) {
            throw new IllegalArgumentException("Fiyat sıfırdan küçük olamaz.");
        }
        //Business

        //Event fire
        RentalTypeCreatedEvent rentalTypeCreatedEvent = new RentalTypeCreatedEvent();
        //model mapper, builder, bean utils alternatifleri kullanılabilir
        BeanUtils.copyProperties(createRentalTypeCommand, rentalTypeCreatedEvent);

        AggregateLifecycle.apply(rentalTypeCreatedEvent);

    }

    @EventSourcingHandler
    public void on(RentalTypeCreatedEvent rentalTypeCreatedEvent) {
        this.rentalTypeId = rentalTypeCreatedEvent.getRentalTypeId();
        this.rentalName = rentalTypeCreatedEvent.getRentalName();
        this.description = rentalTypeCreatedEvent.getDescription();
        this.price = rentalTypeCreatedEvent.getPrice();
    }

}
