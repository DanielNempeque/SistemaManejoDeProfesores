/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class db_gestUsuario extends db_conexion {

    public Usuario auth(String usuario, String pass) {
        Usuario user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_auth @USER = ?, @PASS = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            while (rs.next()) {
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
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }
        return null;
    }

    public Usuario buscaUsuario(String ide) {
        Usuario user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_buscaUsuario @ID = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, ide);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String username = rs.getString(4);
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
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e);
            }
        }
        return null;
    }

    public boolean newUser(Usuario user) {
        PreparedStatement pst = null;
        int rs = 0;
        try {
            String query = "EXECUTE dbo_creaUsuario ?,?,?,?,?,?,?,?,?,?,?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, user.getId());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellido());
            pst.setString(4, user.getUsr());
            pst.setString(5, user.getCorreo());
            pst.setString(6, user.getCorreo2());
            pst.setString(7, user.getTelefono());
            pst.setString(8, user.getTelefono2());
            pst.setString(9, user.getDocumento());
            pst.setString(10, user.getTipoDoc());
            pst.setString(11, user.getIdRol());
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

    public String pass(String id) {
        String pass = "";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_muestraPass @ID=?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                pass = rs.getString(1);
            }
            return pass;
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
    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_listaUsuarios";
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String username = rs.getString(4);
                String password = rs.getString(5);
                String correo = rs.getString(6);
                String correo2 = rs.getString(7);
                String telefono = rs.getString(8);
                String telefono2 = rs.getString(9);
                String documento = rs.getString(10);
                String tipoDoc = rs.getString(11);
                String idRol = rs.getString(12);

                user = new Usuario(id, nombre, apellidos, username, password, correo, correo2, telefono, telefono2, documento, tipoDoc, idRol);
                usuarios.add(user);
            }
            return usuarios;
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
    public ArrayList<Usuario> listaUsuariosFiltro(String filtro) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "EXECUTE dbo_filtroUsuario @FILTRO = ?";
            pst = getConnection().prepareStatement(query);
            pst.setString(1, filtro);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String username = rs.getString(4);
                String password = rs.getString(5);
                String correo = rs.getString(6);
                String correo2 = rs.getString(7);
                String telefono = rs.getString(8);
                String telefono2 = rs.getString(9);
                String documento = rs.getString(10);
                String tipoDoc = rs.getString(11);
                String idRol = rs.getString(12);

                user = new Usuario(id, nombre, apellidos, username, password, correo, correo2, telefono, telefono2, documento, tipoDoc, idRol);
                usuarios.add(user);
            }
            return usuarios;
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
