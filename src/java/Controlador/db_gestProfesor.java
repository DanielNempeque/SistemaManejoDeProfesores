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
public class db_gestProfesor extends db_conexion {

    public ArrayList<Profesor> listarProfesor() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listarProfesor";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id_profesor = rs.getString(1);
                String fecha_ingreso = rs.getString(2);
                String fecha_egreso = rs.getString(3);
                String estado = rs.getString(4);
                String foto = rs.getString(5);
                String vinculacion = rs.getString(6);
                String titulacion = rs.getString(7);
                String area = rs.getString(8);
                String escalafon = rs.getString(9);
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
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }
        return null;
    }

    public Profesor buscaProfesor(String id) {
        Profesor profesor = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaProfesor @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                String ide = rs.getString(1);
                String fechaIngreso = rs.getString(2);
                String fechaEgreso = rs.getString(3);
                String estado = rs.getString(4);
                String foto = rs.getString(5);
                String vinc = rs.getString(6);
                String titul = rs.getString(7);
                String area = rs.getString(8);
                String esca = rs.getString(9);
                String us = rs.getString(0);
                profesor = new Profesor(ide,fechaIngreso, fechaEgreso, estado, foto, vinc, titul, area, esca, us);
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
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }

        }
        return profesor;
    }
    public boolean crearProfesor(Profesor prof) {
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_creaProfesor ?,?,?,?,?,?,?,?,?,?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, prof.getId());
            pst.setString(2, prof.getFecha_ingreso());
            pst.setString(3, prof.getFecha_egreso());
            pst.setString(4, prof.getEstado());
            pst.setString(5, prof.getFoto());
            pst.setString(6, prof.getVinculacion());
            pst.setString(7, prof.getTitulacion());
            pst.setString(8, prof.getArea());
            pst.setString(9, prof.getEscalafon());
            pst.setString(10, prof.getIdUsr());
            rs = pst.executeUpdate();
            if (rs != 0) {
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
    public boolean modificarProfesor(Profesor prof) {
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_modificaProfesor ?,?,?,?,?,?,?,?,?,?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, prof.getId());
            pst.setString(2, prof.getFecha_ingreso());
            pst.setString(3, prof.getFecha_egreso());
            pst.setString(4, prof.getEstado());
            pst.setString(5, prof.getFoto());
            pst.setString(6, prof.getVinculacion());
            pst.setString(7, prof.getTitulacion());
            pst.setString(8, prof.getArea());
            pst.setString(9, prof.getEscalafon());
            pst.setString(10, prof.getIdUsr());
            rs = pst.executeUpdate();
            if (rs != 0) {
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
    public ArrayList<Profesor> listarProfesorFiltro(String filtro) {
        ArrayList<Profesor> profesores = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_filtroProfesor @FILTRO = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, filtro);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id_profesor = rs.getString(1);
                String fecha_ingreso = rs.getString(2);
                String fecha_egreso = rs.getString(3);
                String estado = rs.getString(4);
                String foto = rs.getString(5);
                String vinculacion = rs.getString(6);
                String titulacion = rs.getString(7);
                String area = rs.getString(8);
                String escalafon = rs.getString(9);
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
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }
        return null;
    }
}
