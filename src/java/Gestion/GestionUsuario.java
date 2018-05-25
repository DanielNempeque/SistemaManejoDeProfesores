/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import Controlador.db_gestUsuario;
import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Daniel Nempeque
 */
public class GestionUsuario {

    public Usuario login(String user, String password) {
        db_gestUsuario gest = new db_gestUsuario();
        Usuario usr = null;
        if (user != null) {
            if (password != null) {
                usr = gest.auth(user, password);
                return usr;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String creaUsuario(String id, String nombre, String apellido, String username, String correo, String correo2, String telefono, String telefono2, String documento, String tipodoc, String idrol) {
        boolean creado = false;
        if (id != null && id != "") {
            if (nombre != null && id != "") {
                if (apellido != null && apellido != "") {
                    if (username != null && username != "") {
                        if (correo != null && correo != "") {
                            if (telefono != null & telefono != "") {
                                if (documento != null && documento != "") {
                                    if (!this.verificaExiste(id)) {
                                        Usuario usr = new Usuario(id, nombre, apellido, username, correo, correo2, telefono, telefono2, documento, tipodoc, idrol);
                                        db_gestUsuario gest = new db_gestUsuario();
                                        creado = gest.newUser(usr);
                                        if (creado) {
                                            return "Se creo correctamente";
                                        } else {
                                            return "No se ha podido crear";
                                        }
                                    }else{
                                        return "Ya existe el usuario";
                                    }
                                } else {
                                    return "Ingrese un documento valido";
                                }
                            } else {
                                return "Ingrese un telefono valido";
                            }
                        } else {
                            return "Ingrese un correo valido";
                        }
                    } else {
                        return "Ingrese in nombre de usuario valido";
                    }
                } else {
                    return "Ingrese un apellido valido";
                }
            } else {
                return "Ingrese un nombre valido";
            }
        } else {
            return "Ingrese un id valido";
        }
        
    }

    public ArrayList<Usuario> listarUsuarios(){
        ArrayList<Usuario> usuarios = null;
        db_gestUsuario gest = new db_gestUsuario();
        usuarios = gest.listaUsuarios();
        return usuarios;
    }
    public ArrayList<Usuario> listarUsuariosFiltro(String filtro){
        ArrayList<Usuario> usuarios = null;
        db_gestUsuario gest = new db_gestUsuario();
        usuarios = gest.listaUsuariosFiltro(filtro);
        return usuarios;
    }
    public String pass(String id) {
        String pass;
        db_gestUsuario gest = new db_gestUsuario();
        pass = gest.pass(id);
        return pass;
    }

    public boolean verificaExiste(String id) {
        boolean existe = false;
        db_gestUsuario gest = new db_gestUsuario();
        Usuario usr = gest.buscaUsuario(id);
        if (usr != null) {
            existe = true;
        }
        return existe;
    }
  /*  public void SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
 
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("correo de quien envia--->aqui va el correo quien envia", "clave del correo--->aqui la clave del correo");
                    }
                });
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correo de quien envia"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo a quien se le envia-------->aqui va el correo a quien se le envia));
            message.setSubject(asunto);
            message.setText(Mensaje);
 
            Transport.send(message);
            
            
                 Alert cuadroDialogo = new Alert(Alert.AlertType.INFORMATION);
                cuadroDialogo.setTitle("Restableciendo contraseña");                               
                cuadroDialogo.setHeaderText("Se le ha enviado un correo con su contraseña");
                cuadroDialogo.setContentText("Clic en Aceptar para regresar"); 
                cuadroDialogo.showAndWait();
 
        } catch (MessagingException e) {
            
        }
    }*/
}
