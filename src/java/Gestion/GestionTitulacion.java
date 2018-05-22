/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestTitulacion;
import Modelo.Titulacion;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionTitulacion {
    public String nuevaTitulacion(String id, String tipoTitulacion){
        if(id!=null && id!=""){
            if(tipoTitulacion!=null && tipoTitulacion!=""){
                if(!this.verificaExis(id)){
                    boolean agregado = false;
                    Titulacion titulacion = new Titulacion(id, tipoTitulacion);
                    db_gestTitulacion dbTitulacion = new db_gestTitulacion();
                    agregado = dbTitulacion.insertTitulacion(titulacion);
                    if(agregado){
                        return "Titulacion agregada con exito";
                    }else{
                        return "No se ha podido crear la Titulacion";
                    }                    
                }else{
                    return "Ya existe la Titulacion";
                }
            }else{
                return "Inserte un nombre valido";
            }
        }else{
            return "Inserte un id valido";
        }
    }
    public String editarTitulacion(String id, String tipoTitulacion){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                if(tipoTitulacion != null && tipoTitulacion!= ""){
                    boolean editado = false;
                    Titulacion titulacion = new Titulacion(id, tipoTitulacion);
                    db_gestTitulacion gest = new db_gestTitulacion();
                    editado = gest.modificaTitulacion(titulacion);
                    if(editado){
                        return "Se ha modificado con exito";
                    }else{
                        return "No se ha podido modificar";
                    }
                }else{
                    return "Inserte un nombre adecuado";
                }
            }else{
                return "No existe el id";
            }
        }else{
            return "Inserte un id adecuado";
        }
    }
    public String borraTitulacion(String id){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                boolean borrado = false;
                db_gestTitulacion gest = new db_gestTitulacion();
                Titulacion titulacion = gest.buscaTitulacion(id);
                borrado = gest.eliminaTitulacion(titulacion);
                if(borrado){
                    return "Se borró exitosamente";
                }else{
                    return "No se pudo borrar";
                }                
            }else{
                return "No existe el titulacion academica";
            }
        }else{
            return "Ingrese un id valido";
        }
    }
    public ArrayList<Titulacion> listaTitulaciones(){
        ArrayList<Titulacion> titulaciones = null;
        db_gestTitulacion gest = new db_gestTitulacion();
        titulaciones = gest.listaTitulaciones();
        return titulaciones;
    }
    public ArrayList<Titulacion> listaTitulacionesFiltro(String filtro){
        ArrayList<Titulacion> titulaciones = null;
        db_gestTitulacion gest = new db_gestTitulacion();
        titulaciones = gest.listaTitulacionFiltro(filtro);
        return titulaciones;
    }
    public boolean verificaExis(String id){
        boolean res = false; 
        db_gestTitulacion gesTitulacion = new db_gestTitulacion();
        if(gesTitulacion.buscaTitulacion(id)!=null){
            res = true;
        }
        return res;
    }
}
