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
@WebServlet(urlPatterns = {"/arrayServlet"})
public class ARRAY_ADDITION extends HttpServlet {

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
        String array1= request.getParameter("arrayA");
        String array2= request.getParameter("arrayB");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ARRAY_ADDITION</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2> Addition Operation on 2D Arrays.</h2>"); 
            String A = array1;
            String B = array2;
            boolean key=true;
            String[] rows1 = A.split(";");
            String[] rows2 = B.split(";");
            String[] cols1 = null;
            String[] cols2 = null;
            if(rows1.length != rows2.length){
               out.println("<h2>ERROR</h2>");
               out.println("<h2>Arrays must be of equal size for addition.</h2>"); 
             
            }
            
            
            else{
               int collen = rows1.length;
            for(int i = 0;i<rows1.length;i++){
                cols1=rows1[i].split(" ");
                cols2=rows2[i].split(" ");
                
                
                if(cols1.length!=cols2.length || cols1.length != collen || cols2.length != collen)
                {
                    key=false;
                    out.println("<h2>ERROR</h2>");
                    out.println("<h2>Arrays must be of equal size for addition.</h2>");
                    break;
                }
                
                
            }
             }
            
            if(key!=false){
            int[][] arrA = new int[rows1.length][cols1.length];
            int[][] arrB = new int[rows2.length][cols2.length];
            
            for(int i=0;i<rows1.length;i++){
                cols1=rows1[i].split(" ");
                for(int j=0;j<cols1.length;j++){
                    arrA[i][j]=Integer.parseInt(cols1[j]);
                }
            }
            
            
            for(int i=0;i<rows2.length;i++){
                cols2=rows2[i].split(" ");
                for(int j=0;j<cols2.length;j++){
                    arrB[i][j]=Integer.parseInt(cols2[j]);
                }
               // out.println(i+"<br>");
            }
            
            
            int[][] arrC = new int[rows1.length][cols1.length];
             
            for(int i=0;i<rows1.length;i++){
                for(int j=0;j<cols1.length;j++){
                    arrC[i][j] = arrA[i][j] + arrB[i][j];
                }
            }
            
           
            for(int i=0;i<rows1.length;i++){
                for(int j=0;j<cols1.length;j++){
                    
                    out.println(arrA[i][j]+" ");
                   
                }
                if(i!=(rows1.length/2))
                out.print("&nbsp&nbsp&nbsp&nbsp");
                else
                out.print("&nbsp+&nbsp");  
                for(int j=0;j<cols1.length;j++){
                   
                    out.print(arrB[i][j]+" ");
                   
                }
                 if(i!=(rows1.length/2))
                out.print("&nbsp&nbsp&nbsp&nbsp");
                else
                out.print("&nbsp=&nbsp");
                for(int j=0;j<cols1.length;j++){
                   
                    out.print(arrC[i][j]+" ");
                   
                }
                out.print("<br>");
            
            }
            }
            out.println("</body>");
            out.println("</html>");
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
