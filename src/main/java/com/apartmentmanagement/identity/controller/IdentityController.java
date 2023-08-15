package com.apartmentmanagement.identity.controller;

import com.apartmentmanagement.identity.model.Recovery;
import com.apartmentmanagement.identity.model.User;
import com.apartmentmanagement.identity.model.UserPassword;
import com.apartmentmanagement.identity.service.IdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identity/v1/")
@RequiredArgsConstructor
public class IdentityController {
    private final IdentityService identityService;

    @RequestMapping(value = "user/", method = RequestMethod.POST)
    public String  addUser(@RequestBody User user){
        return identityService.createUser(user);
    }

    @RequestMapping(value = "credentials/username/", method = RequestMethod.GET)
    public ResponseEntity<UserPassword> retrieveCredentialsByUserName(@RequestBody String userName){
        return new ResponseEntity<>(identityService.retrieveCredentialsByUserName(userName),HttpStatus.OK);
    }

    @RequestMapping(value = "credentials/email/", method = RequestMethod.GET)
    public ResponseEntity<UserPassword> retrieveCredentialsByEmailId(@RequestBody String emailId){
        return new ResponseEntity<>(identityService.retrieveCredentialsByUserName(emailId),HttpStatus.OK);
    }

    @RequestMapping(value = "recovery/", method = RequestMethod.PUT)
    public String updateRecovery(@RequestBody String email, @RequestBody Recovery recovery){
        return identityService.updateRecovery(email, recovery);
    }

    @RequestMapping(value = "user/purge", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestBody String email){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(identityService.deleteUser(email));
    }
}
