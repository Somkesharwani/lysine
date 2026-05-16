package com.lysine.user.service;

import com.lysine.user.model.Account;
import com.lysine.user.repository.AccountRepository;
import com.lysine.user.repository.UserGroupRepository;
import com.lysine.user.service.mapper.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl {

  private final AccountRepository accountRepository;
  private final UserGroupRepository userGroupRepository;
  private final ServiceMapper serviceMapper;

  public Account createAccount(Account account) {
    return accountRepository.save(account);
  }

  public Account getAccountById(String id) {
    return accountRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found"));
  }
}
