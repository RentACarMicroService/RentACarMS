package com.appsdeveloperblog.rentalapp.api.users.business.concretes;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.CorporateCustomerService;
import com.appsdeveloperblog.rentalapp.api.users.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.DataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.Result;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.SuccessDataResult;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.SuccessResult;
import com.appsdeveloperblog.rentalapp.api.users.dataAccess.CorporateCustomerDao;
import com.appsdeveloperblog.rentalapp.api.users.entities.CorporateCustomer;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.CreateCorporateCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.DeleteCorporateCustomerRequestModel;
import com.appsdeveloperblog.rentalapp.api.users.models.corporateCustomerRequests.UpdateCorporateCustomerRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {

    private CorporateCustomerDao corporateCustomerDao;
    private ModelMapperService modelMapperService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CorporateCustomerManager(CorporateCustomerDao corporateCustomerDao,
                                    ModelMapperService modelMapperService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.corporateCustomerDao = corporateCustomerDao;
        this.modelMapperService = modelMapperService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public DataResult<List<CorporateCustomerSearchListDto>> getAll() {
        List<CorporateCustomer> result = this.corporateCustomerDao.findAll();
        List<CorporateCustomerSearchListDto> response = result.stream()
                .map(corporateCustomer -> modelMapperService.forDto()
                        .map(corporateCustomer, CorporateCustomerSearchListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CorporateCustomerSearchListDto>>(response);
    }

    @Override
    public Result save(CreateCorporateCustomerRequestModel createCorporateCustomerRequestModel) {
        createCorporateCustomerRequestModel.setEncryptedPassword(this.bCryptPasswordEncoder.encode(createCorporateCustomerRequestModel.getPassword()));
        CorporateCustomer result = modelMapperService.forRequest().map(createCorporateCustomerRequestModel, CorporateCustomer.class);
        this.corporateCustomerDao.save(result);
        return new SuccessResult("Corporate customer added");
    }

    @Override
    public Result update(UpdateCorporateCustomerRequestModel updateCorporateCustomerRequestModel) {
        updateCorporateCustomerRequestModel.setEncryptedPassword(this.bCryptPasswordEncoder.encode(updateCorporateCustomerRequestModel.getPassword()));
        CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(updateCorporateCustomerRequestModel, CorporateCustomer.class);
        this.corporateCustomerDao.save(corporateCustomer);
        return new SuccessResult("Corporate customer updated");
    }

    @Override
    public Result delete(DeleteCorporateCustomerRequestModel deleteCorporateCustomerRequestModel) {
        CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(deleteCorporateCustomerRequestModel, CorporateCustomer.class);
        this.corporateCustomerDao.delete(corporateCustomer);
        return new SuccessResult("Corporate customer deleted");
    }

    @Override
    public DataResult<CorporateCustomerSearchListDto> getById(int id) {
        CorporateCustomer corporateCustomer = this.corporateCustomerDao.getById(id);
        CorporateCustomerSearchListDto corporateCustomerSearchListDto = modelMapperService.forDto().map(corporateCustomer, CorporateCustomerSearchListDto.class);
        return new SuccessDataResult<CorporateCustomerSearchListDto>(corporateCustomerSearchListDto);
    }
}
