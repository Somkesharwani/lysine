package com.lysine.reimbursement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ReimbursementServiceApplication {

  private static final Logger log = LoggerFactory.getLogger(ReimbursementServiceApplication.class);

  private final Environment env;

  public ReimbursementServiceApplication(Environment env) {
    this.env = env;
  }

  public static void main(String[] args) {
    SpringApplication.run(ReimbursementServiceApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onStartup() throws Exception {
    String host = "localhost";
    String port = env.getProperty("server.port", "8080");
    String context = env.getProperty("server.servlet.context-path", "");

    log.info("Application started at: http://{}:{}{}", host, port, context);
    log.info("Swagger UI: http://{}:{}{}/swagger-ui/index.html", host, port, context);
    log.info("OpenAPI JSON: http://{}:{}{}/v3/api-docs", host, port, context);
  }
}
