/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Impl;

import  DataBase.ConnexionBD;
import Entites.Commandes;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static test.Test.convert;
  
/**
 *
 * @author g
 */
public class Commandesercices {
   Connection cn = ConnexionBD.getInstance().getCnx();
    ConnexionBD cnx = ConnexionBD.getInstance();
   
   

    
    
       public  void ajouterAlaBase(Commandes cm) throws SQLException, ParseException {
     
           
             //   LocalDate date = LocalDate.now();
                
            //    Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
           //   Date datec = Calendar.getInstance().getTime();
           //  SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");  
          //   SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd"); 
          //    Date datec =Calendar.getInstance().getTime();
           //   Date Datear = Calendar.getInstance().getTime();
           //  SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");  
          // SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd"); 
          //   Date date = new Date();
            //  String s = d.
             String m = "2019-01-28";
    java.util.Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(m);
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    Date d = new Date();
      //  Calendar cal = Calendar.getInstance(); 
        System.out.println(d);
    //java.sql.Date sqlDat = convert(d);    
            
                    User v = new User();
        //File im = new File("C:/wamp64/www/image/"+u.getPhotoURL().toString());

        UserService sv = new UserService();
        try {
            v = sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
        } catch (SQLException ex) {
            Logger.getLogger(UserHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
              String req = "INSERT INTO `commandes`(`Idc`, `Idp`, `idu`,`nomproduit`, `adresse`, `email`, `numu`, `quantité`, `Prixcom`, `datec`, `Datear`,`nom`,`prenom`,`image`,`prixprod`,`validation`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
              PreparedStatement pstm = cn.prepareStatement(req);
             
              pstm.setInt(1, cm.getIdc());
              pstm.setInt(2, cm.getIdp());
              pstm.setInt(3, v.getId());
              pstm.setString(4, cm.getProdname());
              pstm.setString(5, v.getAdresse());
              pstm.setString(6, v.getEmail());
              pstm.setInt(7, v.getPhone());
              pstm.setInt(8, cm.getQuantité());
              pstm.setInt(9, cm.getQuantité()*cm.getPrixprod());
              pstm.setTimestamp(10, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
              pstm.setDate(11, (java.sql.Date) cm.getDatear());
              pstm.setString(12, v.getNom());
              pstm.setString(13, v.getPrenom());
               
                pstm.setString(14, cm.getImage());
               
                 pstm.setInt(15, cm.getPrixprod());
                 pstm.setString(16, "non validée");
                 
               
              
            
           
           
             
             pstm.executeUpdate();
        
    }
       public int calculerprixcomm(Commandes cm){
          int a=  cm.getQuantité();
            int b   = cm.getPrixprod();
            
           int c=a*b;
            return c;
            
       }
      
       
       
       public void valide(Commandes cm) throws SQLException{
       String req = "SELECT * FROM commandes WHERE Validation= 'Validée'";
       Statement s=cn.createStatement() ;
      s.executeUpdate(req);
       }
       
       public void supprimerCommande(Commandes cm) throws SQLException {
           try {
            String requete = "DELETE FROM commandes WHERE idc=?";
            
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, cm.getIdc());
            pst.executeUpdate();
            System.out.println("Produit supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
       }
       
        public List<Commandes> comarerdate(Date D) throws SQLException, ParseException{
   
        
           List<Commandes> user = new ArrayList<Commandes>();
        String req="select * from commandes where datear="+D;
        Statement stm=cn.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
        Commandes p = new Commandes(rst.getInt("idc"),rst.getInt("idu"),rst.getInt("idp")
                ,rst.getString("nomproduit")
                ,rst.getString("adresse")
                ,rst.getString("email")
               
                ,rst.getInt("numu")
                ,rst.getInt("quantité")
                ,rst.getInt("Prixcom")
                  ,rst.getTimestamp("datec")
            
                
                ,rst.getDate("datear")
                
                ,rst.getString("nom")
                ,rst.getString("prenom")
               
                
                ,rst.getString("image")
                ,rst.getInt("prixprod")
                ,rst.getString("validation")


           
                
        );
         user.add(p);}
        
        return user;
      
      
        
        
        
        
        
        }
       
       
       public List<Commandes> getAllcommandes() throws SQLException
    {
        
        List<Commandes> user = new ArrayList<Commandes>();
        String req="select *  from commandes";
        Statement stm=cn.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
        Commandes p = new Commandes(rst.getInt("idc"),rst.getInt("idu"),rst.getInt("idp")
                ,rst.getString("nomproduit")
                ,rst.getString("adresse")
                ,rst.getString("email")
               
                ,rst.getInt("numu")
                ,rst.getInt("quantité")
                ,rst.getInt("Prixcom")
                  ,rst.getTimestamp("datec")
                ,rst.getDate("datear")
                
                ,rst.getString("nom")
                ,rst.getString("prenom")
               
                
                ,rst.getString("image")
                ,rst.getInt("prixprod")
                ,rst.getString("validation")


           
                
        );
//First_name`=?,`Last_name`=?,`email`=?,`password`=?,`Mobile`=?,`Address`=
//ps.setString(1,u.getFirst_name());
//              ps.setString(2,u.getLast_name());
//              ps.setString(3,u.getEmail());
//              ps.setString(4,u.getPassword());
//              ps.setInt(5,u.getMobile_number());
//              ps.setString(6,u.getAddress());
//              ps.setString(7,n);
//              ps.executeUpdate();
        user.add(p);
        
    }
        return user;
 
    }
       public List<Commandes> getAllcommandesvalide() throws SQLException
    {
        
        List<Commandes> user = new ArrayList<Commandes>();
        String req="select *  from commandes where Validation= 'Validée'";
        Statement stm=cn.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
        Commandes p = new Commandes(rst.getInt("idc"),rst.getInt("idu"),rst.getInt("idp")
                ,rst.getString("nomproduit")
                ,rst.getString("adresse")
                ,rst.getString("email")
               
                ,rst.getInt("numu")
                ,rst.getInt("quantité")
                ,rst.getInt("Prixcom")
                  ,rst.getTimestamp("datec")
                ,rst.getDate("datear")
                
                ,rst.getString("nom")
                ,rst.getString("prenom")
               
                
                ,rst.getString("image")
                ,rst.getInt("prixprod")
                ,rst.getString("validation")


           
                
        );   
        
        
        
//First_name`=?,`Last_name`=?,`email`=?,`password`=?,`Mobile`=?,`Address`=
//ps.setString(1,u.getFirst_name());
//              ps.setString(2,u.getLast_name());
//              ps.setString(3,u.getEmail());
//              ps.setString(4,u.getPassword());
//              ps.setInt(5,u.getMobile_number());
//              ps.setString(6,u.getAddress());
//              ps.setString(7,n);
//              ps.executeUpdate();
        user.add(p);
        
    }
        return user;
 
    } 
       
       
       
            public Commandes findbyid(Integer id) {
 Commandes m=new Commandes();
        try {
           
            String req="Select * from commandes where idc=?";
            PreparedStatement stm = cn.prepareStatement(req);
            stm.setInt(1, id);
            ResultSet rs =stm.executeQuery();
             while (rs.next()) {
                 m.setIdc(id);
                 m.setIdc(rs.getInt("idu"));
                 m.setIdp(rs.getInt("idp"));
                 m.setAdresse(rs.getString("adresse"));
                 m.setEmail(rs.getString("email"));
                 m.setNumu(rs.getInt("numu"));
                 m.setQuantité(rs.getInt("quantité"));
                 m.setPrixcom(rs.getInt("prixcom"));
                 m.setNumu(rs.getInt("numu"));
                 m.setDatec(rs.getTimestamp("datec"));
                 m.setDatear(rs.getTimestamp("datear"));
                 m.setNom(rs.getString("nom"));
                 m.setPrenom(rs.getString("prenom"));
                 m.setProdname(rs.getString("nomproduit"));

             }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Commandesercices.class.getName()).log(Level.SEVERE, null, ex);
        }
      return m;
    }
       
       
       
       
       
       
       
       
       
       
       
