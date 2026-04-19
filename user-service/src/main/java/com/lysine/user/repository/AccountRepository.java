package com.lysine.user.repository;

import com.lysine.user.model.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository
    extends JpaRepository<Account, String>, RevisionRepository<Account, String, Integer> {

  /** Find account by employee ID */
  Optional<Account> findByEmpId(String empId);

  /** Find account by email */
  Optional<Account> findByEmail(String email);

  /** Find all accounts by user group ID */
  List<Account> findByCompanyId(String companyId);

  /** Find all accounts managed by a specific manager */
  List<Account> findByManagerId(String managerId);

  /** Check if email already exists */
  boolean existsByEmail(String email);

  /** Check if employee ID already exists */
  boolean existsByEmpId(String empId);

  List<Account> findByUserGroupId(String companyId);

  List<Account> findByRoleAndUserGroupId(String role, String companyId);
}
