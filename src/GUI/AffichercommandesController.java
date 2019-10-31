/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import Entites.Commandes;
import Entites.User;
import Entites.UserSession;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Services.Impl.Commandesercices;
import Services.Impl.UserService;

/**
 * FXML Controller class
 *
 * @author g
 */
public class AffichercommandesController implements Initializable {
  public  static final String ACCOUNT_SID="AC77186fe94e5ff64957dd56d967966d72";
    public static final String AUTH_TOKEN="2aed6d8508c16fd0199d9a28c1ae0060";
    
    
 public  static Commandes c =new Commandes();
         public static Commandes c1 ;
 
    @FXML
    private TableView<Commandes> tableafficher;
    @FXML
    private Button bouttonsupp;
    /*private TableColumn<Commandes, String> nom;
    private TableColumn<Commandes, String> Prenom;
    private TableColumn<Commandes, String> numu;*/
    @FXML
    private TableColumn<Commandes, String> quantité;
    @FXML
    private TableColumn<Commandes, String> Prixcom;
    @FXML
    private TableColumn<Commandes, String> datec;
    @FXML
    private TableColumn<Commandes, String> Datear;
   /* private TableColumn<Commandes, String> adresse;
    private TableColumn<Commandes, String> email;*/
    @FXML
    private Button ajoutcomm;
    @FXML
    private TableColumn<Commandes, String> imageprod;
    @FXML
    private TableColumn<Commandes  , String> prodname;
    private TableColumn<Commandes, String>  valid;
    @FXML
    private TableColumn<Commandes, String> validd;
    @FXML
    private Button pass;

