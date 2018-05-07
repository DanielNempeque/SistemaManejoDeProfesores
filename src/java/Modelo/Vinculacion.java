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
public class Vinculacion {
    private String id;
    private String tipoVinculacion;
    
    public Vinculacion(String pId, String pTipoVinculacion){
        this.id = pId;
        this.tipoVinculacion = pTipoVinculacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoVinculacion() {
        return tipoVinculacion;
    }

    public void setNombre(String tipoVinculacion) {
        this.tipoVinculacion = tipoVinculacion;
    }
    
}
