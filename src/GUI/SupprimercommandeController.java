/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Commandes;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import Services.Impl.Commandesercices;

/**
 * FXML Controller class
 *
 * @author g
 */
public class SupprimercommandeController implements Initializable {

    @FXML
    private Button suppbutt;
    @FXML
    private TextField labelsupp;
    @FXML
    private Button retour2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimerboutt(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(labelsupp.getText());
        Commandes p = new Commandes();
        p.setIdc(id);
        Commandesercices p1 = new Commandesercices();
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation Dialog");
        alert1.setContentText("Etes vous sur de vouloir supprimer ce produit défintivement");
        alert1.setHeaderText(null);
        Optional<ButtonType> action = alert1.showAndWait();
        if (action.get() == ButtonType.OK) {
        p1.supprimerCommande(p);
        
    }
    }

    @FXML
    private void retour2(ActionEvent event) throws IOException {
          Parent root;
          root=FXMLLoader.load(getClass().getResource("../fxml/affichercommandes.fxml"));
                suppbutt.getScene().setRoot(root);
    }
  
}
