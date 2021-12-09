package com.appsdeveloperblog.rentalapp.api.users.business.abstracts;

import com.appsdeveloperblog.rentalapp.api.users.controllers.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.CreateIndividualCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.DeleteIndividualCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.UpdateIndividualCustomerRequestModel;

import java.util.List;

public interface IndividualCustomerService {
    DataResult<List<IndividualCustomerSearchListDto>> getAll();
    Result save(CreateIndividualCustomerRequestModel createIndividualCustomerRequestModel);
    Result update(UpdateIndividualCustomerRequestModel updateIndividualCustomerRequestModel);
    Result delete(DeleteIndividualCustomerRequestModel deleteIndividualCustomerRequestModel);
    DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerId(int id);
}
