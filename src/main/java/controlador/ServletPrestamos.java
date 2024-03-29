/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Utilidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cuota;
import modelo.Prestamo;

/**
 *
 * @author mario
 */
public class ServletPrestamos extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrestamos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrestamos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        ArrayList<String> listaMeses = Utilidades.calculaMeses();
        request.setAttribute("listaMeses", listaMeses);
        request.getRequestDispatcher("prestamos.jsp").forward(request, response);
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
        String nombre=request.getParameter("nombre");
        String capital=request.getParameter("capital");
        String interes=request.getParameter("interes");
        String mesActual=request.getParameter("mesActual");
        Prestamo miPrestamo = new Prestamo(Double.parseDouble(capital),Double.parseDouble(interes),Integer.parseInt(mesActual));
        
        request.setAttribute("nombre",nombre);
        request.setAttribute("miPrestamo", miPrestamo);
        ArrayList<String> listaMeses = Utilidades.calculaMeses();
        request.setAttribute("listaMeses", listaMeses);
       //NO ME LEE LA FUNCION LISTACUOTAS
       //ArrayList<Cuota> listaCuotas = Utilidades.listaCuotas
       // request.setAttribute("listaCuotas", listaCuotas);
        
        request.getRequestDispatcher("prestamos.jsp").forward(request, response);
        
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
