/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestRol extends db_conexion{
    public ArrayList<Rol> listaRoles(){
        ArrayList<Rol> roles = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaRol";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombreArea = rs.getString(2);
                Rol rol = new Rol(id, nombreArea);
                roles.add(rol);
            }
            return roles;
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
