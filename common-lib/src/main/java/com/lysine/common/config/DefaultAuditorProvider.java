package com.lysine.common.config;

import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingBean(AuditorAware.class)
public class DefaultAuditorProvider implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("SYSTEM");
  }
}
