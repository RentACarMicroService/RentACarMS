package com.appsdeveloperblog.rentalapp.api.users.business.concretes;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.IndividualCustomerService;
import com.appsdeveloperblog.rentalapp.api.users.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.SuccessDataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.SuccessResult;
import com.appsdeveloperblog.rentalapp.api.users.dataAccess.IndividualCustomerDao;
import com.appsdeveloperblog.rentalapp.api.users.entities.IndividualCustomer;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.CreateIndividualCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.DeleteIndividualCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.individualCustomerRequests.UpdateIndividualCustomerRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

    private IndividualCustomerDao individualCustomerDao;
    private ModelMapperService modelMapperService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IndividualCustomerManager(IndividualCustomerDao individualCustomerDao,
                                      ModelMapperService modelMapperService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.individualCustomerDao = individualCustomerDao;
        this.modelMapperService = modelMapperService;
        this.bCryptPasswordEncoder= bCryptPasswordEncoder;
    }

    @Override
    public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
        List<IndividualCustomer> result = this.individualCustomerDao.findAll();
        List<IndividualCustomerSearchListDto> response = result.stream()
                .map(customerIndividual -> modelMapperService.forDto()
                        .map(customerIndividual, IndividualCustomerSearchListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<IndividualCustomerSearchListDto>>(response);
    }

    @Override
    public Result save(CreateIndividualCustomerRequestModel createIndividualCustomerRequestModel) {
        createIndividualCustomerRequestModel.setEncryptedPassword(this.bCryptPasswordEncoder.encode(createIndividualCustomerRequestModel.getPassword()));
        IndividualCustomer result = modelMapperService.forRequest().map(createIndividualCustomerRequestModel, IndividualCustomer.class);
        this.individualCustomerDao.save(result);
        return new SuccessResult("Individual customer added");
    }

    @Override
    public Result update(UpdateIndividualCustomerRequestModel updateIndividualCustomerRequestModel) {
        updateIndividualCustomerRequestModel.setEncryptedPassword(this.bCryptPasswordEncoder.encode(updateIndividualCustomerRequestModel.getPassword()));
        IndividualCustomer result = modelMapperService.forRequest().map(updateIndividualCustomerRequestModel, IndividualCustomer.class);
        this.individualCustomerDao.save(result);
        return new SuccessResult("Individual customer updated");
    }

    @Override
    public Result delete(DeleteIndividualCustomerRequestModel deleteIndividualCustomerRequestModel) {
        IndividualCustomer individualCustomerResult = modelMapperService.forRequest().map(deleteIndividualCustomerRequestModel, IndividualCustomer.class);
        this.individualCustomerDao.delete(individualCustomerResult);
        return new SuccessResult("Individual customer deleted");
    }

    @Override
    public DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerId(int id) {
        IndividualCustomer individualCustomer = this.individualCustomerDao.getById(id);
        IndividualCustomerSearchListDto individualCustomerSearchListDto = modelMapperService.forDto().map(individualCustomer, IndividualCustomerSearchListDto.class);
        return new SuccessDataResult<IndividualCustomerSearchListDto>(individualCustomerSearchListDto);
    }
}
