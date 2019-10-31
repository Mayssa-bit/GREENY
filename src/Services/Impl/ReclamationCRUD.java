/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;




import DataBase.ConnexionBD;
import Entites.Reclamation;
import Entites.User;
import Entites.UserSession;
import Gui.UserHomeController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ReclamationCRUD {
  ConnexionBD myc = ConnexionBD.getInstance();
    Connection cnx=myc.getCnx();
  
    
    
    /*public void ajouterReclamation(Reclamation r){
           String requete = "INSERT INTO reclamation (type,iduser,nom,region,date,description,etat)"
                + "VALUES ('"+r.getType()+"','"+r.getIduser()+"','"+r.getNom()+"','"+r.getRegion()+"','"+r.getDate()+"','"+r.getDescription()+"','"+r.getEtat()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Reclamation ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion");
        }
    }*/
    public void ajouterReclamation(Reclamation r) throws ParseException{
        
             String m = "2019-01-28";
    java.util.Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(m);
   java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    Date d = new Date();
      //  Calendar cal = Calendar.getInstance(); 
        System.out.println(d);
    java.sql.Date sqlDat = convert(d);    
    
                    User v = new User();
        //File im = new File("C:/wamp64/www/image/"+u.getPhotoURL().toString());

        UserService sv = new UserService();
        try {
            v = sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
        } catch (SQLException ex) {
            Logger.getLogger(UserHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
           String requete = "INSERT INTO reclamation (type,iduser,nom,region,date,description,etat)"
                + "VALUES ('"+r.getType()+"','"+v.getId()+"','"+v.getNom()+"','"+v.getAdresse()+"','"+java.sql.Timestamp.valueOf(java.time.LocalDateTime.now())+"','"+r.getDescription()+"','"+r.getEtat()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Reclamation ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion");
        }
    }
    
    
    
    
    
    
    
    
    
    
     
    public void modifierReclamation(Reclamation r,int idreclamation){
        String requete = "UPDATE reclamation SET type=?,iduser=?,nom=?,region=?,date=?,description=?,etat=? WHERE idreclamation=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, r.getType());
            pst.setInt(2, r.getIduser());
             pst.setString(3, r.getNom());
                 pst.setString(4, r.getRegion());
                     pst.setTimestamp(5,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                         pst.setString(6, r.getDescription());
                             pst.setString(7, r.getEtat());
            pst.setInt(8, idreclamation);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierEtat(Reclamation r){
        String requete = "UPDATE reclamation SET etat= ? WHERE idreclamation=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
           
                             pst.setString(1, "traiter");
                               pst.setInt(2,r.getIdreclamation());
                             
           
            pst.executeUpdate();
           // sms();
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
    
    
  public void supprimerReclamation(Reclamation r){
        try {
            String requete = "DELETE FROM reclamation WHERE idreclamation=?";
            
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, r.getIdreclamation());
            pst.executeUpdate();
            System.out.println("Reclamation supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
  
  
    public List<Reclamation> getAllcommandes() throws SQLException
    {
        
        List<Reclamation> user = new ArrayList<Reclamation>();
        
                    User v = new User();
        //File im = new File("C:/wamp64/www/image/"+u.getPhotoURL().toString());

        UserService sv = new UserService();
        try {
            v = sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
        } catch (SQLException ex) {
            Logger.getLogger(UserHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String req="select *  from Reclamation WHERE iduser= "+v.getId();
        Statement stm=cnx.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
        Reclamation p = new Reclamation(rst.getInt("idreclamation"), rst.getString("type"),rst.getInt("iduser")
                ,rst.getString("nom")
                ,rst.getString("region")
                 ,rst.getTimestamp("date")
                 ,rst.getString("description")
                 ,rst.getString("etat"));
        
       user.add(p);
        
    }
        return user;
 
    }
    
     public List<Reclamation> getAllcommandesFiltrer(String type) throws SQLException
    {
        
        List<Reclamation> user = new ArrayList<Reclamation>();
        String req="select *  from Reclamation WHERE type= ?" ;
       PreparedStatement stm = cnx.prepareStatement(req);
            stm.setString(1, type);
            ResultSet rst =stm.executeQuery();
        
        while(rst.next()){
        Reclamation p = new Reclamation(rst.getInt("idreclamation"), rst.getString("type"),rst.getInt("iduser")
                ,rst.getString("nom")
                ,rst.getString("region")
                 ,rst.getTimestamp("date")
                 ,rst.getString("description")
                 ,rst.getString("etat"));
        
       user.add(p);
        
    }
        return user;
 
    }
        
    
    public List<Reclamation> getAlReclamationById() throws SQLException
    {
        
        List<Reclamation> user = new ArrayList<Reclamation>();
        String req="select *  from Reclamation GROUP BY iduser ";
        Statement stm=cnx.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
        Reclamation p = new Reclamation(rst.getInt("idreclamation"), rst.getString("type"),rst.getInt("iduser")
                ,rst.getString("nom")
                ,rst.getString("region")
                 ,rst.getTimestamp("date")
                 ,rst.getString("description")
                 ,rst.getString("etat"));
        
       user.add(p);
        
    }
        return user;
 
    }
    
    
       public List<Reclamation> getAlReclamationID(int id) throws SQLException
    {
        
        List<Reclamation> user = new ArrayList<Reclamation>();
        String req="select *  from Reclamation WHERE iduser=? ";
        
          PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, id);
            ResultSet rst =stm.executeQuery();
        
        
        
    
        
        while(rst.next()){
        Reclamation p = new Reclamation(rst.getInt("idreclamation"), rst.getString("type"),rst.getInt("iduser")
                ,rst.getString("nom")
                ,rst.getString("region")
                 ,rst.getTimestamp("date")
                 ,rst.getString("description")
                 ,rst.getString("etat"));
        
       user.add(p);
        
    }
        return user;
 
    }
        
              
                
       
 /*   
    public List<Personne> displayPersons(){
        List<Personne> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personne";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }   
    
   */ 
        public static java.sql.Date convert(java.util.Date date)
	{
		return new java.sql.Date(date.getTime());
	}
        
       
public List<Reclamation> chercher(String nom_cat) {
        String req = "select * from Reclamation GROUP BY iduser  HAVING region like '"+nom_cat+"'";
        List<Reclamation> list = new ArrayList<>();
        try {
            Statement st = ConnexionBD.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                list.add(new Reclamation(rs.getInt("idreclamation"), rs.getString("type"),rs.getInt("iduser"),rs.getString("nom"),rs.getString("region"),rs.getDate("date"), rs.getString("description"), rs.getString("etat")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }


       public List<Reclamation> getAlReclamationIDFiltre(int id,String type) throws SQLException
    {
        
        List<Reclamation> user = new ArrayList<Reclamation>();
        String req="select *  from Reclamation WHERE iduser=? AND etat=? ";
        
          PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, id);
            stm.setString(2, type);
            ResultSet rst =stm.executeQuery();
        
        
        
    
        
        while(rst.next()){
        Reclamation p = new Reclamation(rst.getInt("idreclamation"), rst.getString("type"),rst.getInt("iduser")
                ,rst.getString("nom")
                ,rst.getString("region")
                 ,rst.getTimestamp("date")
                 ,rst.getString("description")
                 ,rst.getString("etat"));
        
       user.add(p);
        
    }
        return user;
 
    }   

}