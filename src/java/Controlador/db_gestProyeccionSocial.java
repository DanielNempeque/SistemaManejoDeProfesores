/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.db_conexion.getConnection;
import Modelo.ProyeccionSocial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class db_gestProyeccionSocial extends db_conexion{
    public boolean insertProyeccionSocial(ProyeccionSocial proyeccionSocial){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_creaProyeccionSocial @ID=?,@NOMBRE=?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, proyeccionSocial.getId());
            pst.setString(2, proyeccionSocial.getNombre());
            rs = pst.executeUpdate();
            if(rs != 0){
                return true;
            }
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
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
            
        }
        
        return false;
    }
    public boolean modificaProyeccionSocial(ProyeccionSocial proyeccionSocial){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_modificaProyeccionSocial @ID = ?, @NOMBRE = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, proyeccionSocial.getId());
            pst.setString(2, proyeccionSocial.getNombre());
            rs = pst.executeUpdate();
            if(rs != 0){
                return true;
            }
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
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }
        return false;
    }
    public ProyeccionSocial buscaProyeccionSocial(String id){
        ProyeccionSocial proyeccionSocial = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaProyeccionSocial @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                String nombre = rs.getString(2);
                proyeccionSocial = new ProyeccionSocial(id, nombre);
            }
            return proyeccionSocial;
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
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }        
        return null;
    }
    public boolean eliminaProyeccionSocial(ProyeccionSocial proyeccionSocial){
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_eliminaProyeccionSocial @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, proyeccionSocial.getId());
            rs = pst.executeUpdate();
            if(rs != 0){
                return true;
            }
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
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }
        return false;
    }
    public ArrayList<ProyeccionSocial> listaProyeccionesSociales(){
        ArrayList<ProyeccionSocial> proyeccionesSociales = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaProyeccionSocial";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                ProyeccionSocial proyeccionSocial = new ProyeccionSocial(id, nombre);
                proyeccionesSociales.add(proyeccionSocial);
            }
            return proyeccionesSociales;
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
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }        
        return null;
    }
    public ArrayList<ProyeccionSocial> listaProyeccionesSocialesFiltro(String filtro){
        ArrayList<ProyeccionSocial> proyeccionesSociales = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_filtroProyeccionSocial @FILTRO = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, filtro);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                ProyeccionSocial proyeccionSocial = new ProyeccionSocial(id, nombre);
                proyeccionesSociales.add(proyeccionSocial);
            }
            return proyeccionesSociales;
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
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }        
        return null;
    }
}
