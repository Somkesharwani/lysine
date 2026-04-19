package com.lysine.user.controller;

import com.lysine.api.UserServiceApi;
import com.lysine.user.model.Account;
import com.lysine.user.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements UserServiceApi {

  private final AccountService accountService;

  @GetMapping("/{id}")
  public Account getUser(@PathVariable String id) {
    return accountService.getUser(id);
  }

  @GetMapping("/{id}/manager")
  public Account getManager(@PathVariable String id) {
    return accountService.getManager(id);
  }

  @GetMapping
  public List<Account> getUsersByRole(@RequestParam String role, @RequestParam String companyId) {
    return accountService.getUsersByRole(role, companyId);
  }

  @GetMapping("/{id}/hierarchy")
  public Account getManagerAtLevel(@PathVariable String id, @RequestParam int level) {
    return accountService.getManagerAtLevel(id, level);
  }
}
