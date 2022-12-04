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
    public void setname(String name){
        this.name = name;
    }
    public int getdurinmin(){
        return durinmin;
    }
    public void setdurinmin(int durinmin){
        this.durinmin = durinmin;
    }
    public double getimdbrating(){
        return imdbrating;
    }
    public void setimdbrating(double imdbrating){
        this.imdbrating = imdbrating;
    }

}
