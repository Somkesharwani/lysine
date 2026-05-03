package com.lysine.user.service;

import com.lysine.user.model.UserGroup;
import com.lysine.user.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGroupService {

  private final UserGroupRepository repository;

  public UserGroup getById(String id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
  }

  public UserGroup createUserGroup(UserGroup userGroup) {
    return repository.save(userGroup);
  }
}
