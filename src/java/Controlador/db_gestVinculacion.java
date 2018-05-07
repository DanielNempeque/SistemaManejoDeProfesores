/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.db_conexion.getConnection;
import Modelo.Vinculacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class db_gestVinculacion extends db_conexion{
    public boolean insertVinculacion(Vinculacion vinculacion){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_CreateVinculacion @ID=?,@TIPO_VINCULACION=?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, vinculacion.getId());
            pst.setString(2, vinculacion.getTipoVinculacion());
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
    public boolean modificaVinculacion(Vinculacion vinculacion){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_modificaVinculacion @ID = ?, @TIPO_VINCULACION = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, vinculacion.getId());
            pst.setString(2, vinculacion.getTipoVinculacion());
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
    public Vinculacion buscaVinculacion(String id){
        Vinculacion vinculacion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaVinculacion @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                String tipoVinculacion = rs.getString(2);
                vinculacion = new Vinculacion(id, tipoVinculacion);
            }
            return vinculacion;
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
    public boolean eliminaVinculacion(Vinculacion vinculacion){
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_eliminaVinculacion @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, vinculacion.getId());
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
    public ArrayList<Vinculacion> listaVinculacion(){
        ArrayList<Vinculacion> vinculaciones = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaVinculacion";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String tipoVinculacion = rs.getString(2);
                Vinculacion vinculacion = new Vinculacion(id, tipoVinculacion);
                vinculaciones.add(vinculacion);
            }
            return vinculaciones;
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
    public ArrayList<Vinculacion> listaVinculacionFiltro(String filtro){
        ArrayList<Vinculacion> vinculaciones = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_filtroVinculacion @FILTRO = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, filtro);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String tipoVinculacion = rs.getString(2);
                Vinculacion vinculacion = new Vinculacion(id, tipoVinculacion);
                vinculaciones.add(vinculacion);
            }
            return vinculaciones;
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
