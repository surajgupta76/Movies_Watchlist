package com.driver.Application;

public class Movie {
    private String name;
    private int durinmin;
    private double imdbrating;

    public Movie(){
        System.out.println("Movie object created");
    }
    public Movie(String name, int durinmin, double imdbrating){
        this.name = name;
        this.durinmin = durinmin;
        this.imdbrating = imdbrating;
    }
    public String getname(){
        return name;
    }
    public void setname(){
        this.name = name;
    }
    public int getdurinmin(){
        return durinmin;
    }
    public void setdurinmin(){
        this.durinmin = durinmin;
    }
    public double getimdbrating(){
        return imdbrating;
    }
    public void setimdbrating(){
        this.imdbrating = imdbrating;
    }

}
