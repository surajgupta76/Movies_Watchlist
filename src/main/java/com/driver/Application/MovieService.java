package com.driver.Application;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class MovieService {
    @Autowired
    MovieRepository movierepository;
    public List<String> getallmovies(){
        return movierepository.getallmoviefromdb();
    }
    public void addmovietodb(Movie mv){
        movierepository.addmovieindb(mv);
    }
public void adddirectortodb(Director dr){
    movierepository.adddirectorindb(dr);
}
public void createmoviedirectorpair(String mv, String dr) {
    movierepository.storemoviedirectorpair(mv,dr);
}
public Movie getmovie(String moviesearch) {
    return movierepository.findmovieinrepo(moviesearch);
}
public Director getdirector(String dirsearch) {
    return movierepository.finddirectorinrepo(dirsearch);
}
public List<String> givemoviesbydirectorname(String searchmoviebydirector) {
    return movierepository.getmovielistbydirname(searchmoviebydirector);
}
public void deleteDirectorByName(String director) {
    movierepository.deldirectorbyname(director);
}
public void deleteAllDirectors() {
    movierepository.deleteAllDirectors();
}

    
}
