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
                    AreaAcademica area = new AreaAcademica(id, nombreArea);
                    db_gestAreaAcad dbArea = new db_gestAreaAcad();
                    dbArea.insertAreaAcademica(area);
                }else{
                    return "Ya existe el areaAcademica";
                }
            }else{
                return "Inserte un nombre valido";
            }
        }else{
            return "Inserte un id valido";
        }
        return null;
    }
    public ArrayList<AreaAcademica> listaAreas(){
        ArrayList<AreaAcademica> areas = null;
        db_gestAreaAcad gest = new db_gestAreaAcad();
        areas = gest.listaAreaAcademica();
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
