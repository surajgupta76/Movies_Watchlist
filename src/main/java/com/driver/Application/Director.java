package com.driver.Application;

public class Director{
    private String name;
    private int nomovies;
    private double imdbrating;

    public Director(){
        System.out.println("Director object created");
    }
    public Director(String name, int nomovies, double imdbrating){
        this.name = name;
        this.nomovies = nomovies;
        this.imdbrating = imdbrating;
    }
    public String getname(){
        return name;
    }
    public void setname(){
        this.name = name;
    }
    public int getnomovies(){
        return nomovies;
    }
    public void setnomovies(){
        this.nomovies = nomovies;
    }
    public double getrating(){
        return imdbrating;
    }
    public void setsetrating(){
        this.imdbrating = imdbrating;
    }

}
