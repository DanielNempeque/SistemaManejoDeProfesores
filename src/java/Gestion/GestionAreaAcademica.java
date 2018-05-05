/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestAreaAcad;
import Modelo.AreaAcademica;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionAreaAcademica {
    public String nuevaAreaAcademica(String id, String nombreArea){
        if(id!=null && id!=""){
            if(nombreArea!=null && nombreArea!=""){
                if(!this.verificaExis(id)){
                    boolean agregado = false;
                    AreaAcademica area = new AreaAcademica(id, nombreArea);
                    db_gestAreaAcad dbArea = new db_gestAreaAcad();
                    agregado = dbArea.insertAreaAcademica(area);
                    if(agregado){
                        return "Area academica agregada con exito";
                    }else{
                        return "No se ha podido crear el area";
                    }                    
                }else{
                    return "Ya existe el areaAcademica";
                }
            }else{
                return "Inserte un nombre valido";
            }
        }else{
            return "Inserte un id valido";
        }
    }
    public String editarAreaAcademica(String id, String nombreArea){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                if(nombreArea != null && nombreArea!= ""){
                    boolean editado = false;
                    AreaAcademica area = new AreaAcademica(id, nombreArea);
                    db_gestAreaAcad gest = new db_gestAreaAcad();
                    editado = gest.modificaAreaAcademica(area);
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
    public String borraAreaAcademica(String id){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                boolean borrado = false;
                db_gestAreaAcad gest = new db_gestAreaAcad();
                AreaAcademica area = gest.buscaAreaAcademica(id);
                borrado = gest.eliminaAreaAcademica(area);
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
    public ArrayList<AreaAcademica> listaAreas(){
        ArrayList<AreaAcademica> areas = null;
        db_gestAreaAcad gest = new db_gestAreaAcad();
        areas = gest.listaAreaAcademica();
        return areas;
    }
    public ArrayList<AreaAcademica> listaAreasFiltro(String filtro){
        ArrayList<AreaAcademica> areas = null;
        db_gestAreaAcad gest = new db_gestAreaAcad();
        areas = gest.listaAreaAcademicaFiltro(filtro);
        return areas;
    }
    public boolean verificaExis(String id){
        boolean res = false; 
        db_gestAreaAcad gesArea = new db_gestAreaAcad();
        if(gesArea.buscaAreaAcademica(id)!=null){
            res = true;
        }
        return res;
    }
}
