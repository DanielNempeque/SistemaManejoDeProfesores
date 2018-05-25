/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Gestion.GestionProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel Nempeque
 */
@WebServlet(name = "modificarProfesor", urlPatterns = {"/modificarProfesor"})
public class modificarProfesor extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("idNum1");
            String vinculacion = request.getParameter("tipoVinc1");
            String titulacion = request.getParameter("tipoTitu1");
            String area = request.getParameter("tipoArea1");
            String escalafon = request.getParameter("esca1");
            String fecha_ingreso =  request.getParameter("fechai1");
            String fecha_egreso =  request.getParameter("fechae1");
            String estado = request.getParameter("estado1");
            String foto = request.getParameter("foto1");
            String respuesta;
            GestionProfesor gest = new GestionProfesor();
            respuesta = gest.modificarProfesor(id, vinculacion, titulacion, area, escalafon, fecha_ingreso, fecha_egreso, estado, foto);
            request.setAttribute("respuesta", respuesta);
            request.getRequestDispatcher("/profesor.jsp").forward(request, response);
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
