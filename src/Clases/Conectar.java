/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.swing.JOptionPane;

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
    
//    public Connection conexion() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println("Loaded SQL Server JDBC driver");
//            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbo;user=usersql;password=root2;encrypt=false");
//            System.out.println("Conectado");
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return cn;
//
//    }
    
    
    public Connection conexion() {
    Connection cn = null;
    
    try {
        File xmlFile = new File("config.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        String server = doc.getElementsByTagName("server").item(0).getTextContent();
        String port = doc.getElementsByTagName("port").item(0).getTextContent();
        String database = doc.getElementsByTagName("database").item(0).getTextContent();
        String username = doc.getElementsByTagName("username").item(0).getTextContent();
        String password = doc.getElementsByTagName("password").item(0).getTextContent();

        String connectionString = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + database + ";user=" + username + ";password=" + password + ";encrypt=false";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Loaded SQL Server JDBC driver");

        cn = DriverManager.getConnection(connectionString);
        System.out.println("Conectado");
    } catch (Exception e) {
        System.err.println(e.getMessage());
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    
    return cn;
}
}


