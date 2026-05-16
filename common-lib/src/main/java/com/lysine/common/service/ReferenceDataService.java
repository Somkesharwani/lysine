package com.lysine.common.service;

import com.lysine.api.UserServiceApiDelegate;
import com.lysine.model.AccountResponseDto;
import com.lysine.model.UserGroupResponseDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceDataService {

  private final UserServiceApiDelegate userServiceApiDelegate;

  public Optional<AccountResponseDto> resolveAccount(String accountId) {
    // In a real implementation, this would call an external service or database to get the account
    // details
    // For this example, we'll just return a dummy account response

    var account = userServiceApiDelegate.getAccountById(accountId);

    if (account.getStatusCode().is2xxSuccessful()) {
      return Optional.ofNullable(account.getBody());
    }

    return Optional.empty();
  }

  public Optional<UserGroupResponseDto> resolveUserGroup(String groupId) {
    // In a real implementation, this would call an external service or database to get the user
    // group details
    // For this example, we'll just return a dummy user group response

    var userGroup = userServiceApiDelegate.getUserGroupById(groupId);

    if (userGroup.getStatusCode().is2xxSuccessful()) {
      return Optional.ofNullable(userGroup.getBody());
    }

    return Optional.empty();
  }
}
