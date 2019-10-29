/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayssa
 */
public class AcceuilEventController implements Initializable {

    @FXML
    private Button BackEventId;
    @FXML
    private Button GererEventId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void GererEvent(ActionEvent event) throws IOException {
        // ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterEventAdmin.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         BackEventId.getScene().setRoot(root);
         //   scene.setRoot(root);
           // st.setScene(scene);
            //st.show();
            
    }


    @FXML
    private void BackEvent(ActionEvent event) {
    }

    
}
