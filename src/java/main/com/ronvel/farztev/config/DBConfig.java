package com.ronvel.farztev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration of the database.
 * @author mronvel
 *
 */
@Configuration
@EnableJpaRepositories(value = "com.ronvel.farztev.dao")
@EnableTransactionManagement
public class DBConfig {

}
