/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestRol;
import Modelo.Rol;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionRol {
    public ArrayList<Rol> listaRoles(){
        ArrayList<Rol> roles = null;
        db_gestRol gest = new db_gestRol();
        roles = gest.listaRoles();
        return roles;
    }
}
