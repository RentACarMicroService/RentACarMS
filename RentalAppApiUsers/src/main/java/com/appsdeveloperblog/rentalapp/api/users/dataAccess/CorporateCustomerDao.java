package com.appsdeveloperblog.rentalapp.api.users.dataAccess;

import com.appsdeveloperblog.rentalapp.api.users.entities.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer, Integer> {
    boolean existsCorporateCustomerByCompanyName(String companyName);

}
