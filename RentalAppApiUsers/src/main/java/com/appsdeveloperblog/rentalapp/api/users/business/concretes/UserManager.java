package com.appsdeveloperblog.rentalapp.api.users.business.concretes;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.UserService;
import com.appsdeveloperblog.rentalapp.api.users.business.dtos.UserSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.*;
import com.appsdeveloperblog.rentalapp.api.users.dataAccess.UserDao;
import com.appsdeveloperblog.rentalapp.api.users.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public UserManager(UserDao userDao, ModelMapperService modelMapperService) {
        this.userDao = userDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public UserSearchListDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = this.userDao.findByEmail(email);
        if (userEntity == null)
        {
            throw new UsernameNotFoundException(email);
        }
        return new ModelMapper().map(userEntity, UserSearchListDto.class);
    }

    @Override
    public Result checkIfEmailExists(String email) {
        if (this.userDao.existsByEmail(email)) {
            return new ErrorResult("Email is already exists");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<UserSearchListDto> getById(int id) {
        UserEntity userEntity = this.userDao.getById(id);
        UserSearchListDto userSearchListDto = modelMapperService.forDto().map(userEntity, UserSearchListDto.class);
        return new SuccessDataResult<UserSearchListDto>(userSearchListDto);
    }

    @Override
    public Result checkIfUserExists(int userId) {
        if (!this.userDao.existsById(userId)) {
            return new ErrorResult("User is not found");
        }
        return new SuccessResult();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userDao.findByEmail(username);
        if (userEntity == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }
}
