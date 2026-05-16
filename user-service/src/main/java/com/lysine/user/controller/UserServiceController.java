package com.lysine.user.controller;

import com.lysine.api.UserServiceApiDelegate;
import com.lysine.model.AccountCreateRequestDto;
import com.lysine.model.AccountResponseDto;
import com.lysine.model.UserGroupCreateRequestDto;
import com.lysine.model.UserGroupResponseDto;
import com.lysine.user.service.AccountServiceImpl;
import com.lysine.user.service.UserGroupService;
import com.lysine.user.service.mapper.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserServiceController implements UserServiceApiDelegate {

  private final AccountServiceImpl accountService;
  private final UserGroupService userGroupService;
  private final ServiceMapper serviceMapper;

  @Override
  public ResponseEntity<AccountResponseDto> createAccount(
      AccountCreateRequestDto accountCreateRequestDto) {
    return ResponseEntity.ok(
        serviceMapper.toAccountResponseDto(
            accountService.createAccount(serviceMapper.toEntity(accountCreateRequestDto))));
  }

  @Override
  public ResponseEntity<UserGroupResponseDto> createUserGroup(
      UserGroupCreateRequestDto userGroupCreateRequestDto) {
    var userGroup =
        userGroupService.createUserGroup(
            serviceMapper.toUserGroupEntity(userGroupCreateRequestDto));
    return ResponseEntity.ok(serviceMapper.toUserGroupDto(userGroup));
  }
}
