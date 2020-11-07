/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.shardx.jasper.reports.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Shady
 */
public class Connect {

    public Connect() {

    }

    public static Connection getConnection() {
        Connection cnn = null;
        String myUrl = "jdbc:mysql://localhost:3306/CollegeMIS?zeroDateTimeBehavior=ROUND";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection(myUrl, "root", "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnn;
    }

    public static void close(Connection cnn) {
        try {
            cnn.close();
        } catch (Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
