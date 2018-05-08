/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestVinculacion;
import Modelo.Vinculacion;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionVinculacion {
    public String nuevaVinculacion(String id, String tipoVinculacion){
        if(id!=null && id!=""){
            if(tipoVinculacion!=null && tipoVinculacion!=""){
                if(!this.verificaExis(id)){
                    boolean agregado = false;
                    Vinculacion vinculacion = new Vinculacion(id, tipoVinculacion);
                    db_gestVinculacion dbVinculacion = new db_gestVinculacion();
                    agregado = dbVinculacion.insertVinculacion(vinculacion);
                    if(agregado){
                        return "Vinculacion agregada con exito";
                    }else{
                        return "No se ha podido crear la vinculacion";
                    }                    
                }else{
                    return "Ya existe la vinculacion";
                }
            }else{
                return "Inserte un nombre valido";
            }
        }else{
            return "Inserte un id valido";
        }
    }
    public String editarVinculacion(String id, String tipoVinculacion){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                if(tipoVinculacion != null && tipoVinculacion!= ""){
                    boolean editado = false;
                    Vinculacion vinculacion = new Vinculacion(id, tipoVinculacion);
                    db_gestVinculacion gest = new db_gestVinculacion();
                    editado = gest.modificaVinculacion(vinculacion);
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
    public String borraVinculacion(String id){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                boolean borrado = false;
                db_gestVinculacion gest = new db_gestVinculacion();
                Vinculacion vinculacion = gest.buscaVinculacion(id);
                borrado = gest.eliminaVinculacion(vinculacion);
                if(borrado){
                    return "Se borró exitosamente";
                }else{
                    return "No se pudo borrar";
                }                
            }else{
                return "No existe el vinculacion academica";
            }
        }else{
            return "Ingrese un id valido";
        }
    }
    public ArrayList<Vinculacion> listaVinculaciones(){
        ArrayList<Vinculacion> vinculacion = null;
        db_gestVinculacion gest = new db_gestVinculacion();
        vinculacion = gest.listaVinculacion();
        return vinculacion;
    }
    public ArrayList<Vinculacion> listaVinculacionesFiltro(String filtro){
        ArrayList<Vinculacion> vinculacion = null;
        db_gestVinculacion gest = new db_gestVinculacion();
        vinculacion = gest.listaVinculacionFiltro(filtro);
        return vinculacion;
    }
    public boolean verificaExis(String id){
        boolean res = false; 
        db_gestVinculacion gesVinculacion = new db_gestVinculacion();
        if(gesVinculacion.buscaVinculacion(id)!=null){
            res = true;
        }
        return res;
    }
}
