package com.example.smartparking.repository;

import com.example.smartparking.model.entity.UserRoleEntity;
import com.example.smartparking.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByRole(UserRoleEnum role);

}
