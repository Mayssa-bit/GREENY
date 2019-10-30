/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.User;
import Entites.UserSession;
import Services.Impl.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ToMyProfileController implements Initializable {

    @FXML
    private TextField nomid;
    @FXML
    private TextField prenomid;
    @FXML
    private TextField loginid;
    @FXML
    private TextField cinid;
    @FXML
    private TextField adresseid;
    @FXML
    private TextField emailid;
    @FXML
    private TextField typeid;
    @FXML
    private TextField phoneid;
    @FXML
    private Button modpro;
    @FXML
    private Button retid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User v = new User();
       //File im = new File("C:/wamp64/www/image/"+u.getPhotoURL().toString());
           
        UserService sv = new UserService();
        try {
            v=sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
        } catch (SQLException ex) {
            Logger.getLogger(UserHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nomid.setText(v.getNom());
        prenomid.setText(v.getPrenom());
        loginid.setText(v.getLogin());
        cinid.setText(String.valueOf(v.getCin()));
        adresseid.setText(v.getAdresse());
        emailid.setText(v.getEmail());
                typeid.setText(v.getType());
                        phoneid.setText(String.valueOf(v.getPhone()));



        
        // TODO
    }    

    @FXML
    private void modiferprof(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("UserProfile.fxml"));
                Parent root=loader.load();
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
                st.setScene(scene);
                st.show();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("UserHome.fxml"));
                Parent root=loader.load();
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
                st.setScene(scene);
                st.show();
    }
    
}
