package com.lysine.user.service;

import com.lysine.user.model.Account;
import com.lysine.user.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  public Account getUser(String userId) {
    return accountRepository
        .findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }

  @Override
  public Account getManager(String userId) {
    Account user = getUser(userId);

    if (user.getManager() == null) {
      throw new RuntimeException("Manager not assigned");
    }

    return user.getManager();
  }

  @Override
  public List<Account> getUsersByRole(String role, String companyId) {
    return accountRepository.findByRoleAndUserGroupId(role, companyId);
  }

  @Override
  public Account getManagerAtLevel(String userId, int level) {

    Account current = getUser(userId);

    for (int i = 0; i < level; i++) {
      if (current.getManager() == null) {
        throw new RuntimeException("Hierarchy broken");
      }
      current = current.getManager();
    }

    return current;
  }
}
