/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufacturers;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Neha Ankam
 */
@Named(value = "manufacturerList")
@RequestScoped
public class ManufacturerList {

   @PersistenceUnit(unitName = "AnkamNeha_Project12PU")
    private EntityManagerFactory emf = null;
    private String state = null;
    
    public ManufacturerList() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public List<Manufacturer> getManufacturersFound() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                 "SELECT m FROM Manufacturer m where m.state = '"+state+"'").getResultList();
               
    }

    
}
