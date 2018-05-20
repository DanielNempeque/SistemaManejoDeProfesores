/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestProfesor;
import Modelo.Profesor;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionProfesor {
    
    public ArrayList<Profesor> listarProfesor(){
        ArrayList<Profesor> profesores = null;
        db_gestProfesor gest = new db_gestProfesor();
        profesores = gest.listarProfesor();
        return profesores;
    }
}
