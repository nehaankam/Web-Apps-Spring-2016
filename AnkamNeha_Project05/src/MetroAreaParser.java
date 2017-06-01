
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
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
public class MetroAreaParser {
     private DocumentBuilder builder;
     private XPath path;
     
    
     public MetroAreaParser()  throws ParserConfigurationException {
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      path = XPathFactory.newInstance().newXPath();
     } 
     /**
      * 
      * @param fileName
      * @return
      * @throws SAXException
      * @throws IOException
      * @throws XPathExpressionException 
      */
     public ArrayList<MetroArea> getMetroAreaFromXMLFile(String fileName)
           throws SAXException, IOException, XPathExpressionException {
      // Parse file and build DOM tree.
      Document metro = builder.parse(new File(fileName));

      // Count the dog elements.
      int met = Integer.parseInt(path.evaluate("count(/metroAreaList/metroArea)", metro));

      // Extract dog information from the XML document and represent the
      // information as an ArrayList of metro objects.
      ArrayList<MetroArea> metroAreaList = new ArrayList<>();
      for (int i = 1; i <= met; ++i) {
         String name = path.evaluate("/metroAreaList/metroArea[" + i + "]/name", metro);
         String country = path.evaluate("/metroAreaList/metroArea[" + i + "]/country", metro);
         double population = Double.parseDouble(path.evaluate("/metroAreaList/metroArea[" + i + "]/population", metro));
        double area = Double.parseDouble(path.evaluate("/metroAreaList/metroArea[" + i + "]/area", metro));
         metroAreaList.add(new MetroArea(name, country, population, area));
      }
      return metroAreaList;
   }
     
     
}
