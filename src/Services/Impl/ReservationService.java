/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import DataBase.ConnexionBD;
import Entites.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HIDOUS MAYSSA
 */
public class ReservationService {

    Connection ds;

    public ReservationService() throws SQLException {
        ds = ConnexionBD.getInstance().getCnx();
    }

    public int reserver(Reservation R) {
        try {
            String req2 = "SELECT nbPlace FROM event WHERE idEvenement= " + R.getIdevent();  
            PreparedStatement ste2 = ds.prepareStatement(req2);
            ResultSet rs = ste2.executeQuery(req2);
            rs.first();
            int q = rs.getInt(1);

            if (q - R.getNbp() < 0) {
                return 0;
            }
            String req = "INSERT INTO  reservation(iduser,idevent,nbp)" + "VALUES ('" + R.getIduser() + "','" + R.getIdevent() + "','" + R.getNbp() + "')"; 
            PreparedStatement ste = ds.prepareStatement(req);
            ste.executeUpdate(req);
            String req1 = "UPDATE  event SET nbPlace=nbPlace-" + R.getNbp() + " WHERE idEvenement =" + R.getIdevent(); 
            PreparedStatement ste1 = ds.prepareStatement(req1);
            ste1.executeUpdate(req1);
            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur d'insertion");
        }
        return 0;
    }

}
