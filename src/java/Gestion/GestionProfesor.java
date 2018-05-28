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

    public String crearProfesor(String id, String vinculacion, String titulacion, String area, String escalafon, String fechaIngreso, String fechaEgreso, String estado, String foto) {
        if (id != null && id != "") {
            if (vinculacion != null && vinculacion != "") {
                if (titulacion != null && titulacion != "") {
                    if (area != null && area != "") {
                        if (escalafon != null && escalafon != "") {
                            if (fechaIngreso != null && fechaIngreso != "") {
                                if (estado != null && estado != "") {
                                    if (foto != null && foto != "") {
                                        if (!exists(id)) {
                                            boolean creado = false;
                                            db_gestProfesor gest = new db_gestProfesor();
                                            Profesor prof = new Profesor(id, fechaIngreso, fechaEgreso, estado, foto, vinculacion, titulacion, area, escalafon, id);
                                            creado = gest.crearProfesor(prof);
                                            if (creado) {
                                                return "Se ha creado correctamente";
                                            } else if (!creado) {
                                                return "No se ha podido crear";
                                            } else {
                                                return "Error desconocido";
                                            }
                                        } else {
                                            return "Ya existe";
                                        }
                                    } else {
                                        return "Seleccione una foto valida";
                                    }
                                } else {
                                    return "Seleccione un estado valido";
                                }

                            } else {
                                return "Seleccione una fecha valida";
                            }
                        } else {
                            return "Ingrese un escalafon valido";
                        }
                    } else {
                        return "Ingrese una area valida";
                    }
                } else {
                    return "Ingrese una titulacion valida";
                }
            } else {
                return "Seleccione una vinculacion valida";
            }
        } else {
            return "Ingrese un id valido";
        }
    }
    public String modificarProfesor(String id, String vinculacion, String titulacion, String area, String escalafon, String fechaIngreso, String fechaEgreso, String estado, String foto) {
        if (id != null && id != "") {
            if (vinculacion != null && vinculacion != "") {
                if (titulacion != null && titulacion != "") {
                    if (area != null && area != "") {
                        if (escalafon != null && escalafon != "") {
                            if (fechaIngreso != null && fechaIngreso != "") {
                                if (estado != null && estado != "") {
                                    if (foto != null && foto != "") {
                                        if (!exists(id)) {
                                            boolean creado = false;
                                            db_gestProfesor gest = new db_gestProfesor();
                                            Profesor prof = new Profesor(id, fechaIngreso, fechaEgreso, estado, foto, vinculacion, titulacion, area, escalafon, id);
                                            creado = gest.modificarProfesor(prof);
                                            if (creado) {
                                                return "Se ha modificado correctamente";
                                            } else if (!creado) {
                                                return "No se ha podido modificar";
                                            } else {
                                                return "Error desconocido";
                                            }
                                        } else {
                                            return "Ya existe";
                                        }
                                    } else {
                                        return "Seleccione una foto valida";
                                    }
                                } else {
                                    return "Seleccione un estado valido";
                                }

                            } else {
                                return "Seleccione una fecha valida";
                            }
                        } else {
                            return "Ingrese un escalafon valido";
                        }
                    } else {
                        return "Ingrese una area valida";
                    }
                } else {
                    return "Ingrese una titulacion valida";
                }
            } else {
                return "Seleccione una vinculacion valida";
            }
        } else {
            return "Ingrese un id valido";
        }
    }
    public ArrayList<Profesor> listarProfesor() {
        ArrayList<Profesor> profesores = null;
        db_gestProfesor gest = new db_gestProfesor();
        profesores = gest.listarProfesor();
        return profesores;
    }
    public ArrayList<Profesor> listarProfesorFiltro(String filtro) {
        ArrayList<Profesor> profesores = null;
        db_gestProfesor gest = new db_gestProfesor();
        profesores = gest.listarProfesorFiltro(filtro);
        return profesores;
    }
    public boolean exists(String id) {
        boolean existe = false;
        db_gestProfesor gest = new db_gestProfesor();
        if (gest.buscaProfesor(id) != null) {
            existe = true;
        }
        return existe;
    }
    public Profesor buscaProfesor (String id){
        db_gestProfesor gest = new db_gestProfesor();
        Profesor prof = gest.buscaProfesor(id);
        return prof;
    }
}
