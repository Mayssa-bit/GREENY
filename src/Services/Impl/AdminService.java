/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import DataBase.ConnexionBD;
import Entites.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class AdminService {
    private Connection connection;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;
    public AdminService() {
   
    connection=ConnexionBD.getInstance().getCnx();}
    public Boolean getByLogin(Admin t) throws SQLException {
     String requete = " select * from admins where (Login=? and Password = ?)" ;
        System.out.println("b");
            pst = connection.prepareStatement(requete);
            pst.setObject(1,t.getLogin());
            pst.setObject(2,t.getPassword());
            ResultSet res= pst.executeQuery();
            while (res.next())
            {
                
               
                    System.out.println("wi=hile");
                t = new Admin(res.getString("Login"),res.getString("Password"));
                return true;
                
            };
            System.out.println("con");
            return false;
}
}
