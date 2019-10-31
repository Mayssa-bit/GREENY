/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;


import Gui.ConsulterReclamationAdminController;
import Services.Impl.ReclamationCRUD;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Lenovo
 */
public class Reclamation {
        private int idreclamation ;
    private String type ;
    private int iduser;
    private String nom ;
    private String region ;
    private Date date ;
    private String description ;
    private String etat ;
    private Button button ;
    static boolean msg =false ;
   
   
  
 
public  Reclamation(){};


    public Reclamation(int idreclamation,String type, int iduser, String nom, String region, Date date, String description, String etat ) {
        this.idreclamation = idreclamation ;
        this.type = type;
        this.iduser = iduser;
        this.nom = nom;
        this.region = region;
        this.date = date;
        this.description = description;
        this.etat = etat;
        this.button= new Button("traiter");
      button.setOnAction(e -> {
        msg = true;
             for( Reclamation reclamation: ConsulterReclamationAdminController.obs1 )
             {if(reclamation.getButton() ==button){
                 try {
                     ReclamationCRUD rcrud = new ReclamationCRUD();
                     //   System.out.println("description :"+reclamation.getDescription());
                     //         System.out.println("Etat :"+reclamation.getEtat());
                     rcrud.modifierEtat(reclamation);
                     Email s = new Email();
                     s.Send(s.eml);
                     
                     Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Email envoyer")
                .text("ENVOYER")
                //.graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.show();
                    
                     
                     
                 } catch (Exception ex) {
                     Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
                 }
          
      
             }
                  
             }
        
    });
              }

    public int getIdreclamation() {
        return idreclamation;
    }

    public void setIdreclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idreclamation=" + idreclamation + ", type=" + type + ", iduser=" + iduser + ", nom=" + nom + ", region=" + region + ", date=" + date + ", description=" + description + ", etat=" + etat + '}';
    }

 
   

    


}
