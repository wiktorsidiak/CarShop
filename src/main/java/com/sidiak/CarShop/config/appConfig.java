package com.sidiak.CarShop.config;

import javax.validation.Constraint;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.sidiak.CarShop"})
@EnableJpaRepositories({"com.sidiak.CarShop"})
public class appConfig {
}
