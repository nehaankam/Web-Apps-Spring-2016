/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neha Ankam
 */
@WebServlet(urlPatterns = {"/exerciseServelet"})
public class ExerciseServelet extends HttpServlet {

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

        String error1 = "";
        String error2 = "";
        String error3 = "";
        String error4 = "";
        String error5 = "";
        String activity = request.getParameter("type");

        String MOE = request.getParameter("method");

        double MET = 0.0;

        if (MOE.equals("participating")) {
            switch (activity) {
                case "Aerobics":
                    MET = 6.83;
                    break;
                case "Baseball":
                    MET = 5;
                    break;
                case "Billiards":
                    MET = 2.5;
                    break;
                case "Climbing":
                    MET = 9.5;
                    break;
                case "Fencing":
                    MET = 6.0;
                    break;
                case "Golf":
                    MET = 3.75;
                    break;
                case "Hockey":
                    MET = 8.0;
                    break;
                case "Rugby":
                    MET = 10;
                    break;
                case "Swimming":
                    MET = 5.22;
                    break;
                default:
                    error1 = "Activity is missing";
                    MET = 0.0;
            }
        } else {
            MET = 1.5;
        }

        String Height = request.getParameter("height");
        double height = 0.0;
        if (Height.isEmpty()) {
            error2 = "Height is missing";

        } else {
            height = Double.parseDouble(Height);
        }
        String Weight = request.getParameter("weight");
        double weight = 0.0;
        if (Weight.isEmpty()) {
            error3 = "Weight is missing";
        } else {
            weight = Double.parseDouble(Weight);
        }
        String Age = request.getParameter("age");
        int age = 0;
        if (Age.isEmpty()) {
            error4 += "Age is missing";
        } else {
            age = Integer.parseInt(Age);
        }

        Double bmr = 0.0;
        String Gender = request.getParameter("gender");
        
        String metric = request.getParameter("metric");
        
           
        if (Gender.equals("male")) {
            bmr = 66 + (13.75 * (weight)) + (5 * height) - (6.76 * age);
        } else {
            bmr = 655 + (9.6 * (weight)) + (1.85 * height) - (4.68 * age);
        }
       
        String Time = request.getParameter("duration");
        double time = 0.0;
        if (Time.isEmpty()) {
            error5 += "Duration is missing";
        } else {
            time = Double.parseDouble(Time);
        }
        Double calories = (bmr / 24) * MET * time;
        boolean key =false;
        if(metric!=null){
            key = true;
        weight = weight * 0.453592;
        height = height * 0.3048 * 100;
        
        }

        if (error1.equals("") && error2.equals("") && error3.equals("") && error4.equals("") && error5.equals("") && key == true) {
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Bearcat Exercise Calculator Results</title>");
                out.println("<link type='text/css' rel ='stylesheet' href='exerciseCalculatorConfirmation.css'>");
         
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Bearcat Excercise Calculator Results");
                out.println("<br>");
               
                out.println("<br>");
                out.println("<h2>"+"As a " + String.format("%.1f",height) + "centimeters, " + String.format("%.1f",weight) + "kgs " + Gender + ", doing " + activity + " for " + time + " hours, you burned " + String.format("%.1f",calories) + " calories!"+"</h2>");
                //out.println("<h1>Servlet ExerciseServelet at " + request.getContextPath() + "</h1>");

                out.println("</body>");
                out.println("</html>");
            }
        } 
        
        
        
        
        else if (error1.equals("") && error2.equals("") && error3.equals("") && error4.equals("") && error5.equals("") && key == false) {
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Bearcat Exercise Calculator Results</title>");
                out.println("<link type='text/css' rel ='stylesheet' href='exerciseCalculatorConfirmation.css'>");
         
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Bearcat Excercise Calculator Results");
                out.println("<br>");
                
                out.println("<br>");
                out.println("<h2>"+"As a " + String.format("%.1f",height) + " ft, " + String.format("%.1f",weight) + " lb " + Gender + ", doing " + activity + " for " + time + " hours, you burned " + String.format("%.1f",calories) + " calories!"+"</h2>");
            //out.println("<h1>Servlet ExerciseServelet at " + request.getContextPath() + "</h1>");

                out.println("</body>");
                out.println("</html>");
            }
        } 
        
        
        
        
        
        
        
        
        
        else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Bearcat Exercise Calculator Results</title>");
                out.println("<link type='text/css' rel ='stylesheet' href='exerciseCalculatorConfirmation.css'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Bearcat Excercise Calculator Results");
                out.println("<br>");
                out.println("<br>");
                
                out.println("<h3>" + error1 + "</h3>");

                out.println("<h3>" + error2 + "</h3>");

                out.println("<h3>" + error3 + "</h3>");

                out.println("<h3>" + error4 + "</h3>");

                out.println("<h3>" + error5 + "</h3>");

                out.println("</body>");
                out.println("</html>");
            }
        }
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
