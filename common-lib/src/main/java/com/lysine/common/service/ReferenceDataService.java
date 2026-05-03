package com.lysine.common.service;

import com.lysine.api.UserServiceApiDelegate;
import com.lysine.model.AccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReferenceDataService {

    private final UserServiceApiDelegate userServiceApiDelegate;

   public Optional<AccountResponseDto> resolveAccount(String accountId) {
        // In a real implementation, this would call an external service or database to get the account details
        // For this example, we'll just return a dummy account response

       var account =  userServiceApiDelegate.getAccountById(accountId);

       if (account.getStatusCode().is2xxSuccessful()) {
           return Optional.ofNullable(account.getBody());
       }

       return Optional.empty();
   }

}
