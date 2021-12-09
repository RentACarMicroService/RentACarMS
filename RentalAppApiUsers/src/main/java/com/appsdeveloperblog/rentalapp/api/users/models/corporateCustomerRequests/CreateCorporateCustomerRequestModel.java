package com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequestModel {
    @NotNull
    private String companyName;
    @NotNull
    private String taxNumber;
    @Email
    private String email;
    @NotNull
    private String password;

    @JsonIgnore
    private String encryptedPassword;
}
