package com.lysine.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ConditionalOnProperty(
    prefix = "common.logging",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true)
public class CommonLibraryAutoConfiguration implements ApplicationListener<ApplicationReadyEvent> {
  private static final Logger log = LoggerFactory.getLogger(CommonLibraryAutoConfiguration.class);

  private final Environment env;
  private final ObjectProvider<RequestMappingHandlerMapping> mappingProvider;

  public CommonLibraryAutoConfiguration(
      Environment env, ObjectProvider<RequestMappingHandlerMapping> mappingProvider) {
    this.env = env;
    this.mappingProvider = mappingProvider;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    String host = env.getProperty("server.address", "localhost");
    String port = env.getProperty("server.port", "8080");
    String context = env.getProperty("server.servlet.context-path", "");

    if (!context.isEmpty() && context.startsWith("/")) {
      context = context.replaceAll("/$", "");
    }

    log.info("===== Application ready =====");
    log.info("Service base URL: http://{}:{}{}", host, port, context);
    log.info("Swagger UI: http://{}:{}{}/swagger-ui/index.html", host, port, context);
    log.info("OpenAPI docs: http://{}:{}{}/v3/api-docs", host, port, context);

    RequestMappingHandlerMapping mapping = mappingProvider.getIfAvailable();
    if (mapping != null) {
      log.info("Registered REST endpoints:");
      mapping
          .getHandlerMethods()
          .forEach(
              (key, value) ->
                  log.info(
                      "{} -> {}#{}",
                      key.getMethodsCondition(),
                      key.getPatternsCondition(),
                      value.getMethod().getName()));
    } else {
      log.info("RequestMappingHandlerMapping not available (non-web application?).");
    }
  }
}
