/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.User;
import Entites.UserSession;
import static Gui.ConnexionController.sc;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UserProfileController implements Initializable {

    @FXML
    private TextField nomtxt;
    @FXML
    private TextField prenomtxt;
    @FXML
    private TextField adressetxt;
    @FXML
    private TextField emailtxt;
    @FXML
    private TextField phonetxt;
    @FXML
    private PasswordField mdptxt;
     
        
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }

    @FXML
    private void controleSaisieTelephone(KeyEvent event) {
    }


    @FXML
    private void supprimerProfile(ActionEvent event) throws SQLException, IOException {
        User v = new User();
       //File im = new File("C:/wamp64/www/image/"+u.getPhotoURL().toString());
           
        UserService sv = new UserService();
        v=sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
     
        //sv.logOut(v);
         //DeleteMail .Send(v.getEmail());
          Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Supression");
                alert1.setHeaderText("Attention");
                alert1.setContentText("Une fois votre compte est est supprimé vous n'aurez plus un acces à cette application ! continuez quand-même ?");
                alert1.showAndWait();
        sv.delete(v);
        //im.delete();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supression");
                alert.setHeaderText("compte suprrimé");
                alert.setContentText("votre compte est supprimé");
                alert.showAndWait();
              ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Connexion.fxml"));
                Parent root=loader.load();
                Stage st = new Stage();
                Scene sc= new Scene(root);
                sc.setRoot(root);
                st.setScene(sc);
                st.show();
    }

    @FXML
    private void ModifierProfile(ActionEvent event) throws IOException, SQLException {
        User v = new User();   
         UserService sv = new UserService();
        v=sv.getUserByLogin(UserSession.getInstance().getCurrentLogin());
        System.out.println(v.getId());
        
       
        
       
        
       
        
        if (!nomtxt.getText().toString().equals("")){
            v.setNom(nomtxt.getText());
        }
        if(!prenomtxt.getText().toString().equals("")){
            v.setPrenom(prenomtxt.getText());
        }
         /*if(!emailtxt.getText().toString().equals("")){
             if(!controleEmail()){
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("erreur");
                alert.setHeaderText("email incorrect");
                alert.showAndWait();
            }
            else
                v.setEmail(emailtxt.getText());
         }*/
        if(!adressetxt.getText().toString().equals("") ){
           
            v.setAdresse(adressetxt.getText());
        }
        if(! mdptxt.getText().toString().equals("")){
            v.setMps(mdptxt.getText());
        }
        if(!phonetxt.getText().toString().equals("")){
            if(phonetxt.getText().length()==8)
                v.setPhone(Integer.parseInt(phonetxt.getText()));
        }
        
     System.out.println(v);
        /*if(selectedfile!=null){ 
            File des = new File("C:/wamp64/www/image/"+v.getLogin()+selectedfile.getName());
            System.out.println(selectedfile.getName());
            System.out.println("********");
            Files.copy(selectedfile.toPath(),des.toPath());
            v.setPhotoURL(v.getLogin()+selectedfile.getName());
            System.out.println("image");
        }*/
         
           
        
          
            System.out.println(v.getNom());
             //v = new User(2,v.getNom(),v.getPrenom(),v.getLogin(),v.getMps(),v.getAdresse(),v.getEmail(),v.getPhone(),v.getType());
            sv.update(v);
             System.out.println(v);
              ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("ToMyProfile.fxml"));
                Parent root=loader.load();
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
                st.setScene(scene);
                st.show();
 
    }

    @FXML
    private void backHome(ActionEvent event) throws IOException {
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
