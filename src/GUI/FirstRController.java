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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FirstRController implements Initializable {
   /*    @FXML
    protected  TableColumn<Reclamation, Integer > fxidr;
    @FXML
   protected  TableColumn<Reclamation, String> fxtype;
    @FXML
  protected  TableColumn<Reclamation, Integer> fxidu;
    @FXML
  protected  TableColumn<Reclamation, String> fxnom;
    @FXML 
  protected  TableColumn<Reclamation, String> fxregion;
    @FXML
  protected TableColumn<Reclamation, String> fxdate;
    @FXML
protected  TableColumn<Reclamation, String> fxdesciption;
    @FXML
  protected TableColumn<Reclamation, String> fxetat;
   

    @FXML
 protected  TableView<Reclamation> tableafficher;
*/
    @FXML
    private Button ButtonConsulter;
    @FXML
    private Button fxButtonConsulterAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void Consulter(ActionEvent event) throws IOException {
      
     
        
    /*    
     ReclamationCRUD rcrud =new ReclamationCRUD();  
   
            ArrayList<Reclamation> pers;
        try {
            pers = (ArrayList<Reclamation>) rcrud.getAllcommandes();
            ObservableList<Reclamation> obs=FXCollections.observableArrayList(pers);
          tableafficher.setItems(obs);
            fxidr.setCellValueFactory(new PropertyValueFactory<>("idreclamation") );
           fxtype.setCellValueFactory(new PropertyValueFactory<>("type") );
            fxidu.setCellValueFactory(new PropertyValueFactory<>("iduser") );
            fxnom.setCellValueFactory(new PropertyValueFactory<>("nom") );
            fxregion.setCellValueFactory(new PropertyValueFactory<>("region") );
            fxdate.setCellValueFactory(new PropertyValueFactory<>("date") );
       fxdesciption.setCellValueFactory(new PropertyValueFactory<>("description") );
            fxetat.setCellValueFactory(new PropertyValueFactory<>("etat") );
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  */     
        
        
        
   Parent root;
          root=FXMLLoader.load(getClass().getResource("../gui/ConsulterReclamation.fxml"));
                ButtonConsulter.getScene().setRoot(root); }

    @FXML
    private void ConsulterAdmin(ActionEvent event) throws IOException { 
        Parent root;
          root=FXMLLoader.load(getClass().getResource("../gui/ConsulterReclamationAdmin.fxml"));
                ButtonConsulter.getScene().setRoot(root); }
    
    
}
