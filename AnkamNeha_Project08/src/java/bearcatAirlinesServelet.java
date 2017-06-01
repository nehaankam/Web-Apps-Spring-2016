/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neha Ankam
 */
@WebServlet(urlPatterns = {"/bearcatAirlinesServelet"})
public class bearcatAirlinesServelet extends HttpServlet {

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
        String type = request.getParameter("type");
        String size = request.getParameter("size");
        String passengers = request.getParameter("passengers");
        String raft = request.getParameter("raft");
        String vest = request.getParameter("vest");
        int pass = Integer.parseInt(passengers);
        
        try (PrintWriter out = response.getWriter()) {
            
           
            
                 int DC9 = 50000;
                 int MD83 = 75000;
                 int TopOff = 10000;
                 int Half = 5000;
                 int Minimum = 1000;
                 int LifeRaft = 150;
                 int LifeVest = 300;

                int weight = 0;
                double time = 0;
                
                
                switch (type) {
                    case "DC9":
                        weight+=DC9;
                        break;
                    
                    default:
                        weight+=MD83;
                        break;
                }
                
                switch (size) {
                    case "topoff":
                        weight+=TopOff;
                        break;
                    case "half":
                        weight+=Half;
                        break;
                    default:
                        weight+=Minimum;
                        break;
                }
                weight=weight + (pass * 150);
                if((request.getParameter("raft").equals("raft")))
                {
                    weight+=LifeRaft;
                }
                if((request.getParameter("vest").equals("vest")))
                {
                    weight+=LifeVest;
                }
                
                time = (Math.floor(Math.random() * (3 - 1 + 1)) + 1) * pass;
                
                
                out.println(String.format("<div>Estimated weight of the aircraft is %d lb.</div>",weight));
                
                 out.println(String.format("<div>Estimated boarding time for the aircraft is %d minutes</div>",(int)time));
                
                
                
                
            
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet bearcatAirlinesServelet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet bearcatAirlinesServelet at " + request.getContextPath() + "</h1>");
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
