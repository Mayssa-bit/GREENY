/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.PasswordMail;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ForgetPasswordController implements Initializable {

    @FXML
    private Button sendpassid;
    @FXML
    private Button backid;
    @FXML
    private TextField emailadress;
    @FXML
    private Button testid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendPassword(ActionEvent event) throws SQLException {
        PasswordMail.Send(emailadress.getText());
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("verification");
                          alert.setHeaderText("inscrit");
                          alert.setContentText("email envoyé"); 
                          alert.showAndWait();
    }

    @FXML
    private void backto(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Connexion.fxml"));
                Parent root=loader.load();
                
                
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
               
                st.setScene(scene);
              
                st.show();
    }

}

