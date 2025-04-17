package com.elasticstack.demoElasticSearch.elasticsearch.repository;

import com.elasticstack.demoElasticSearch.elasticsearch.document.FilmDoc;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDocRepository extends ElasticsearchRepository<FilmDoc, String> {

    List<FilmDoc> findByName(String name);

    @Query("{'bool': {'must': [{'match': {'name': '?0'}}]}}")
    List<FilmDoc> findByNameUsingCustomQuery(String name);

    @Query("{\"bool\": {\"should\": [" +
            "{\"match\": {\"name\": \"?0\"}}," +
            "{\"match\": {\"description\": \"?0\"}}" +
            "]}}")
    List<FilmDoc> findFilm(String name, String description);

}
