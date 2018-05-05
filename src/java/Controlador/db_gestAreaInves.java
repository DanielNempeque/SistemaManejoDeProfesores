/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreaInvestigacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestAreaInves extends db_conexion{
    public boolean insertAreaInvestigacion(AreaInvestigacion area){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_CreateAreaInvestigacion @ID=?,@NOMBRE_AREA=?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, area.getId());
            pst.setString(2, area.getNombre());
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
    public boolean eliminaAreaInvestigacion(AreaInvestigacion area){
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_eliminaAreaInvestigacion @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, area.getId());
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
    public AreaInvestigacion buscaAreaInvestigacion(String id){
        AreaInvestigacion area = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaAreaInvestigacion @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                String nombreArea = rs.getString(2);
                area = new AreaInvestigacion(id, nombreArea);
            }
            return area;
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
    public boolean modificaAreaInvestigacion(AreaInvestigacion area){
        PreparedStatement pst = null;
        try {
            int rs = 0;
            String query = "EXECUTE dbo_modificaAreaInvestigacion @ID = ?, @NOMBRE = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, area.getId());
            pst.setString(2, area.getNombre());
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
    public ArrayList<AreaInvestigacion> listaAreaInvestigacion(){
        ArrayList<AreaInvestigacion> areas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaAreasInvestigacion";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombreArea = rs.getString(2);
                AreaInvestigacion area = new AreaInvestigacion(id, nombreArea);
                areas.add(area);
            }
            return areas;
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
    public ArrayList<AreaInvestigacion> listaAreaInvestigacionFiltro(String filtro){
        ArrayList<AreaInvestigacion> areas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_filtroAreasInvestigacion @FILTRO = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, filtro);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombreArea = rs.getString(2);
                AreaInvestigacion area = new AreaInvestigacion(id, nombreArea);
                areas.add(area);
            }
            return areas;
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
