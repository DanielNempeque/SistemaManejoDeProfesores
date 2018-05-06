/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestUsuario extends db_conexion{
    
    public Usuario auth (String usuario, String pass){
        Usuario user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_auth @USER = ?, @PASS = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String username = usuario;
                String password = rs.getString(5);
                String correo = rs.getString(6);
                String correo2 = rs.getString(7);
                String telefono = rs.getString(8);
                String telefono2 = rs.getString(9);
                String documento = rs.getString(10);
                String tipoDoc = rs.getString(11);
                String idRol = rs.getString(12);
                
                user = new Usuario(id, nombre, apellidos, username, password, correo, correo2, telefono, telefono2, documento, tipoDoc, idRol);
            }
            return user;
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
