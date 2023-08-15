package com.apartmentmanagement.identity.service.impl;

import com.apartmentmanagement.identity.entity.RecoveryEntity;
import com.apartmentmanagement.identity.entity.UserEntity;
import com.apartmentmanagement.identity.exception.exceptions.UserExistException;
import com.apartmentmanagement.identity.model.Recovery;
import com.apartmentmanagement.identity.model.User;
import com.apartmentmanagement.identity.model.UserPassword;
import com.apartmentmanagement.identity.repository.IdentityRepository;
import com.apartmentmanagement.identity.repository.RecoveryRepository;
import com.apartmentmanagement.identity.service.IdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdentityServiceImpl implements IdentityService {

    private final IdentityRepository identityRepository;

    private final RecoveryRepository recoveryRepository;

    @Override
    public String createUser(User user) throws UserExistException{
        boolean isUserNameExists = identityRepository.existsByUserName(user.getUserName());
        boolean isUserEmailExists = identityRepository.existsByEmailId(user.getEmailId());
        if(isUserNameExists){
            throw new UserExistException("Username: "+user.getUserName()+" already exits!");
        }
        else if(isUserEmailExists) {
            throw new UserExistException("Email: " + user.getEmailId() + " already exits!");
        }
        else{
            RecoveryEntity recoveryEntity = RecoveryEntity.builder()
                    .question(user.getRecovery().getQuestion())
                    .answer(user.getRecovery().getAnswer())
                    .build();
            UserEntity userEntity = UserEntity.builder()
                    .userName(user.getUserName())
                    .emailId(user.getEmailId())
                    .password(user.getPassword())
                    .recoveryEntity(recoveryEntity)
                    .build();
            recoveryEntity.setUserEntity(userEntity);
            identityRepository.save(userEntity);
        }
        return "User has been created Username: "+user.getUserName()+" Email ID: "+user.getEmailId();
    }

    @Override
    public UserPassword retrieveCredentialsByUserName(String userName){
        UserEntity userEntity = identityRepository.findByUserName(userName);
        return UserPassword.builder()
                .userPassword(userEntity.getPassword())
                .build();
    }

    @Override
    public UserPassword retrieveCredentialsByEmailId(String emailId){
        UserEntity userEntity =  identityRepository.findByEmailId(emailId);
        return UserPassword.builder()
                .userPassword(userEntity.getPassword())
                .build();
    }

    @Override
    public String updateRecovery(String email, Recovery recovery){
        UserEntity userEntity = identityRepository.findByEmailId(email);
        RecoveryEntity recoveryEntity = RecoveryEntity.builder()
                .question(recovery.getQuestion())
                .answer(recovery.getAnswer())
                .build();
        userEntity.setRecoveryEntity(recoveryEntity);
        recoveryEntity.setUserEntity(userEntity);
        identityRepository.save(userEntity);
        return "Recovery has been updated";
    }

    @Override
    public String deleteUser(String email){
        UserEntity userEntity = identityRepository.findByEmailId(email);
        identityRepository.delete(userEntity);
        return "User has been deleted";
    }
}
