/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neha Ankam
 */
@WebServlet(name = "CanadianProvinceServelet", urlPatterns = {"/CanadianProvinceServelet"})
public class CanadianProvinceServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         Canada canada = new Canada();
        ArrayList<Province> province = canada.getProvinces();
        
        
        try (PrintWriter out = response.getWriter()) {
            

            
            String pop = request.getParameter("population");
        String lan = request.getParameter("land");
        String wat = request.getParameter("water");
        long population = Long.parseLong(pop);
        long land = Long.parseLong(lan);
        long water = Long.parseLong(wat);
            
            try (JsonGenerator gen = Json.createGenerator(out)) {
                gen.writeStartObject();
                    gen.writeStartArray("province");
                    for (Province p : province)  {
                      if (population < p.getPopulation() && land < p.getLandArea()&& water < p.getWaterArea()){
                        gen.writeStartObject();
                        gen.write("name", p.getName());
                        gen.write("population", p.getPopulation());
                        gen.write("landArea", p.getLandArea());
                        gen.write("waterArea", p.getWaterArea());
                        gen.write("totalArea", p.getTotalArea());
                        gen.write("officialLanguage", p.getOfficialLanguage());
                        gen.writeEnd();
                    }
                    }
                    gen.writeEnd();
                gen.writeEnd();
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CanadianProvinceServelet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CanadianProvinceServelet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
