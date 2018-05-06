/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Daniel Nempeque
 */
public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String usr;
    private String pass;
    private String correo;
    private String correo2;
    private String telefono;
    private String telefono2;
    private String documento;
    private String tipoDoc;
    private String idRol;

    public Usuario(String id, String nombre, String apellido, String usr, String pass, String correo, String correo2, String telefono, String telefono2, String documento, String tipoDoc, String idRol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usr = usr;
        this.pass = pass;
        this.correo = correo;
        this.correo2 = correo2;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.documento = documento;
        this.tipoDoc = tipoDoc;
        this.idRol = idRol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
    
}
