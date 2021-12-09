package com.appsdeveloperblog.rentalapp.api.users.business.abstracts;

import com.appsdeveloperblog.rentalapp.api.users.controllers.dtos.UserSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;

public interface UserService {

    DataResult<UserSearchListDto> getByEmail(String email);
    Result checkIfEmailExists(String email);
    DataResult<UserSearchListDto> getById(int id);
    Result checkIfUserExists(int userId);

}
