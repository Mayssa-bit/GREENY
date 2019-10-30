/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.User;
import Services.Impl.UserService;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */

public class AdminHomeController implements Initializable {

    @FXML
    private Button listeutilisateurid;
    @FXML
    private Button logoutid;
     @FXML
    private Button logoutid1;
     @FXML
    private Button logoutid11;
    @FXML
    private Button GoEventAdminId;
    @FXML
    private Button catId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    UserService su=new UserService();
    ObservableList<User> Liste_Users = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    @FXML
    private void tolisteutilisateur(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("MenuUtiisateurl.fxml"));
                Parent root=loader.load();
                 Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
            
                st.setScene(scene);
                
                st.show();
        
                
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Connexion.fxml"));
                Parent root=loader.load();
                 Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
            
                st.setScene(scene);
                
                st.show();
    }

    @FXML
    private void identifierplante(ActionEvent event) throws URISyntaxException, IOException {
         Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://identify.plantnet.org") );
    }

    private void capture(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Webcam.fxml"));
                Parent root=loader.load();
                 Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
            
                st.setScene(scene);
                
                st.show();
    }

    @FXML
    private void GoEventAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsulterEventAdmin.fxml"));
        Parent root = loader.load();
        GoEventAdminId.getScene().setRoot(root);
    }

    @FXML
    private void ToCategories(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Affichercategorie.fxml"));
        Parent root = loader.load();
        GoEventAdminId.getScene().setRoot(root);
    }

    
}
