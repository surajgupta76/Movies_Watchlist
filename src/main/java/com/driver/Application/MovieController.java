package com.driver.Application;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import jakarta.websocket.server.PathParam;

@RestController
public class MovieController {
    
    @Autowired
    MovieService movieservice;
    // 1
    @PostMapping("/movies/add-movie")
    public ResponseEntity addmovie(@RequestBody(required = true)Movie mv){
        movieservice.addmovietodb(mv);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }
    // 2
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody(required = true)Director dr){
        movieservice.adddirectortodb(dr);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }
    // 3
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String mv,@RequestParam("director") String dr){
     movieservice.createmoviedirectorpair(mv,dr);
     return new ResponseEntity("Success",HttpStatus.CREATED);  
    }
    // 4
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String moviesearch){
        Movie movie =  movieservice.getmovie(moviesearch);
        return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
    }
    // 5
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String dirsearch){
        Director director =  movieservice.getdirector(dirsearch);
        return new ResponseEntity<>(director,HttpStatus.ACCEPTED);
    }
    // 6
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String searchmoviebydirector){
        List<String> ans = movieservice.givemoviesbydirectorname(searchmoviebydirector);
        return new ResponseEntity<List<String>>(ans,HttpStatus.ACCEPTED);
    }
    // 7
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> getmovies(){
        return new ResponseEntity(movieservice.getallmovies(),HttpStatus.ACCEPTED);
    }
    // 8
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director")String director){
        movieservice.deleteDirectorByName(director);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }
    // 9
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieservice.deleteAllDirectors();
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }
        
}
