/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestAreaInves;
import Modelo.AreaInvestigacion;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionAreaInvestigacion {
    public String nuevaAreaInvestigacion(String id, String nombreArea){
        if(id!=null && id!=""){
            if(nombreArea!=null && nombreArea!=""){
                if(!this.verificaExis(id)){
                    boolean agregado = false;
                    AreaInvestigacion area = new AreaInvestigacion(id, nombreArea);
                    db_gestAreaInves dbArea = new db_gestAreaInves();
                    agregado = dbArea.insertAreaInvestigacion(area);
                    if(agregado){
                        return "Area de investigación agregada con exito";
                    }else{
                        return "No se ha podido crear el area";
                    }                    
                }else{
                    return "Ya existe el area de investigación";
                }
            }else{
                return "Inserte un nombre valido";
            }
        }else{
            return "Inserte un id valido";
        }
    }
    public String borraAreaInvestigacion(String id){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                boolean borrado = false;
                db_gestAreaInves gest = new db_gestAreaInves();
                AreaInvestigacion area = gest.buscaAreaInvestigacion(id);
                borrado = gest.eliminaAreaInvestigacion(area);
                if(borrado){
                    return "Se borró exitosamente";
                }else{
                    return "No se pudo borrar";
                }                
            }else{
                return "No existe el area academica";
            }
        }else{
            return "Ingrese un id valido";
        }
    }
    public String editarAreaInvestigacion(String id, String nombreArea){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                if(nombreArea != null && nombreArea!= ""){
                    boolean editado = false;
                    AreaInvestigacion area = new AreaInvestigacion(id, nombreArea);
                    db_gestAreaInves gest = new db_gestAreaInves();
                    editado = gest.modificaAreaInvestigacion(area);
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
    public ArrayList<AreaInvestigacion> listaAreasInvestigacion(){
        ArrayList<AreaInvestigacion> areas = null;
        db_gestAreaInves gest = new db_gestAreaInves();
        areas = gest.listaAreaInvestigacion();
        return areas;
    }
    public ArrayList<AreaInvestigacion> listaAreasFiltro(String filtro){
        ArrayList<AreaInvestigacion> areas = null;
        db_gestAreaInves gest = new db_gestAreaInves();
        areas = gest.listaAreaInvestigacionFiltro(filtro);
        return areas;
    }
    public boolean verificaExis(String id){
        boolean res = false; 
        db_gestAreaInves gesArea = new db_gestAreaInves();
        if(gesArea.buscaAreaInvestigacion(id)!=null){
            res = true;
        }
        return res;
    }
}
