/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ankam;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Neha Ankam
 */
@ManagedBean
@Named(value = "spaceWeight")
@RequestScoped
public class SpaceWeight {

   public String name;
    public double weight;
    public double desired;
    public String potential;
    public boolean metric;
    public String relocate;
    
    double merPL=0.0;
    double venPL=0.0;
    double earPL=0.0;
    double marPL=0.0;
    double jupPL=0.0;
    double satPL=0.0;
    double uraPL=0.0;
    double nepPL=0.0;
    double desiredPlanet[];
    
    public SpaceWeight() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDesired() {
        return desired;
    }

    public void setDesired(double desired) {
        this.desired = desired;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public boolean getMetric() {
        return metric;
    }

    public void setMetric(boolean metric) {
        this.metric = metric;
    }

    public String getRelocate() {
        return relocate;
    }

    public void setRelocate(String relocate) {
        this.relocate = relocate;
    }
    
    public String useMetric(){
        String units;
        if( metric ){
            units="Kgs";
        }else{
        units="Lbs";
        }
                return units;
        }
    
public double calWeight(){
    String potPla[]=potential.split(" ");
    desiredPlanet= new double[potPla.length];
    System.out.println(desiredPlanet[0]);
    String result="";
    
    for(int i=0; i<potPla.length; i++){
        if(potPla[i].equals("Mercury")){
            merPL= weight* 0.06;
            desiredPlanet[i]=merPL;
        }
        if(potPla[i].equals("Venus")){
            venPL=weight*0.82;
            desiredPlanet[i]=venPL;
        }
        if(potPla[i].equals("Earth")){
            earPL=weight*1.0;
            desiredPlanet[i]=earPL;
        }
        if(potPla[i].equals("Mars")){
            marPL=weight*0.11;
            desiredPlanet[i]=marPL;
        }
        if(potPla[i].equals("Jupiter")){
            jupPL=weight* 317.8;
            desiredPlanet[i]=jupPL;
        }
        if(potPla[i].equals("Saturn")){
            satPL=weight*95.2;
            desiredPlanet[i]=satPL;
        }
        if(potPla[i].equals("Uranus")){
            uraPL=weight*14.6;
            desiredPlanet[i]=uraPL;
        }
        if(potPla[i].equals("Neptune")){
            nepPL=weight*17.2;
            desiredPlanet[i]=nepPL;
        }    
    }
    
    double variation=Math.abs(desiredPlanet[0]-desired);
    int index=0;
    for(int p=1; p<desiredPlanet.length; p++ ){
        double var=Math.abs(desiredPlanet[p]-desired);
        if(var<variation){
            index=p;
            variation=var;
        }
    }
    
    double nearValue= desiredPlanet[index];
    relocate=potPla[index];
    return nearValue;
        }
     
}
