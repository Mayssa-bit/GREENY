/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. blalba
 */
package DataBase;

import Entities.Event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HIDOUS MAYSSA
 */
public class MyConnection {

    private static MyConnection instance;
    private Connection cnx;

    final String url = "jdbc:mysql://localhost:3306/esprit";
    final String login = "root";
    final String password = "";

    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, password);
            System.out.println("connexion établie!!!!");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MyConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MyConnection();
        }

        return instance;
    }
}
