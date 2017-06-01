/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha Ankam
 */
public class MetroArea {
    
    private String name;
    private String country;
    private double population;
    private double area;
    
    MetroArea(String name,String country,double population,double area){
        this.name=name;
        this.country=country;
        this.population=population;
        this.area=area;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }
  
     public double getDensity(){
     double density= Math.round((population*1000000)/area);
     return density;
 } 
    @Override
    public String toString(){
     return String.format("%-12s %-12s %-14s %-15s %-10s", name, country, population, area, getDensity());
    }
}
