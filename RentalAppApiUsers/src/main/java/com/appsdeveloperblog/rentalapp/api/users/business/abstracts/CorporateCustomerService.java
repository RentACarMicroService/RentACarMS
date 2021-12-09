package com.appsdeveloperblog.rentalapp.api.users.business.abstracts;

import com.appsdeveloperblog.rentalapp.api.users.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.CreateCorporateCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.DeleteCorporateCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.UpdateCorporateCustomerRequestModel;

import java.util.List;

public interface CorporateCustomerService {
    DataResult<List<CorporateCustomerSearchListDto>> getAll();
    Result save(CreateCorporateCustomerRequestModel createCorporateCustomerRequestModel);
    Result update(UpdateCorporateCustomerRequestModel updateCorporateCustomerRequestModel);
    Result delete(DeleteCorporateCustomerRequestModel deleteCorporateCustomerRequestModel);
    DataResult<CorporateCustomerSearchListDto> getById(int id);
}
