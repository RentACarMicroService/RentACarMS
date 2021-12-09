package com.appsdeveloperblog.rentalapp.api.users.controllers;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.IndividualCustomerService;
import com.appsdeveloperblog.rentalapp.api.users.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.CreateIndividualCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.DeleteIndividualCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.UpdateIndividualCustomerRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/individualCustomers")
public class IndividualCustomersController {

    private IndividualCustomerService individualCustomerService;

    @Autowired
    public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
        super();
        this.individualCustomerService = individualCustomerService;
    }

    @GetMapping ("getAll")
    public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
        return this.individualCustomerService.getAll();
    }

    @PostMapping ("/save")
    public Result save(@RequestBody @Valid CreateIndividualCustomerRequestModel createIndividualCustomerRequestModel) {
        return this.individualCustomerService.save(createIndividualCustomerRequestModel);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequestModel deleteIndividualCustomerRequestModel) {
        return this.individualCustomerService.delete(deleteIndividualCustomerRequestModel);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateIndividualCustomerRequestModel updateIndividualCustomerRequestModel) {
        return this.individualCustomerService.update(updateIndividualCustomerRequestModel);
    }

    @GetMapping("/getByIndividualCustomerById")
    public DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerById(int id) {
        return this.individualCustomerService.getByIndividualCustomerId(id);
    }

}
