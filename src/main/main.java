/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import JDBC.JDBCConnector;
import controller.addStudent;
import java.sql.Connection;

/**
 *
 * @author Student
 */
public class main {

    public static void JDBCConnect() {
    JDBCConnector connect = new JDBCConnector();  
        try {
            Connection jihyo = connect.getConnection();
            if (jihyo != null) {
                System.out.println("ONE IN A MILLION!");
            }
            else {
                System.out.println("TWICETAGRAM.");
            }
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        JDBCConnect();
        addStudent addstudent = new addStudent();
        addstudent.setVisible(true);
    }
    
}
