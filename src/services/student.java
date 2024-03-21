/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import JDBC.JDBCConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UserDAO;

/**
 *
 * @author Student
 */
public class student {
    
    private Connection connection;
    private JDBCConnector jdbccon;
    private PreparedStatement ps;
    private String sql, sql2;
    private ResultSet rs;
    private ResultSetMetaData rsd;
    
    public student() {
        this.jdbccon = new JDBCConnector();
        this.connection = new JDBCConnector().getConnection();
    }
    
    public void addStudent(UserDAO userdao) {
        try {
            sql = "INSERT into students (fname, mname, lname, age, address, gender, civilstat) values(?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userdao.getFName());
            ps.setString(2, userdao.getMName());
            ps.setString(3, userdao.getLName());
            ps.setInt(4, userdao.getAge());
            ps.setString(5, userdao.getAddress());
            ps.setString(6, userdao.getGender());
            ps.setString(7, userdao.getCivilStatus());
            
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
    
    
    public void populateStudentTable(DefaultTableModel tableModel){
        try {
            tableModel.setRowCount(0);
            sql = "SELECT * FROM students";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            rsd = rs.getMetaData();
            int colmnsNumber = rsd.getColumnCount();
            
            while (rs.next()) {
                Object[] row = new Object[colmnsNumber];
                for (int i = 1; i <= colmnsNumber; i++) { // Adjusted the loop condition here
                    Object value = rs.getObject(i);
                    if (value != null) {
                        row[i - 1] = value.toString();
                    } else {
                        row[i - 1] = null; // Or any default value you want to assign for null values
                    }
                }
                tableModel.addRow(row);
            }
            
            
            
            
            
            
        } catch (Exception e) {
        }
    }
    
}
