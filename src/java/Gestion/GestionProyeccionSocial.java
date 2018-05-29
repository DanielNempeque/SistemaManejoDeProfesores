/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestProyeccionSocial;
import Modelo.ProyeccionSocial;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionProyeccionSocial {
    public String nuevaProyeccionSocial(String id, String nombre){
        if(id!=null && id!=""){
            if(nombre!=null && nombre!=""){
                if(!this.verificaExis(id)){
                    boolean agregado = false;
                    ProyeccionSocial proyeccionSocial = new ProyeccionSocial(id, nombre);
                    db_gestProyeccionSocial dbProyeccionSocial = new db_gestProyeccionSocial();
                    agregado = dbProyeccionSocial.insertProyeccionSocial(proyeccionSocial);
                    if(agregado){
                        return "Proyeccion social agregada con exito";
                    }else{
                        return "No se ha podido crear la proyeccion social";
                    }                    
                }else{
                    return "Ya existe la proyeccion social";
                }
            }else{
                return "Inserte un nombre valido";
            }
        }else{
            return "Inserte un id valido";
        }
    }
    public String editarProyeccionSocial(String id, String nombre){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                if(nombre != null && nombre!= ""){
                    boolean editado = false;
                    ProyeccionSocial proyeccionSocial = new ProyeccionSocial(id, nombre);
                    db_gestProyeccionSocial gest = new db_gestProyeccionSocial();
                    editado = gest.modificaProyeccionSocial(proyeccionSocial);
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
    public String borraProyeccionSocial(String id){
        if(id != null && id != ""){
            if(this.verificaExis(id)){
                boolean borrado = false;
                db_gestProyeccionSocial gest = new db_gestProyeccionSocial();
                ProyeccionSocial proyeccionSocial = gest.buscaProyeccionSocial(id);
                borrado = gest.eliminaProyeccionSocial(proyeccionSocial);
                if(borrado){
                    return "Se borró exitosamente";
                }else{
                    return "No se pudo borrar";
                }                
            }else{
                return "No existe la proyección social";
            }
        }else{
            return "Ingrese un id valido";
        }
    }
    public ArrayList<ProyeccionSocial> listaProyeccionesSociales(){
        ArrayList<ProyeccionSocial> proyeccionesSociales = null;
        db_gestProyeccionSocial gest = new db_gestProyeccionSocial();
        proyeccionesSociales = gest.listaProyeccionesSociales();
        return proyeccionesSociales;
    }
    public ArrayList<ProyeccionSocial> listaProyeccionesSocialesFiltro(String filtro){
        ArrayList<ProyeccionSocial> proyeccionesSociales = null;
        db_gestProyeccionSocial gest = new db_gestProyeccionSocial();
        proyeccionesSociales = gest.listaProyeccionesSocialesFiltro(filtro);
        return proyeccionesSociales;
    }
    public boolean verificaExis(String id){
        boolean res = false; 
        db_gestProyeccionSocial gesProyeccionSocial = new db_gestProyeccionSocial();
        if(gesProyeccionSocial.buscaProyeccionSocial(id)!=null){
            res = true;
        }
        return res;
    }
}