    /**
     * Initializes the controller class.
     */
    
      
  
        
        @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       
   Commandesercices comm =new Commandesercices();  
   tableafficher.setOnMouseClicked((MouseEvent event) -> {
     
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                Commandes commm =new Commandes(); 
                 commm = (Commandes) tableafficher.getItems().get(tableafficher.getSelectionModel().getSelectedIndex());
                c1=commm;
                System.out.println(c1);
          Parent root = null;
                System.out.println(commm);
                try {
                    root = FXMLLoader.load(getClass().getResource("updatecommande.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
                }
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
                try {
                    root = FXMLLoader.load(getClass().getResource("updatecommande.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
                }}});
       
                
                
             
                
            ArrayList<Commandes> pers;
        try {
            pers = (ArrayList<Commandes>) comm.getAllcommandes();
            ObservableList<Commandes> obs=FXCollections.observableArrayList(pers);
            tableafficher.setItems(obs);
           // nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
         //  Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom") );
         //   numu.setCellValueFactory(new PropertyValueFactory<>("numu") );
            quantité.setCellValueFactory(new PropertyValueFactory<>("quantité") );
            Prixcom.setCellValueFactory(new PropertyValueFactory<>("Prixcom") );
            datec.setCellValueFactory(new PropertyValueFactory<>("datec") );
            Datear.setCellValueFactory(new PropertyValueFactory<>("Datear"));
             prodname.setCellValueFactory(new PropertyValueFactory<>("prodname") );
               imageprod.setCellValueFactory(new PropertyValueFactory<>("image") );
               validd.setCellValueFactory(new PropertyValueFactory<>("Validation") );
               
       //     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         //   email.setCellValueFactory(new PropertyValueFactory<>("email") );
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
          
            
        }
            
                
                
                


    

    @FXML
    private void ajout00(ActionEvent event) throws IOException {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("modifiercommande.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         ajoutcomm.getScene().setRoot(root);
               
       
        
    }

    @FXML
    private void suppcomm(ActionEvent event) throws IOException, SQLException {
    
     /*      Parent root;
          root=FXMLLoader.load(getClass().getResource("../fxml/supprimercommande.fxml"));
                bouttonsupp.getScene().setRoot(root);*/
     
 //    Commandesercices comm =new Commandesercices();  
  Commandesercices comm =new Commandesercices();
      if (!tableafficher.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(" ");
            alert.setHeaderText("Etes-vous sur que vous voulez supprimer le produit : "
                    + tableafficher.getSelectionModel().getSelectedItem().getProdname()+ "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                   
                comm.SupprimerComdPro(tableafficher.getSelectionModel().getSelectedItem().getIdc());
                
     
            
            }
          
      }
        ArrayList<Commandes> pers;
        try {
            pers = (ArrayList<Commandes>) comm.getAllcommandes();
            ObservableList<Commandes> obs=FXCollections.observableArrayList(pers);
            tableafficher.getItems().clear();
            tableafficher.setItems(obs);
           // nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
         //  Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom") );
         //   numu.setCellValueFactory(new PropertyValueFactory<>("numu") );
            quantité.setCellValueFactory(new PropertyValueFactory<>("quantité") );
            Prixcom.setCellValueFactory(new PropertyValueFactory<>("Prixcom") );
            datec.setCellValueFactory(new PropertyValueFactory<>("datec") );
            Datear.setCellValueFactory(new PropertyValueFactory<>("Datear"));
            validd.setCellValueFactory(new PropertyValueFactory<>("validation"));
            
       //     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         //   email.setCellValueFactory(new PropertyValueFactory<>("email") );
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
    } 


    

   
    private void bouttmodifff(ActionEvent event) throws IOException {
             ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("updatecommande.fxml"));
                Parent root=loader.load();
                Scene sc =new Scene(root);
                Stage st =new Stage() ;  
                       
                sc.setRoot(root);
                st.setScene(sc);
                st.show();
                   Commandesercices comm =new Commandesercices();
        c = comm.findbyid(tableafficher.getSelectionModel().getSelectedItem().getIdc());
        System.out.println("rrrrrr"+tableafficher.getSelectionModel().getSelectedItem().getIdc());
     int id = c.getIdc();
    }

    private void panier(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../fxml/adminaffichage.fxml"));
                Parent root=loader.load();
                Scene sc =new Scene(root);
                Stage st =new Stage() ;  
                       
                sc.setRoot(root);
                st.setScene(sc);
                st.show();
        
    }


    private void admin(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../fxml/adminaffichage.fxml"));
                Parent root=loader.load();
                Scene sc =new Scene(root);
                Stage st =new Stage() ;  
                       
                sc.setRoot(root);
                st.setScene(sc);
                st.show();
    }

    @FXML
    private void passercomm(ActionEvent event) throws SQLException {
   
     /*      Parent root;
          root=FXMLLoader.load(getClass().getResource("../fxml/supprimercommande.fxml"));
                bouttonsupp.getScene().setRoot(root);*/
     
 //    Commandesercices comm =new Commandesercices();  
  Commandesercices comm =new Commandesercices();
      if (!tableafficher.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(" ");
            alert.setHeaderText("Etes-vous sur que vous voulez passer votre commande ? : "
                    + tableafficher.getSelectionModel().getSelectedItem().getProdname()+ "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 /*   Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21652130866"), new PhoneNumber("+13346036509"),
                        "vous pouvez recuperer votre commande aprés 3 jour de la date d'arrivée ! merci de nous contacter si vous avez un probléme merci ! " )
                .create();*/
                   
                int a = tableafficher.getSelectionModel().getSelectedItem().getIdc();
            Commandesercices serv = new Commandesercices(); 
             Commandes commande = new Commandes();
            serv.ModifierComdPro3(commande, a);
  //                stm.setString(1, username);  
    //         stm.setString(1, username);
     
            
            }
          
      }
     
            ArrayList<Commandes> pers;
        try {
            pers = (ArrayList<Commandes>) comm.getAllcommandes();
            ObservableList<Commandes> obs=FXCollections.observableArrayList(pers);
            tableafficher.getItems().clear();
            tableafficher.setItems(obs);
           // nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
         //  Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom") );
         //   numu.setCellValueFactory(new PropertyValueFactory<>("numu") );
            quantité.setCellValueFactory(new PropertyValueFactory<>("quantité") );
            Prixcom.setCellValueFactory(new PropertyValueFactory<>("Prixcom") );
            datec.setCellValueFactory(new PropertyValueFactory<>("datec") );
            Datear.setCellValueFactory(new PropertyValueFactory<>("Datear"));
            validd.setCellValueFactory(new PropertyValueFactory<>("validation"));
            
       //     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         //   email.setCellValueFactory(new PropertyValueFactory<>("email") );
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
}
    


      



