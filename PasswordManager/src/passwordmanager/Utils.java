/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MisonoMika
 */
public class Utils {
    public static Connection dbUtils(){
        try
        {
             Class.forName ("com.mysql.cj.jdbc.Driver");
             return DriverManager.getConnection("jdbc:mysql://localhost/password_manager", "root", "");
        } catch (Exception e) {
             System.out.println("Koneksi Gagal" + e.getMessage());
             return null;
        }
    }
    
    //Connection c = dbUtils();
}
