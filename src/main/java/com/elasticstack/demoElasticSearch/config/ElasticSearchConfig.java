package com.elasticstack.demoElasticSearch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.elasticstack.demoElasticSearch.elasticsearch.repository")
public class ElasticSearchConfig{
}
