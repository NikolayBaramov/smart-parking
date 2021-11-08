package com.example.smartparking.service.impl;

import com.example.smartparking.model.entity.UserEntity;
import com.example.smartparking.model.entity.UserRoleEntity;
import com.example.smartparking.model.enums.UserRoleEnum;
import com.example.smartparking.model.service.UserRegistrationServiceModel;
import com.example.smartparking.repository.UserRepository;
import com.example.smartparking.repository.UserRoleRepository;
import com.example.smartparking.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeRoles() {
        if (userRoleRepository.count() != 0) {
            return;
        }
        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);

        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole, userRole));
    }

    private void initializeUsers() {
        if (userRepository.count() != 0) {
            return;
        }
        UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        UserEntity admin = new UserEntity();
        admin
                .setUsername("admin")
                .setFirstName("Admincho")
                .setLastName("Adminchev")
                .setEmail("admin@mail.com")
                .setAge(33)
                .setPassword(passwordEncoder.encode("1234"));

        admin.setRoles(Set.of(adminRole, userRole));
        userRepository.save(admin);

        UserEntity stamat = new UserEntity();
        stamat
                .setUsername("stamat")
                .setFirstName("Stamat")
                .setLastName("Stamatov")
                .setEmail("stamat@mail.com")
                .setAge(21)
                .setPassword(passwordEncoder.encode("1234"));

        stamat.setRoles(Set.of(userRole));
        userRepository.save(stamat);

    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {

    }

    @Override
    public boolean isUserNameFree(String username) {
        return false;
    }
}
