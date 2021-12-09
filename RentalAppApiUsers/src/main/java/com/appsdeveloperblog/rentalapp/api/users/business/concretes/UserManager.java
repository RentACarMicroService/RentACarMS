package com.appsdeveloperblog.rentalapp.api.users.business.concretes;

import com.appsdeveloperblog.rentalapp.api.users.business.abstracts.UserService;
import com.appsdeveloperblog.rentalapp.api.users.business.dtos.UserSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.mapping.ModelMapperService;
import com.appsdeveloperblog.rentalapp.api.users.core.utilities.results.*;
import com.appsdeveloperblog.rentalapp.api.users.dataAccess.UserDao;
import com.appsdeveloperblog.rentalapp.api.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DataResult<UserSearchListDto> getByEmail(String email) {
        User user = this.userDao.getByEmail(email);
        UserSearchListDto userSearchListDto = modelMapperService.forDto().map(user, UserSearchListDto.class);
        return new SuccessDataResult<UserSearchListDto>(userSearchListDto);
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
        User user = this.userDao.getById(id);
        UserSearchListDto userSearchListDto = modelMapperService.forDto().map(user, UserSearchListDto.class);
        return new SuccessDataResult<UserSearchListDto>(userSearchListDto);
    }

    @Override
    public Result checkIfUserExists(int userId) {
        if (!this.userDao.existsById(userId)) {
            return new ErrorResult("User is not found");
        }
        return new SuccessResult();
    }
}
