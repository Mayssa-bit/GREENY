/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.MyConnection;
import Entities.Event;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HIDOUS MAYSSA
 */
public class EventService {

    Connection ds;

    public EventService() throws SQLException {
        ds = MyConnection.getInstance().getCnx();
    }

    public void insererEvenement(Event e) {
        try {
            String req = "INSERT INTO  event(nomEvenement,adresse,dateDebut,dateFin,etat,nbPlace,nbStand,prix,image)" + "VALUES ('" + e.getNomEvenement() + "','" + e.getAdresse() + "','" + e.getDateDebut() + "','" + e.getDateFin() + "','" + e.getEtat() + "','" + e.getNbPlace() + "','" + e.getNbStand() + "','" + e.getPrix() + "','" + e.getImage() + "')"; 
            java.util.Date dateDebut = Calendar.getInstance().getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
            PreparedStatement ste = ds.prepareStatement(req);
            ste.executeUpdate(req);
            System.out.println("event ajouté");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur insertion");
        }
    }

    public void updateEvenement(Event e, int id) {
        try {
            String req = "UPDATE event SET nomEvenement=?,adresse=?,dateDebut=?,dateFin=?,etat=?,nbPlace=?,nbStand=?,prix=?,image=?  WHERE idEvenement =?";
            java.util.Date dateDebut = Calendar.getInstance().getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
            PreparedStatement ste = ds.prepareStatement(req);

            ste.setString(1, e.getNomEvenement());
            ste.setString(2, e.getAdresse());
            ste.setDate(3, e.getDateDebut());
            ste.setDate(4, e.getDateFin());
            ste.setString(5, e.getEtat());
            ste.setInt(6, e.getNbPlace());
            ste.setInt(7, e.getNbStand());
            ste.setDouble(8, e.getPrix());
            ste.setString(9, e.getImage());

            ste.setInt(10, id);
            ste.executeUpdate();
            System.out.println("Evénement modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteEvenementById(int id) {
        String req = "DELETE FROM event WHERE idEvenement =?";
        try {
            PreparedStatement ste = ds.prepareStatement(req);
            ste.setInt(1, id);
            ste.executeUpdate();
            System.out.println("Evénement supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Event> selectEvenement() {
        List<Event> list = new ArrayList<>();
        String req;
        req = "SELECT *  FROM evenement ";
        try {
            PreparedStatement ste = ds.prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Event(
                        result.getInt("idEvenement"),
                        result.getString("nomEvenement"),
                        result.getString("adresse"),
                        result.getDate("dateDebut"),
                        result.getDate("dateFin"),
                        result.getString("etat"),
                        result.getInt("nbPlace"),
                        result.getInt("nbStand"),
                        result.getInt("prix"),
                        result.getString("image")
                ));
            }

        } catch (SQLException ex) {

        }
        return list;
    }

    public List<Event> displayEvenement() throws SQLException {
        List<Event> list = new ArrayList<>();
        String req;

        try {
            req = "SELECT *  FROM event ";
            Statement ste = ds.createStatement();
            ResultSet result = ste.executeQuery(req);
            while (result.next()) {
                Event e = new Event();
                e.setIdEvenement(result.getInt(1));
                e.setNomEvenement(result.getString("nomEvenement"));
                e.setAdresse(result.getString("adresse"));
                e.setDateDebut(result.getDate("DateDebut"));
                e.setDateFin(result.getDate("DateFin"));
                e.setEtat(result.getString("etat"));
                e.setNbPlace(result.getInt("nbPlace"));
                e.setNbStand(result.getInt("nbStand"));
                e.setPrix(result.getInt("prix"));
                e.setImage(result.getString("image"));
                list.add(e);
            }

        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Event> chercher(String nomEvent) {
        String req = "SELECT * FROM event WHERE nomEvenement LIKE '" + nomEvent + "'";
        List<Event> list = new ArrayList<>();
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Event(rs.getString("nomEvenement"), rs.getString("adresse"), rs.getDate("dateDebut"), rs.getDate("dateFin"), rs.getString("etat"), rs.getInt("nbPlace"), rs.getInt("nbStand"), rs.getInt("prix"), rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }

}
