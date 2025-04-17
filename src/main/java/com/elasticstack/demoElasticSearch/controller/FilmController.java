package com.elasticstack.demoElasticSearch.controller;

import com.elasticstack.demoElasticSearch.elasticsearch.document.FilmDoc;
import com.elasticstack.demoElasticSearch.service.FilmDocService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/films")
public class FilmController {

    private FilmDocService filmDocService;

    @GetMapping("/index/firstTime")
    public ResponseEntity<String> createIndexFirstTime(){
        return new ResponseEntity<>(filmDocService.createIndexFirstTime(), HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<FilmDoc> createFilm(@RequestBody FilmDoc filmDoc) {
        return new ResponseEntity<>(filmDocService.save(filmDoc), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<FilmDoc>> findAll() {
        return new ResponseEntity<>(filmDocService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<FilmDoc>> findFilm(@PathVariable String query) {
        return new ResponseEntity<>(filmDocService.findFilm(query), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDoc> updateFilm(@PathVariable String id, @RequestBody FilmDoc filmDoc) {
        return new ResponseEntity<>(filmDocService.update(id, filmDoc), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable String id) {
        filmDocService.delete(id);
    }
}
