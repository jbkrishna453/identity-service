package com.apartmentmanagement.identity.service;

import com.apartmentmanagement.identity.model.Recovery;
import com.apartmentmanagement.identity.model.User;
import com.apartmentmanagement.identity.model.UserPassword;

public interface IdentityService {
    String createUser(User user);
    UserPassword retrieveCredentialsByUserName(String userName);
    UserPassword retrieveCredentialsByEmailId(String emailId);
    String updateRecovery(String email, Recovery recovery);

    String deleteUser(String email);
}
