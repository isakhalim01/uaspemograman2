/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordmanager;

import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MisonoMika
 */
public class Query {
    Connection c = Utils.dbUtils();
    public void insert(String platform, String nama_akun, String user, String pass) {
        // Query INSERT
        String insertQuery = "INSERT INTO saved_password (platform, nama_akun, user, pass) VALUES (?, ?, ?, ?)";

        try {
            // Memastikan koneksi tidak null
            if (c != null) {
                // Membuat PreparedStatement
                PreparedStatement prst = c.prepareStatement(insertQuery);

                // Mengisi parameter pada query
                prst.setString(1, platform); // Untuk nim (string)
                prst.setString(2, nama_akun); // Untuk nama (string)
                prst.setString(3, user); // Untuk alamat (string)
                prst.setString(4, pass); // Untuk jenis kelamin (string)

                // Menjalankan query INSERT
                int rowsInserted = prst.executeUpdate();

                // Menampilkan hasil
                if (rowsInserted > 0) {
                    System.out.println("Data berhasil dimasukkan!");
                } else {
                    System.out.println("Data gagal dimasukkan");
                }
            } else {
                System.out.println("Koneksi tidak tersedia");
            }

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat menginsert data: " + e.getMessage());
        }
    }
    
    public void delete(String nama_akun) {
    try {
        PreparedStatement pst = null;
        String sql = "DELETE FROM saved_password WHERE nama_akun = ?";
        pst = c.prepareStatement(sql);
        pst.setString(1, nama_akun);
        pst.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    public void update(String nama_akun, String user, String pass) {
    try {
        PreparedStatement pst = null;
        String sql = "UPDATE saved_password SET user = ?, pass = ? WHERE nama_akun = ?";
        pst = c.prepareStatement(sql);
        pst.setString(1, user);
        pst.setString(2, pass);
        pst.setString(3, nama_akun);
        pst.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
}
