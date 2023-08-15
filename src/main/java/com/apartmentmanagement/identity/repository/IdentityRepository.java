package com.apartmentmanagement.identity.repository;

import com.apartmentmanagement.identity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface IdentityRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUserName(String userName);
    boolean existsByEmailId(String emailId);
    UserEntity findByUserName(String userName);
    UserEntity findByEmailId(String emailId);
}
