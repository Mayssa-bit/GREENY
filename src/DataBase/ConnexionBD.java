/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author HP
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnexionBD {
      
    private  String url="jdbc:mysql://localhost:3306/pépiniére";
    private  String login ="root";
    private  String pwd="";
    private  Connection cnx;
    private static ConnexionBD instance;
    private ConnexionBD() {
         try {
            // TODO code application logic here
            cnx=DriverManager.getConnection(url, login , pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public static ConnexionBD getInstance() {
    if(instance==null)
    instance=new ConnexionBD();
    return instance;
}

    public Connection getCnx() {
        return cnx;
    }
}
