package com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCorporateCustomerRequestModel {

    @NotNull
    private int id;
}
