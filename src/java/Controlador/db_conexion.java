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
    
    
    public static Connection getConnection(){
        Connection connection = null;
        String user = "sa";
        String password = "qwerty";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=IngenieriaSoftware";
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
             System.err.println("ERROR: "+e);
        } catch (SQLException e){
            System.err.println("ERROR: "+e);
        }catch (Exception e){
            System.err.println("ERROR: " +e);
        }
        //Resturns the connection to the DB
        return connection;
    }
}
