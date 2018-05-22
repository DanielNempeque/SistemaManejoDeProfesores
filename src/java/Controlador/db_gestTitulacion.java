/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.db_conexion.getConnection;
import Modelo.Titulacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class db_gestTitulacion extends db_conexion{
    public boolean insertTitulacion(Titulacion titulacion){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_creaTitulacion @ID=?,@TIPOTITULACION=?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, titulacion.getId());
            pst.setString(2, titulacion.getTipoTitulacion());
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
    public boolean modificaTitulacion(Titulacion titulacion){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_modificaTitulacion @ID = ?, @TIPOTITULACION = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, titulacion.getId());
            pst.setString(2, titulacion.getTipoTitulacion());
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
    public Titulacion buscaTitulacion(String id){
        Titulacion titulacion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaTitulacion @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                String tipoTitulacion = rs.getString(2);
                titulacion = new Titulacion(id, tipoTitulacion);
            }
            return titulacion;
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
    public boolean eliminaTitulacion(Titulacion titulacion){
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_eliminaTitulacion @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, titulacion.getId());
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
    public ArrayList<Titulacion> listaTitulaciones(){
        ArrayList<Titulacion> titulaciones = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaTitulacion";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String tipoTitulacion = rs.getString(2);
                Titulacion titulacion = new Titulacion(id, tipoTitulacion);
                titulaciones.add(titulacion);
            }
            return titulaciones;
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
    public ArrayList<Titulacion> listaTitulacionFiltro(String filtro){
        ArrayList<Titulacion> titulaciones = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_filtroTitulacion @FILTRO = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, filtro);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String tipoTitulacion = rs.getString(2);
                Titulacion titulacion = new Titulacion(id, tipoTitulacion);
                titulaciones.add(titulacion);
            }
            return titulaciones;
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
