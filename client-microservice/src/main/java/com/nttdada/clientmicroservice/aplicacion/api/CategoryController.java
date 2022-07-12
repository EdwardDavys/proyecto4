package com.nttdada.clientmicroservice.aplicacion.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este es la clase controladora de Category.
 *
 *
 */
@RestController
@RequestMapping("/api/categories")
@Getter
@Setter
@RefreshScope
public class CategoryController {

  @Value("${app.testClient}")
  private String testClient;


  @GetMapping("/test-client")
  public String getTestlient() {
    return this.testClient;
  }
}
