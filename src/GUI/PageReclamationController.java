/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Reclamation;
import Services.Impl.ReclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PageReclamationController implements Initializable {

    @FXML
    private TextField tfidu;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfregion;
   // @FXML
 //   private TextField tfdate;
    @FXML
    private TextArea tfdescription;
    @FXML
    private TextField tfetat;
    @FXML
    private Button tfreclamation;
    @FXML
    private Button Retour;
    @FXML
    private RadioButton rb1;
    @FXML
    private ToggleGroup tgtype;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addreclamation(ActionEvent event) throws IOException, ParseException {
           Reclamation r = new Reclamation();
        r.setIdreclamation(1);
     //   "Reclamation_Produit","Reclamation_Commande","Autres"
        if(rb2.isSelected()){r.setType("Reclamation_Produit");}
        
         if(rb1.isSelected()){r.setType("Reclamation_Commande");}
        
        if(rb3.isSelected()){r.setType("Autres");}
        
      //  r.setType(tftype.getText());
         /*r.setIduser(123456789);
        r.setNom("ahmed");
               r.setRegion("tunis");*/
                 //     r.setDate(tfdate.getText());
                       r.setDescription(tfdescription.getText());
                         r.setEtat("Non_traiter");
                       
        if (tfdescription.getText().isEmpty()   ) {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify Your Description");
            alert.showAndWait();}
       else{  
        
        ReclamationCRUD crud = new ReclamationCRUD();
        crud.ajouterReclamation(r);
       
        Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Reclamation envoyer")
                .text("saved")
                //.graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.show();

        
        
        
        
              Parent root;
          root=FXMLLoader.load(getClass().getResource("ConsulterReclamation.fxml"));
               tfreclamation.getScene().setRoot(root); }
        
    }

    @FXML
    private void RetourR(ActionEvent event) throws IOException {
        Parent root;
          root=FXMLLoader.load(getClass().getResource("ConsulterReclamation.fxml"));
                Retour.getScene().setRoot(root);
    }
    
}
