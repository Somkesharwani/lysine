package com.lysine.reimbursement.config;

import com.lysine.api.UserServiceApiDelegate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalDelegateConfig {

  @Bean
  @ConditionalOnMissingBean(UserServiceApiDelegate.class)
  public UserServiceApiDelegate userServiceApiDelegate() {
    return new UserServiceApiDelegate() {};
  }
}
