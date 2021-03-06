/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Gestion.GestionProfesor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Daniel Nempeque
 */
@WebServlet(name = "crearProfesor", urlPatterns = {"/crearProfesor"})
@MultipartConfig
public class crearProfesor extends HttpServlet {

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
        String id = request.getParameter("idNum");
        String vinculacion = request.getParameter("tipoVinc");
        String titulacion = request.getParameter("tipoTitu");
        String area = request.getParameter("tipoArea");
        String escalafon = request.getParameter("esca");
        String fecha_ingreso = request.getParameter("fechai");
        String fecha_egreso = request.getParameter("fechae");
        String estado = request.getParameter("estado");
        String respuesta;
        
        Part file = request.getPart("foto");
        String nom = request.getParameter("hidd");
        InputStream is = file.getInputStream();
        String rutaRelativaApp= getServletContext().getRealPath("/");
        File fil = new File(rutaRelativaApp+"/public/uploads/"+nom);
        FileOutputStream ous = new FileOutputStream(fil);
        int dato = is.read();
        while(dato != -1){
            ous.write(dato);
            dato = is.read();
        }
        ous.close();
        is.close();
        GestionProfesor gest = new GestionProfesor();
        respuesta = gest.crearProfesor(id, vinculacion, titulacion, area, escalafon, fecha_ingreso, fecha_egreso, estado, nom);
        request.setAttribute("respuesta", respuesta);
        request.getRequestDispatcher("/profesor.jsp").forward(request, response);
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
