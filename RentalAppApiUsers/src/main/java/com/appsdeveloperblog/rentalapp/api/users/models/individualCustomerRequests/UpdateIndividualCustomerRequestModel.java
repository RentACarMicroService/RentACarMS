package com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequestModel {
    @NotNull
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private LocalDate birthday;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @JsonIgnore
    private String encryptedPassword;
}
