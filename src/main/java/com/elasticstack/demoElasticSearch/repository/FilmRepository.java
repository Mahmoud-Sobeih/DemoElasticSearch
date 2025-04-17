package com.elasticstack.demoElasticSearch.repository;

import com.elasticstack.demoElasticSearch.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
