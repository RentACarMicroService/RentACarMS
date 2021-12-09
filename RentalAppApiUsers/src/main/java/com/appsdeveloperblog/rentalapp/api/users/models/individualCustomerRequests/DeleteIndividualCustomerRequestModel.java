package com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteIndividualCustomerRequestModel {
    @NotNull
    private int id;
}
