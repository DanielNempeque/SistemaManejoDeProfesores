/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_conexion;
import Controlador.db_gestEscalafon;
import Modelo.Escalafon;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionEscalafon {
    public String crearEscalafon(String id , String tipo){
        if(id != null && id != ""){
            if(tipo != null && tipo != ""){
                if(!existeEscalafon(id)){
                    Escalafon esc = new Escalafon(id,tipo);
                    db_gestEscalafon gest = new db_gestEscalafon();
                    gest.crearEscalafon(esc);
                    return "Creado exitosamente";
                }else{
                    return "Ya existe este escalafón";
                }
            }else{
                return "Inserte un tipo valido";
            }
        }else{
            return "Inserte un id valido";
        }
    }
    public ArrayList<Escalafon> listarEscalafon(){
        ArrayList<Escalafon> escala = null;
        db_gestEscalafon gest = new db_gestEscalafon();
        escala = gest.listaEscalafon();               
        return escala;
    }
    public ArrayList<Escalafon> listarEscalafonFiltro(String filtro){
        ArrayList<Escalafon> escala = null;
        db_gestEscalafon gest = new db_gestEscalafon();
        escala = gest.listaEscalafonFiltro(filtro);               
        return escala;
    }
    
    public boolean existeEscalafon(String id){
        boolean existe = false;
        db_gestEscalafon gest = new db_gestEscalafon();
        Escalafon esc = gest.buscaEscalafon(id);
        if(esc != null){
            existe = true;
        }
        return existe;
    }
}
