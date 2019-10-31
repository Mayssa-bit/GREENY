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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UserHomeController implements Initializable {

    @FXML
    private Button logoutBtn;
    @FXML
    private Button profileBtn;
    @FXML
    private TextField loginTxt;
    @FXML
    private Button profilbtn4;
    @FXML
    private Button profileBtn5;
    @FXML
    private Button profileBtn6;
    @FXML
    private Button profileBtn7;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User v = new User();
        //File im = new File("C:/wamp64/www/image/"+u.getPhotoURL().toString());

        UserService sv = new UserService();
        try {
            v = sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
        } catch (SQLException ex) {
            Logger.getLogger(UserHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginTxt.setText(v.getLogin());
    
        // TODO
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Connexion.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
    }

    @FXML
    private void profile(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ToMyProfile.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
    }

    @FXML
    private void reclamations(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsulterReclamation.fxml"));
        Parent root = loader.load();
        profileBtn7.getScene().setRoot(root);
    }

    @FXML
    private void produits(ActionEvent event) {
    }

    @FXML
    private void evenements(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilEventUser.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
       
    }

    @FXML
    private void Magasin(ActionEvent event) throws IOException {
         ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("affichercommandes.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
    }

}
