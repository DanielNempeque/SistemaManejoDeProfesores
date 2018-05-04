/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *x 
 * @author Daniel Nempeque
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class db_conexion {
    private Connection connection = null;
    public void makeConnection(){
        //The URL used to make the connection to SQLServer
        String url="jdbc:sqlserver://localhost:1433;databaseName=IngenieriaSoftware";
        /*
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: "+e);
        }
        */
        try {
            //Stablish the connection to the DB using the previous URL, the user "sa" and the password "querty"
            this.connection = DriverManager.getConnection(url,"sa","qwerty");
        } catch (SQLException e) {
            System.err.println("ERROR: "+e);
        }
    }
    public Connection getConnection(){
        //Resturns the connection to the DB
        return this.connection;
    }
}
