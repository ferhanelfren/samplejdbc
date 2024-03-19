/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import JDBC.JDBCConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.UserDAO;

/**
 *
 * @author Student
 */
public class student {
    
    private Connection connection;
    private JDBCConnector jdbccon;
    private PreparedStatement ps;
    private String sql;
    
    public student() {
        this.jdbccon = new JDBCConnector();
        this.connection = new JDBCConnector().getConnection();
    }
    
    public void addStudent(UserDAO userdao) {
        try {
            sql = "INSERT into student (fname, mname, lname, age) values(?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userdao.getFName());
            ps.setString(2, userdao.getMName());
            ps.setString(3, userdao.getLName());
            ps.setInt(4, userdao.getAge());
            
            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Student successfully added.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Student.");
            }
        } catch (Exception e) {
             Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, e);
        }
 
    }
}
