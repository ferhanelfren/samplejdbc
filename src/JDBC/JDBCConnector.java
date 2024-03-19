/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Student
 */
public class JDBCConnector {
    public Connection getConnection() {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem"
                   , "root", "root");
        } catch (ClassNotFoundException |SQLException e) {
            Logger.getLogger(JDBCConnector.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return null;
        
        
    }
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            Logger.getLogger(JDBCConnector.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
