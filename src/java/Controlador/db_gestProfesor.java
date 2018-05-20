/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestProfesor extends db_conexion{
    
    public ArrayList<Profesor> listarProfesor(){
        ArrayList<Profesor> profesores = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listarProfesor";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id_profesor =  rs.getString(1);
                String fecha_ingreso =  rs.getString(2);
                String fecha_egreso = rs.getString(3);
                String estado = rs.getString(4);
                String foto = rs.getString(5);
                String vinculacion =  rs.getString(6);
                String titulacion = rs.getString(7);
                String area = rs.getString(8);
                String escalafon =  rs.getString(9);
                String usuario = rs.getString(10);
                
                Profesor pr = new Profesor(id_profesor, fecha_ingreso, fecha_egreso, estado, foto, vinculacion, titulacion, area, escalafon, usuario);
                profesores.add(pr);
            }
            return profesores;
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }     
        }
        return null;
    }
}
