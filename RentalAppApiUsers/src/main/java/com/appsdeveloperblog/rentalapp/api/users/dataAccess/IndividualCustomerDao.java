package com.appsdeveloperblog.rentalapp.api.users.dataAccess;

import com.appsdeveloperblog.rentalapp.api.users.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, Integer> {

}
