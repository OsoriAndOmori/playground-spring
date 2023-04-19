package com.osori.mvc.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["com.osori.mvc.repository"])
@Configuration
class JpaConfig 