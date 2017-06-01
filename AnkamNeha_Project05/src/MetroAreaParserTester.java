
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha Ankam
 */
public class MetroAreaParserTester {

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     */
  public static void main(String[] args) 
        throws SAXException, ParserConfigurationException, IOException, XPathExpressionException {
      MetroAreaParser parser = new MetroAreaParser();
      ArrayList<MetroArea> metroAreas = parser.getMetroAreaFromXMLFile("metroInfo.xml");
        double popul = metroAreas.get(0).getPopulation();
        double area = metroAreas.get(0).getArea();
        double density = metroAreas.get(0).getDensity();
        int populIndex = 0, areaIndex = 0, densityIndex = 0;
      
        System.out.printf("%-10s %-8s %-17s %-12s %-15s\n","Name:","Country:","Population(mil):","Area(sq.km):","Density(p/sq.km):");
        
        for(int i = 0; i < metroAreas.size(); ++i){
            System.out.println(metroAreas.get(i));
            
            if(metroAreas.get(i).getPopulation() >= popul){
                popul = metroAreas.get(i).getPopulation();
                populIndex = i;
            }
            if(metroAreas.get(i).getArea() >= area){
                area = metroAreas.get(i).getArea();
                areaIndex = i;
            }
            if(metroAreas.get(i).getDensity() >= density){
                density = metroAreas.get(i).getDensity();
                densityIndex = i;
            }
        }
        
        System.out.println();
           
        System.out.println("The details of the metro with the largest population: ");
        System.out.println("Name: " + metroAreas.get(populIndex).getName() + "\n" + "Country: " + metroAreas.get(populIndex).getCountry() + "\n" + "Population: " + metroAreas.get(populIndex).getPopulation() + " million");
       
        System.out.println("\nThe details of the metro with the largest area: ");
        System.out.println("Name: " + metroAreas.get(areaIndex).getName() + "\n" + "Country: " + metroAreas.get(areaIndex).getCountry() + "\n" + "Area: " + metroAreas.get(areaIndex).getArea() + " sq.km");

        System.out.println("\nThe details of the metro with the largest population density: ");
        System.out.println("Name: " + metroAreas.get(densityIndex).getName() + "\n" + "Country: " + metroAreas.get(densityIndex).getCountry() + "\n" + "Density: " + Math.round(metroAreas.get(densityIndex).getDensity()) + " p/sq.km");  
    }    
     
   }
    

