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
            sql = "INSERT into student (fname, mname, lname, age, address, gender, civilstat) values(?, ?, ?, ?, ?, ?, ?)";
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
            sql = "SELECT * FROM student";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            rsd = rs.getMetaData();
            int colmnsNumber = rsd.getColumnCount();
            
            while(rs.next()){
             Object[] row = new Object[colmnsNumber];
                for (int i = 1; i <= colmnsNumber; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                
                tableModel.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void updateStudent(UserDAO userdao, int studentId){
        try {
            sql = "UPDATE student SET fname=?, mname=?, lname=?, age=?, address=?, gender=?, civilstat=? WHERE idstudent=?";
             ps = connection.prepareStatement(sql);
            ps.setString(1, userdao.getFName());
            ps.setString(2, userdao.getMName());
            ps.setString(3, userdao.getLName());
            ps.setInt(4, userdao.getAge());
            ps.setString(5, userdao.getAddress());
            ps.setString(6, userdao.getGender());
            ps.setString(7, userdao.getCivilStatus());
            ps.setInt(8, studentId);
            
            
            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Student record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update student record.");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteStudent(int studentId) {
        try {
            sql = "DELETE FROM student WHERE idstudent=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Student record deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete student record.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(DefaultTableModel model, String searchTerm){
        try {
            model.setRowCount(0);
            sql = "SELECT * FROM student WHERE fname LIKE ? OR lname LIKE ?";
            ps = connection.prepareStatement(sql);
             ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");
            rs = ps.executeQuery();
            rsd = rs.getMetaData();
            
            int colNumber = rsd.getColumnCount();
            
             while (rs.next()) {
                Object[] row = new Object[colNumber];
                for (int i = 1; i <= colNumber; i++) {
                    row[i - 1] = rs.getObject(i);
                }

                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
