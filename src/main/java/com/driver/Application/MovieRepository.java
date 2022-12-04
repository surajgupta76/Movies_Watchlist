package com.driver.Application;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.*;

@Component
@Repository
public class MovieRepository {
    Map<String,Movie> movies = new HashMap<>();
    Map<String,Director> directormap = new HashMap<>();
    Map<String,List<String>> moviedirectormap = new HashMap<>();

    public void addmovieindb(Movie mv){
        movies.put(mv.getname(),mv);
    }
    public List<String> getallmoviefromdb(){
        return new ArrayList<>(movies.keySet());
    }
    public void  adddirectorindb(Director dr){
        directormap.put(dr.getname(),dr);
    }
    public void storemoviedirectorpair(String mv, String dr) {
        if(movies.containsKey(mv) && directormap.containsKey(dr)){
            List<String> selectedmovies = new ArrayList<>();
            if(moviedirectormap.containsKey(dr)){
                selectedmovies.add(mv);
            }
            moviedirectormap.put(dr,selectedmovies);
        }
    }
    public Movie findmovieinrepo(String moviesearch) {
        return movies.get(moviesearch);
    }
    public Director finddirectorinrepo(String dirsearch) {
        return directormap.get(dirsearch);
    }
    public List<String> getmovielistbydirname(String searchmoviebydirector) {
        List<String> mvlist = new ArrayList<>();
        if(moviedirectormap.containsKey(searchmoviebydirector)){
            mvlist  = moviedirectormap.get(searchmoviebydirector);
        }
        return mvlist;
    }
    public void deldirectorbyname(String director) {
        List<String> dirmovies = new ArrayList<>();
        if(moviedirectormap.containsKey(director)){
            dirmovies = moviedirectormap.get(director);
            for(String s: dirmovies){
                if(movies.containsKey(s)){
                    movies.remove(s);
                }
            }
            moviedirectormap.remove(director);
        }
        if(directormap.containsKey(director)){
            directormap.remove(director);
        }
    }
    public void deleteAllDirectors() {
        HashSet<String> movieset = new HashSet<>();
        for(String director:moviedirectormap.keySet()){
            for(String movie : moviedirectormap.get(director)){
                movieset.add(movie);
            }
        }
        for(String movie:movieset){
            if(movies.containsKey(movie)){
                movies.remove(movie);
            }
        }
    }


}
