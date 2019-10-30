/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl ;

import DataBase.ConnexionBD;
import Entites.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class CategorieCRUD {
    ConnexionBD myc = ConnexionBD.getInstance();
    Connection cnx=myc.getCnx();
    
    /**
     *
     * @param c
     */
    public void ajouterCategorie(Categorie c){
        String requete = "INSERT INTO categorie (nom_cath,nom_latin)"
                + "VALUES ('"+c.getNom_cath()+"','"+c.getNom_latin()+"')";
        try {
            Statement st;
            st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Categorie ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion");
        }
    }
    
    public void modifierCategorie(Categorie c,int id_cath){
        String requete = "UPDATE categorie SET nom_cath=?,nom_latin=? WHERE id_cath=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getNom_cath());
            pst.setString(2, c.getNom_latin());
            pst.setInt(3, id_cath);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerCategorie(int id){
        try {
            String requete = "DELETE FROM categorie WHERE id_cath=?";
            
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Categorie supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public List<Categorie> afficherCategorie(){
        List<Categorie> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Categorie c = new Categorie();
                c.setId_cath(rs.getInt("id_cath"));
                c.setNom_cath(rs.getString("nom_cath"));
                c.setNom_latin(rs.getString("nom_latin"));
                 myList.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
    public List<Categorie> chercher(String nom_cath) {
        String req = "select * from categorie where nom_cath like '" + nom_cath + "'";
        List<Categorie> Mylist = new ArrayList<>();
        try {
            Statement st = ConnexionBD.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                Mylist.add(new Categorie(rs.getInt("id_cath"), rs.getString("nom_cath"), rs.getString("nom_latin")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Mylist;

    }
public boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }
    

    
   
    
}
