/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Escalafon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestEscalafon extends db_conexion{
    public boolean crearEscalafon(Escalafon escalafon){
        boolean creado = false;
        PreparedStatement pst = null;
        int rs = 0;
        try {
           String query = "";
           pst = getConnection().prepareStatement(query);
           pst.setString(1,escalafon.getId());
           pst.setString(2, escalafon.getTipo());
           rs = pst.executeUpdate();
           if(rs != 0){
               creado = true;
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
        return creado;
    }
    public Escalafon buscaEscalafon(String id){
        Escalafon escalafon = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                String ide = rs.getString(1);
                String Tipo = rs.getString(2);
                escalafon = new Escalafon(ide, Tipo);
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
                if (rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
            
        }
        return escalafon;
    }
    public ArrayList<Escalafon> listaEscalafon(){
        ArrayList<Escalafon> escalafones = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                String ide = rs.getString(1);
                String Tipo = rs.getString(2);
                Escalafon es = new Escalafon(ide, Tipo);
                escalafones.add(es);
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
                if (rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
            
        }
        return escalafones;
    }
}
