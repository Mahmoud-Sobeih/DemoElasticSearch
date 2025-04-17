package com.elasticstack.demoElasticSearch.service;

import com.elasticstack.demoElasticSearch.model.Film;
import com.elasticstack.demoElasticSearch.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {

    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
}
