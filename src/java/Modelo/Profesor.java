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
public class Profesor extends Usuario{
    private String id;
    private String fecha_ingreso;
    private String fecha_egreso;
    private String estado;
    private String foto;
    private String vinculacion;
    private String titulacion;
    private String area;
    private String escalafon;
    private String idUsr;

    public Profesor(String id, String fecha_ingreso, String fecha_egreso, String estado, String foto, String vinculacion, String titulacion, String area, String escalafon, String idUsr) {
        this.id = id;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_egreso = fecha_egreso;
        this.estado = estado;
        this.foto = foto;
        this.vinculacion = vinculacion;
        this.titulacion = titulacion;
        this.area = area;
        this.escalafon = escalafon;
        this.idUsr = idUsr;
    }
    
}
