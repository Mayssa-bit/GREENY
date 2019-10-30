/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.User;
import Entites.UserSession;
import Entites.mailControl;
import Services.Impl.UserService;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SignupController implements Initializable {

    @FXML
    private Button annulerBtn;
    @FXML
    private TextField nomText;
    @FXML
    private TextField prenomText;
    @FXML
    private TextField adresseMailText;
    @FXML
    private TextArea adresseText;
    @FXML
    private PasswordField passeText;
    @FXML
    private PasswordField passeCText;
    @FXML
    private TextField loginText;
    @FXML
    private TextField cinInt;
    @FXML
    private TextField telephoneInt;
    @FXML
    private ImageView PhotoText;
    @FXML
    private Button confirmerBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event) throws IOException {
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
    private void controleSaisieCin(KeyEvent event) {
         String text="";
        String concat = "";
        System.out.println(event.getCode());
            if("DIGIT0".equals(event.getCode().toString())||
                "DIGIT1".equals(event.getCode().toString())||
                "DIGIT2".equals(event.getCode().toString())||
                "DIGIT3".equals(event.getCode().toString())||
                "DIGIT4".equals(event.getCode().toString())||
                "DIGIT5".equals(event.getCode().toString())||
                "DIGIT6".equals(event.getCode().toString())||
                "DIGIT7".equals(event.getCode().toString())||
                "DIGIT8".equals(event.getCode().toString())||
                "DIGIT9".equals(event.getCode().toString())||
                "NUMPAD0".equals(event.getCode().toString())||
                "NUMPAD1".equals(event.getCode().toString())||
                "NUMPAD2".equals(event.getCode().toString())||
                "NUMPAD3".equals(event.getCode().toString())||
                "NUMPAD4".equals(event.getCode().toString())||
                "NUMPAD5".equals(event.getCode().toString())||
                "NUMPAD6".equals(event.getCode().toString())||
                "NUMPAD7".equals(event.getCode().toString())||
                "NUMPAD8".equals(event.getCode().toString())||
                "NUMPAD9".equals(event.getCode().toString()))
        
            
            concat = concat.concat(event.getText());
        else {
             cinInt.setText(text);
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("erreur");
                alert.setHeaderText("CIN incorrect");
                alert.showAndWait();
             }
    }

    @FXML
    private void controleSaisieTelephone(KeyEvent event) {
         String text="";
        String concat = "";
        System.out.println(event.getCode());
        if("DIGIT0".equals(event.getCode().toString())||
                "DIGIT1".equals(event.getCode().toString())||
                "DIGIT2".equals(event.getCode().toString())||
                "DIGIT3".equals(event.getCode().toString())||
                "DIGIT4".equals(event.getCode().toString())||
                "DIGIT5".equals(event.getCode().toString())||
                "DIGIT6".equals(event.getCode().toString())||
                "DIGIT7".equals(event.getCode().toString())||
                "DIGIT8".equals(event.getCode().toString())||
                "DIGIT9".equals(event.getCode().toString())||
                "NUMPAD0".equals(event.getCode().toString())||
                "NUMPAD1".equals(event.getCode().toString())||
                "NUMPAD2".equals(event.getCode().toString())||
                "NUMPAD3".equals(event.getCode().toString())||
                "NUMPAD4".equals(event.getCode().toString())||
                "NUMPAD5".equals(event.getCode().toString())||
                "NUMPAD6".equals(event.getCode().toString())||
                "NUMPAD7".equals(event.getCode().toString())||
                "NUMPAD8".equals(event.getCode().toString())||
                "NUMPAD9".equals(event.getCode().toString()))
        {
            concat = concat.concat(event.getText());
        }
        else {
            telephoneInt.setText(text);
        }
    }
    private boolean controleCin(){
        
        if (cinInt.getText().length()==8)
            return true;
        return false;
    }
    
    private boolean controleMdp() {
       if( passeText.getText() == null ? passeCText.getText() == null : passeText.getText().equals(passeCText.getText()))
            return true;
        return false;
        
    }
    private boolean controleNecessaire() {
        if ("".equals(nomText.getText())
                ||"".equals(prenomText.getText())
                ||"".equals(cinInt.getText())
                ||"".equals(adresseMailText.getText())
                ||"".equals(loginText.getText())
                ||"".equals(passeText.getText())
                ||"".equals(passeCText.getText()))
            return false;
        return true;    
    }
    private boolean controleEmail(){
            if (adresseMailText.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" ))
                return true;
            return false;
        }


    @FXML
    private void confirmer(ActionEvent event) throws IOException {
          if ( !controleNecessaire()   ) {
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("erreur");
                alert.setHeaderText("le nom,le prenom,le email,le CIN,le login et le mdp sont obligatoires ");
                alert.showAndWait();
        }
        else if(!controleCin()){
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("erreur");
                alert.setHeaderText("CIN incorrect");
                alert.showAndWait();
        }
        else if(!controleEmail()){
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("erreur");
                alert.setHeaderText("email incorrect");
                alert.showAndWait();
        }
        else if (!controleMdp()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("erreur");
                alert.setHeaderText("mdp n'est pas correct");
                alert.showAndWait();
        }
        else {
            User u = new User();
            u.setNom(nomText.getText());
            u.setPrenom(prenomText.getText());
            u.setCin(Integer.parseInt(cinInt.getText()));
            u.setAdresse(adresseText.getText());
            u.setEmail(adresseMailText.getText());
            u.setLogin(loginText.getText());
            u.setMps(passeText.getText());
           
            if(telephoneInt.getText().length()==8)
                u.setPhone(Integer.parseInt(telephoneInt.getText()));
            
            // u.setPhoto(PhotoText.getText());
        
             
               
            UserService su = new UserService();
           /* if (!su.checkCin(u)&&!su.checkLogin(u)){
           
                         
              
                          
                          if(selectedFile!=null)
                        { 
                              File des = new File("C:/wamp64/www/image/"+u.getLogin()+selectedFile.getName());
                          System.out.println(selectedFile.getName());
                          System.out.println("********");
                            Files.copy(selectedFile.toPath(),des.toPath());
                         u.setPhotoURL(loginText.getText()+selectedFile.getName());
                           System.out.println("image");
                        }
                        else {
                             System.out.println("no image");
                              u.setPhotoURL("default");
                        }*/
                          
                          su.insert(u);
                          String login =loginText.getText();
                          System.out.println("session");
                          UserSession.getInstance().setCurrentLogin(login);
                         // SendEmail.Send(adresseMailText.getText());
                          Alert alert=new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Ajout user");
                          alert.setHeaderText("inscrit");
                          alert.setContentText("Compte creer"); 
                          mailControl.Send(u.getEmail());
                          alert.showAndWait();
                          System.out.println("direction");
                          
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
    }
    

