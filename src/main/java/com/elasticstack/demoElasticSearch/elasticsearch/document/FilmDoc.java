package com.elasticstack.demoElasticSearch.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "film")
public class FilmDoc {

    @Id
    private String id;
    @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard")
    private String name;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String description;
}
