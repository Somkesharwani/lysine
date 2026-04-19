package com.lysine.user.service;

import com.lysine.user.model.Account;
import java.util.List;

public interface AccountService {

  Account getUser(String userId);

  Account getManager(String userId);

  List<Account> getUsersByRole(String role, String companyId);

  Account getManagerAtLevel(String userId, int level);
}
