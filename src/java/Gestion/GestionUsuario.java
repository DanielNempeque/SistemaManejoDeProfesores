/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestUsuario;
import Modelo.Usuario;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionUsuario {
    public Usuario login (String user, String password){
        db_gestUsuario gest = new db_gestUsuario();
        Usuario usr = null;
        if(user != null){
            if(password != null){
                usr = gest.auth(user, password);
                return usr;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
