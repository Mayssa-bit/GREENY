/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Categorie;
import Services.Impl.CategorieCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class AjoutercategorieController implements Initializable {

    @FXML
    private TextField ajouidcat;
    @FXML
    private TextField ajoufamillecat;
    @FXML
    private Button ajoucat;
    @FXML
    private Button retouaffcat;
    @FXML
    private TextField ajounomlatincat;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoucat(ActionEvent event) throws Exception {
        Categorie c = new Categorie();
        CategorieCRUD ccrud = new CategorieCRUD() ;
    
        if ( ajouidcat.getText().isEmpty() | ajoufamillecat.getText().isEmpty() | ajounomlatincat.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir tous les champs");
            alert.showAndWait();

        } 
        else if (!ccrud.isInt(ajouidcat.getText())){
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("warning");
            alert1.setHeaderText(null);
            alert1.setContentText("Verify Your TextFields");
            alert1.showAndWait();}
        
        else {
        c.setId_cath(Integer.parseInt(ajouidcat.getText()));
        c.setNom_cath(ajoufamillecat.getText());
        c.setNom_latin(ajounomlatincat.getText());
        
        
       
        ccrud.ajouterCategorie(c);
        
         Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("categorie ajouter")
                .text("saved")
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.show();
              
    }}

    @FXML
    private void retouaffcat(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Affichercategorie.fxml"));
                Parent root=loader.load();
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
                st.setScene(scene);
                st.show();
    }
    }
    
