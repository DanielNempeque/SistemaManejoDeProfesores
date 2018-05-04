/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreaAcademica;
import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestAreaAcad extends db_conexion {
    
    public void insertAreaAcademica(AreaAcademica area){
        super.makeConnection();
        PreparedStatement pst = null;
        try {
            String query = "EXECUTE dbo_CreateAreaAcademica @ID=?,@NOMBRE_AREA=?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, area.getId());
            pst.setString(2, area.getNombre());
            pst.executeUpdate();
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
        
        
    }
    public AreaAcademica buscaAreaAcademica(String id){
        super.makeConnection();
        AreaAcademica area = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaArea @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                String nombreArea = rs.getString(2);
                area = new AreaAcademica(id, nombreArea);
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
    public ArrayList<AreaAcademica> listaAreaAcademica(){
        super.makeConnection();
        ArrayList<AreaAcademica> areas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaArea";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombreArea = rs.getString(2);
                AreaAcademica area = new AreaAcademica(id, nombreArea);
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
