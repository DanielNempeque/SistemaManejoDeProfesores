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
public class Titulacion {
    private String id;
    private String tipoTitulacion;
    
    public Titulacion(String pId, String pTipoTitulacion){
        this.id = pId;
        this.tipoTitulacion = pTipoTitulacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoTitulacion() {
        return tipoTitulacion;
    }

    public void setNombre(String tipoTitulacion) {
        this.tipoTitulacion = tipoTitulacion;
    }
    
}
