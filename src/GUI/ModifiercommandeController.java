/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Commandes;
import Entites.User;
import Entites.UserSession;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Services.Impl.Commandesercices;
import Services.Impl.UserService;

/**
 * FXML Controller class
 *
 * @author g
 */
public class ModifiercommandeController implements Initializable {
    

    @FXML
    private Label quantité;
    @FXML
    private Label Prixcom;
    @FXML
    private Label datear;
    @FXML
    private TextField nomf;
    private TextField prenomf;
    private TextField numf;
    @FXML
    private TextField quantitef;
    
    private TextField emailf;
    @FXML
    private Button retour;
    @FXML
    private DatePicker datepeak;
    @FXML
    private Button ajouter1;
    Date dateFinal;
    
    private TextField adressef;
    @FXML
    private Label Nomp;
    
    @FXML
    private TextField comf;
    /**
     * Initializes the controller class.
     */
    

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
      
      
        datepeak.setDayCellFactory(picker -> new DateCell() {
        @Override
            public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {        
                    setDisable(true);
                    setStyle("-fx-background-color:  #2b4649;");
                }
            }
        });
        
        
       
        
        
        
        
    }    

    @FXML
    private void retour1(ActionEvent event) throws IOException {
        
           FXMLLoader loader=new FXMLLoader(getClass().getResource("affichercommandes.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         retour.getScene().setRoot(root);
    }

    @FXML
    private void ajouter11(ActionEvent event) throws SQLException, ParseException, IOException {
        Commandesercices ps=new Commandesercices();
        LocalDate localidd = datepeak.getValue();
             if (nomf.getText().isEmpty() || quantitef.getText().isEmpty() || datepeak.getValue() == null  || comf.getText().isEmpty()  ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify Your TextFields");
            alert.showAndWait();
             } 
             else if (Integer.parseInt(quantitef.getText())>10 ){
               Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify !! quantité doit etre inferieur a 10 !!!");
            alert.showAndWait();
             }
             
        
                     
             else if (!ps.isInt(quantitef.getText()) || !ps.isInt(comf.getText())  ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify !!");
            alert.showAndWait();}
               
            
           
            else if (ps.isInt(nomf.getText())  ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify !!");
            alert.showAndWait();
                     }
              
            else {
      DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
        LocalDate locald = datepeak.getValue();
        
        Date date = Date.valueOf(locald);
        String datee = df.format(date);  
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
         java.util.Date parsed;
            try {
               parsed = df.parse(datee);
                dateFinal  = new java.sql.Date(parsed.getTime()) ;
                
            } catch (ParseException ex) {
                Logger.getLogger(ModifiercommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        
         
         
         
       // Commandes cm = new Commandes ( nomf.getText(), Integer.parseInt(quantitef.getText()),dateFinal, Integer.parseInt(comf.getText()));
       Commandes cm = new Commandes ( nomf.getText(), Integer.parseInt(quantitef.getText()),dateFinal, Integer.parseInt(comf.getText()));
        System.out.println(Integer.parseInt(comf.getText()));
        System.out.println(cm);
   Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation Dialog");
        alert1.setContentText("Etes vous sur de vouloir ajouter ce produit !!!");
        alert1.setHeaderText(null);
        Optional<ButtonType> action = alert1.showAndWait();
         if (action.get() == ButtonType.OK) {
     
        ps.ajouterAlaBase(cm);
            
         }
            }
      
         
      
      //{  Commandesercices  cs=new   Commandesercices ();
   //        Etape e= new Etape(tf_nometa.getText(),tf_desceta.getText() ,Integer.parseInt(code_Event.getText())  );
  //  cs.ajouterEtape(e);
    
    //   ArrayList<Etape> ingg =(ArrayList<Etape>) cs.getAllEtape(Integer.parseInt(code_Event.getText()));
    //          ObservableList obs =FXCollections.observableArrayList(ingg);
     //      table_ing.setItems(obs);
      //      id.setCellValueFactory(new PropertyValueFactory<>("id"));
       //    nom_eta.setCellValueFactory(new PropertyValueFactory<>("nom_eta"));
       //     desceta.setCellValueFactory(new PropertyValueFactory<>("description_eta"));
        //       id_utilisateur.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        //        id_eta.setCellValueFactory(new PropertyValueFactory<>("id_eta")); 
        
        
        
   //  clear();   
        
         
    }
        
        
        
        
        
        
   
    }

    

