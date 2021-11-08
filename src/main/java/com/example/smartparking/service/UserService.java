package com.example.smartparking.service;

import com.example.smartparking.model.service.UserRegistrationServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);

}
