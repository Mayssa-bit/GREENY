/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.MyConnection;
import Entities.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mayss
 */
public class ReservationService {
     Connection ds;

    public ReservationService() throws SQLException {
         ds = MyConnection.getInstance().getCnx();
    }
    public int reserver (Reservation R)
    {
        try { 
            String req2="SELECT nbPlace from event where idEvenement= "+ R.getIdevent();
            //String req="INSERT INTO event (nomEvenement,adresse,dateDebut,dateFin,etat,nbPlace,nbStand,prix,image) VALUES(?,?,?,?,?,?,?,?,?)" ;  
            PreparedStatement ste2 = ds.prepareStatement(req2) ;
            ResultSet rs=ste2.executeQuery(req2) ; 
           rs.first();
           int q=rs.getInt(1);
            
            if(q-R.getNbp()<0) return 0;
            String req="INSERT INTO  reservation(iduser,idevent,nbp)"+"VALUES ('"+R.getIduser()+"','"+R.getIdevent()+"','"+R.getNbp()+"')";
            //String req="INSERT INTO event (nomEvenement,adresse,dateDebut,dateFin,etat,nbPlace,nbStand,prix,image) VALUES(?,?,?,?,?,?,?,?,?)" ;  
            PreparedStatement ste = ds.prepareStatement(req) ;
            ste.executeUpdate(req) ; 
            String req1="UPDATE  event set nbPlace=nbPlace-"+R.getNbp()+" where idEvenement ="+ R.getIdevent();
            //String req="INSERT INTO event (nomEvenement,adresse,dateDebut,dateFin,etat,nbPlace,nbStand,prix,image) VALUES(?,?,?,?,?,?,?,?,?)" ;  
            
            PreparedStatement ste1 = ds.prepareStatement(req1) ;
            ste1.executeUpdate(req1) ; 
            return 1;
           
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur insertion");
        }
    return 0;
    }
    
    
    
}
