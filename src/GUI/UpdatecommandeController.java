/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.AffichercommandesController;
import Entites.Commandes;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Services.Impl.Commandesercices;

/**
 * FXML Controller class
 *
 * @author g
 */
public class UpdatecommandeController implements Initializable {

    private TextField produitname;
    @FXML
    private Text quantite;
    @FXML
    private TextField quantitepro;
    @FXML
    private DatePicker datearr;
    @FXML
    private Button retour2;
Date dateFinal;
 Commandesercices serv = new Commandesercices(); 
    @FXML
    private Button updatee;
    @FXML
    private Label labelid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     //   System.out.println(AffichercommandesController.c);
     //   System.out.println(AffichercommandesController.c.getProdname());
  //   produitname.setText(AffichercommandesController.c.getProdname());
 //    price.setText(Integer.toString(AffichercommandesController.c.getPrixcom()));
      //  quantitepro.setText(Integer.toString(AffichercommandesController.c.getQuantité()));
        
    }    

   

   

    @FXML
    private void retour2(MouseEvent event) throws IOException {
               FXMLLoader loader=new FXMLLoader(getClass().getResource("affichercommandes.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         retour2.getScene().setRoot(root);
    }

    @FXML
    private void updates(ActionEvent event) throws SQLException, IOException, ParseException {
         Commandesercices ps=new Commandesercices();
          if (quantitepro.getText().isEmpty() ||  datearr.getValue() == null  ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify Your TextFields!!");
            alert.showAndWait();
             } 
              else if (!ps.isInt(quantitepro.getText())  ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify !!");
            alert.showAndWait();
                     }
            else if (Integer.parseInt(quantitepro.getText())>10 ){
               Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify !! quantité doit etre inferieur a 10 !!!");
            alert.showAndWait();
             }
     
        
          else{
        
          DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
        LocalDate locald = datearr.getValue();
        Date date = Date.valueOf(locald);
        String datee = df.format(date);  
     
         java.util.Date parsed;
            try {
               parsed = df.parse(datee);
                dateFinal  = new java.sql.Date(parsed.getTime()) ;
            } catch (ParseException ex) {
                Logger.getLogger(ModifiercommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       Commandes commande = new Commandes(); 
              Commandes commande1 = new Commandes(); 
              commande1=AffichercommandesController.c1;

         
       // commande.setProdname(produitname.getText());
         commande.setQuantité(Integer.parseInt(quantitepro.getText()));
            commande.setDatear(dateFinal);
            commande.setDatec(dateFinal);
            commande.setPrixcom(Integer.parseInt(quantitepro.getText())*commande1.getPrixprod());
            //commande=AffichercommandesController.c ; 
            System.out.println(commande1);
            System.out.println(commande1.getIdc());
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation Dialog");
        alert1.setContentText("Etes vous sur de vouloir modifier ce produit definitivement !!!");
        alert1.setHeaderText(null);
        Optional<ButtonType> action = alert1.showAndWait();
         if (action.get() == ButtonType.OK) {
            
        serv.ModifierComdPro2(commande,commande1.getIdc());}
        
        
        
            
        
        
        
        
                   FXMLLoader loader=new FXMLLoader(getClass().getResource("affichercommandes.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         updatee.getScene().setRoot(root);
    }

    }
}
