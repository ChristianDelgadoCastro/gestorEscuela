/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 *
 * @author Christian Delgado
 */
public class Conectar {

    Connection cn;
    Statement st;

//    public Connection conexion(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/escuelapropuesta","root","root");
//            System.out.println("Conectado");
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return cn;
//    }
//}
    
    
//    public Connection conexion() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println("Loaded SQL Server JDBC driver");
//            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=iciibaSFR;user=usersql;password=root2;encrypt=false");
//            System.out.println("Conectado");
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return cn;
//
//    }
    
    public Connection conexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Loaded SQL Server JDBC driver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbo;user=usersql;password=root2;encrypt=false");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cn;

    }
    
}


