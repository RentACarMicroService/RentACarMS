package com.appsdeveloperblog.rentalapp.api.users.models.loginRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestModel {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