       public List<Commandes> getAllComdProById(int id) throws SQLException
    {
        
        List<Commandes> cmdpros = new ArrayList<Commandes>();
        String req="select * from commandes where idu="+id;
        Statement stm=cn.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
      Commandes p = new Commandes(rst.getInt("idc"),rst.getInt("idu"),rst.getInt("idp")
                ,rst.getString("adresse")
                ,rst.getString("email")
                , rst.getInt("numu")
                ,rst.getInt("quantité")
                ,rst.getInt("Prixcom")
                  ,rst.getDate("datec")
                ,rst.getDate("datear")
                
                ,rst.getString("nom")
                ,rst.getString("prenom")

            ,rst.getString("nomproduit")
                
        );
        cmdpros.add(p);
        
    }
        return cmdpros;
    }
       public int PrixTotal(int idu ) throws SQLException{
       
       int Prix =0 ;
       
        List<Commandes> com = new ArrayList<Commandes>();
         com=getAllComdProById(idu);
        for (int i=0;i<com.size();i++){
       Prix+=com.get(i).getPrixcom();


        
        }
       
       
    return Prix;
       }
       
       
       public void ModifierComdPro(Commandes cp , int id) throws SQLException
    {
        String req="UPDATE commandes SET `idu`='"  + cp.getIdu()+ "',`idp`='"  + cp.getIdp()+
            "',`adresse`='"  + cp.getAdresse()+ "',`email`='"  + cp.getEmail()+ "',`numu`='"  + cp.getNumu()+ "',`quantité`='"  + cp.getQuantité()+ "',`Prixcom`='"  
                + cp.getPrixcom()+ "',`datec`='"  + cp.getDatec()+ "',`datear`='"  
                + cp.getDatear()+ "',`nom`='"  + cp.getNom()+ "',`prenom`='"  + cp.getPrenom()+ "',`nomproduit`='"  + cp.getProdname()+ "',`image`='"  + cp.getImage()+"',`prixprod`='"  + cp.getPrixprod()+"',`Validation`='"  + cp.getValidation()+"'where idc="+id ;
      Statement s=cn.createStatement() ;
      s.executeUpdate(req);
    }
        public void ModifierComdPro2(Commandes cp , int id) throws SQLException
        {
            String req="UPDATE commandes SET `quantité`='"  + cp.getQuantité()+ "',`datear`='"  
                + cp.getDatear()+ "',`Prixcom`='"  
                + cp.getPrixcom()+"'where idc="+id ;
            Statement s=cn.createStatement() ;
      s.executeUpdate(req);
        }
         public void ModifierComdPro3(Commandes cp , int id) throws SQLException{
         String req="UPDATE commandes SET Validation= 'Validée' where idc="+id ;
              Statement s=cn.createStatement() ;
      s.executeUpdate(req);
         }
       
       
       
         public void SupprimerComdPro(int id ) throws SQLException 
 {
        String re= "DELETE FROM `commandes` WHERE Idc="+id;
        Statement stm=cn.createStatement();
        stm.executeUpdate(re);				
}
     public void updateEvents(Commandes E) throws ParseException {
         
         
         String m = "2019-01-28";
    java.util.Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(m);
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    Date d = new Date();
      //  Calendar cal = Calendar.getInstance(); 
        System.out.println(d);
//    java.sql.Date sqlDat = convert(d);   

         try {       
           String req = "UPDATE `event`SET `idc`=?,`idp`=?,`idu`=?,`adresse`=?,`email`=?,`numu`=?`quantite`=?,`Prixcomm`=?,`datec`=?,`datear`=?,`nom`=?,`prenom`=?,`nomproduit`=?,`image`=?,`prixprod`=? WHERE `idc`=?";
           PreparedStatement stm = cn.prepareStatement(req);
            stm.setInt(1, E.getIdc());
            stm.setInt(2, E.getIdp());
            stm.setInt(3, E.getIdu());
            stm.setString(4, E.getAdresse());
           
            stm.setString(5, E.getEmail());
             stm.setInt(6, E.getNumu());
             stm.setInt(7, E.getQuantité());
             stm.setInt(8, E.getPrixcom());
             stm.setTimestamp(9, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));;
             stm.setDate(10, (java.sql.Date) E.getDatear());
             stm.setString(11, E.getNom());
             stm.setString(12, E.getPrenom());
               stm.setString(13, E.getProdname());
               
                stm.setString(14, E.getImage());
               
                 stm.setInt(15, E.getPrixprod());
            

            stm.executeUpdate();
        } catch (SQLException e) {
             Logger.getLogger(Commandesercices.class.getName()).log(Level.SEVERE, null, e);
        }    
        }       
     
     
     
     
      public void deleteClient1(int a) throws SQLException {

     PreparedStatement stm = cn.prepareStatement("update commandes set enabled='validée' where idc=?");
  //  stm.setString(14, validation);
    //stm.setBoolean(2, enabled);
    int executeUpdate = (int) stm.executeUpdate();

}
         
       
      
      
      
      
      
      
      
      
      
      
      public List<Commandes> chercher(String email){
        String req="select * from commandes where Validation= 'Validée' AND email like '"+email+"'";
        List<Commandes> list=new ArrayList<>();
        try {
            Statement ste = cn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
               
                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
              list.add(new Commandes(rs.getString("adresse"),rs.getString("email"),rs.getInt("numu"),rs.getInt("quantité"),rs.getInt("prixcom"),rs.getDate("datec"),rs.getDate("datear"),rs.getString("nom"),rs.getString("prenom"),rs.getString("nomproduit"),rs.getString("image"),rs.getInt("Prixprod"),rs.getString("Validation")));  
                //list.add(new Event(rs.getInt("numero"),rs.getString("dateann"),rs.getString("nom"), rs.getString("prenom"),rs.getString("type"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Commandesercices.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
        
    }
      
      
         public int  nbrnonvalide() throws SQLException{
   List<Commandes> lis = new ArrayList<Commandes>();
   lis=getAllcommandenonsvalide();
   int s = lis.size();
        return s;
       
       } 
      
      
         public int  total() throws SQLException{
   List<Commandes> lis = new ArrayList<Commandes>();
   lis=getAllcommandes();
   int s = lis.size();
        return s;
       
       }  
      
      
      public int  nbrvalide() throws SQLException{
   List<Commandes> lis = new ArrayList<Commandes>();
   lis=getAllcommandesvalide();
   int s = lis.size();
        return s;
       
       }
      
      
      
      
      public List<Commandes> getAllcommandenonsvalide() throws SQLException
    {
        
        List<Commandes> user = new ArrayList<Commandes>();
        String req="select *  from commandes where Validation= 'non validée'";
        Statement stm=cn.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while(rst.next()){
        Commandes p = new Commandes(rst.getInt("idc"),rst.getInt("idu"),rst.getInt("idp")
                ,rst.getString("nomproduit")
                ,rst.getString("adresse")
                ,rst.getString("email")
               
                ,rst.getInt("numu")
                ,rst.getInt("quantité")
                ,rst.getInt("Prixcom")
                  ,rst.getTimestamp("datec")
                ,rst.getDate("datear")
                
                ,rst.getString("nom")
                ,rst.getString("prenom")
               
                
                ,rst.getString("image")
                ,rst.getInt("prixprod")
                ,rst.getString("validation")


           
                
        );
         user.add(p);}
        
        return user;
      
      
    
      
      
      
      
      
    }  
     
   public List<Commandes> rrrr(String d) throws SQLException{
   
   
   List<Commandes> l = new ArrayList<Commandes>();
    List<Commandes> li = new ArrayList<Commandes>();
   l=getAllcommandesvalide();
   
   for (int i=0;i<l.size();i++){
   
   if(l.get(i).getDatear().toString().equalsIgnoreCase(d))
   {
   
   li.add(l.get(i));
   
   }
   
   }
        return li;
   
   
   }   
      
      
    public int calculer () throws SQLException{
    int tt=0;
    List<Commandes> li  = new ArrayList<Commandes>(); 
    li= getAllcommandesvalide(); 
    for (int i=0 ; i<li.size();i++)
    {
    tt+=li.get(i).getPrixcom();
    
    
    
    
    }    
    
    
    
    
    return tt;
    } 
      
       public boolean quantitéisValid(String quantité)
    {
        int taille = quantité.length();
        if( taille==1 && isInt(quantité))
        {
            return true;
        }
        else return false;
        
    }
   
    public boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }
    
    
     
   public boolean dateIsValid (LocalDate d){
        
            LocalDate x=  LocalDate.now();
            x.getYear();
            x.getMonthValue();
            x.getDayOfMonth();
            
            
            System.out.println(x.getYear()+""+x.getMonthValue()+""+x.getDayOfMonth());
            System.out.println(d.getYear()+"xx"+d.getMonth()+"xx"+d.getDayOfMonth());
            if (x.getYear()<=d.getYear() && x.getMonthValue()<=d.getMonthValue()&& x.getDayOfMonth()<=d.getDayOfMonth()){
          return true;
            }else 
                return false;
        }
}

    
    
    
    
    
      
      
      
    
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
     

    