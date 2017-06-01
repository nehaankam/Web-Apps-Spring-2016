/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ankam;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author Neha Ankam
 */
//@ManagedBean
@RequestScoped
@Named(value = "gaRegistrationBean")
public class GARegistrationBean {

    private String firstName;
    private String lastName;
    private String password;
    private int gre;
    private double gpa;
    
    
    /**
     * Creates a new instance of GARegistrationBean
     */
    public GARegistrationBean() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGre() {
        return gre;
    }

    public void setGre(int gre) {
        this.gre = gre;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    
    
    
    
    
    public String getUserName(){
        String fLower=firstName.toLowerCase();
        String lLower=lastName.toLowerCase();
        String str="";
        return str+fLower.charAt(0)+fLower.charAt(fLower.length()-1)+lLower.charAt(0)+lLower.charAt(lLower.length()-1); 
    }
    
    public int getIndex(){
        double greScaled=((double)(gre-130))/10;//3.2
        double i=(greScaled+gpa)*12.5; //86.75
        float index=(float) i;
        return Math.round(index);
    }
}
