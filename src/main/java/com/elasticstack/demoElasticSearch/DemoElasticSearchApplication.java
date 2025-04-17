package com.elasticstack.demoElasticSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.elasticstack.demoElasticSearch.repository")
public class DemoElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoElasticSearchApplication.class, args);
	}

}
