package com.elasticstack.demoElasticSearch.service;

import com.elasticstack.demoElasticSearch.elasticsearch.document.FilmDoc;
import com.elasticstack.demoElasticSearch.elasticsearch.repository.FilmDocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class FilmDocService {

    private FilmDocRepository filmDocRepository;
    private FilmService filmService;

    public FilmDoc save(FilmDoc filmDoc) {
        return filmDocRepository.save(filmDoc);
    }

    public List<FilmDoc> findAll() {
        List<FilmDoc> filmDocList = new ArrayList<>();
        StreamSupport.stream(filmDocRepository.findAll().spliterator(), false).forEach(filmDocList::add);
        return filmDocList;
    }

    public List<FilmDoc> findFilm(String query){
        return filmDocRepository.findFilm(query, query);
    }

    public FilmDoc update(String id, FilmDoc uptadedFilmDoc) {
        FilmDoc filmDoc = filmDocRepository.findById(id).orElseThrow(() -> new RuntimeException("This Film doesn't exist!!"));
        filmDoc.setName(uptadedFilmDoc.getName());
        filmDoc.setDescription(uptadedFilmDoc.getDescription());
        return filmDocRepository.save(filmDoc);
    }

    public void delete(String id) {
        filmDocRepository.deleteById(id);
    }

    public String createIndexFirstTime(){
        filmService.getAllFilms().parallelStream().forEach(film -> {
            FilmDoc filmDoc = new FilmDoc();
            filmDoc.setName(film.getTitle());
            filmDoc.setDescription(film.getDescription());
            save(filmDoc);
        });
        return "Done";
    }
}
