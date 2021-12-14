package com.appsdeveloperblog.rentalapp.api.users.dataAccess;

import com.appsdeveloperblog.rentalapp.api.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsById(int userId);

}
