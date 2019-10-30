/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Admin;
import Entites.User;
import Entites.UserSession;
import Services.Impl.AdminService;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ConnexionController implements Initializable {
     public static Stage st;
     public static Scene sc;

    @FXML
    private TextField LoginText;
    @FXML
    private PasswordField MdpText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SeConnecter(ActionEvent event) throws SQLException, IOException {
         String login = LoginText.getText();
        String Password = MdpText.getText();
        AdminService su = new AdminService();
        UserService tu = new UserService();
        Admin u = new Admin();
        User t = new User();
        u.setLogin(login);
        u.setPassword(Password);
        t.setLogin(login);
        t.setMps(Password);
            if(su.getByLogin(u)==true)
            {
           
            
              ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminHome.fxml"));
                Parent root=loader.load();
                
                
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
                System.out.println("root");
                st.setScene(scene);
                System.out.println("sc");
                st.show();
                System.out.println("fd");
            }
                
            else if(tu.logIn(t)!=null)
            {
             UserSession.getInstance().setCurrentLogin(login);
            
              ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader1=new FXMLLoader(getClass().getResource("UserHome.fxml"));
                Parent root1=loader1.load();
                Stage st1 = new Stage();
                Scene scene1 = new Scene(root1);
                scene1.setRoot(root1);
                st1.setScene(scene1);
                st1.show();
                
            
   
            }
            else
            {
                System.out.println("no");
                LoginText.setText("");
                MdpText.setText("");
                 Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Connexion");
                alert.setHeaderText("intouvable");
                alert.setContentText("Veuillez vérifier vos paramétres ou creer un nouveau compte");
                alert.showAndWait();
            }
            
    }

    @FXML
    private void addmember(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("SignUp.fxml"));
                Parent root=loader.load();
               
                
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
            
                st.setScene(scene);
                
                st.show();
                
    }

    private void forgetpassword(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("ForgetPassword.fxml"));
                Parent root=loader.load();
                
                
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
               
                st.setScene(scene);
              
                st.show();
               
        
    }
    
}
