package com.appsdeveloperblog.rentalapp.api.users.controllers;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.CorporateCustomerService;
import com.appsdeveloperblog.rentalapp.api.users.controllers.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.CreateCorporateCustomerRequestModel;

import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.DeleteCorporateCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.UpdateCorporateCustomerRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/corporateCustomers")
public class CorporateCustomersController {

    private CorporateCustomerService corporateCustomerService;

    @Autowired
    public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
        super();
        this.corporateCustomerService = corporateCustomerService;
    }
    @GetMapping("/getAll")
    public DataResult<List<CorporateCustomerSearchListDto>> getAll() {
        return this.corporateCustomerService.getAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody @Valid CreateCorporateCustomerRequestModel createCorporateCustomerRequestModel) {
        return this.corporateCustomerService.save(createCorporateCustomerRequestModel);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateCorporateCustomerRequestModel updateCorporateCustomerRequestModel) {
        return this.corporateCustomerService.update(updateCorporateCustomerRequestModel);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCorporateCustomerRequestModel deleteCorporateCustomerRequestModel){
        return this.corporateCustomerService.delete(deleteCorporateCustomerRequestModel);
    }

    @GetMapping("/getByCorporateCustomerById")
    public DataResult<CorporateCustomerSearchListDto> getById(int id){
        return this.corporateCustomerService.getById(id);
    }

}
