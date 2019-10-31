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
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ConsulterReclamationAdminController implements Initializable {

    @FXML
    private TableColumn<Reclamation,String> idrAdmin;
    @FXML
    private TableColumn<Reclamation,String> iduAdmin;
    @FXML
    private TableColumn<Reclamation,String> nomAdmin;
    @FXML
    private TableColumn<Reclamation,String> typeAdmin;
    @FXML
    private TableColumn<Reclamation,String> descriptionAdmin;
    @FXML
    private TableColumn<Reclamation,String> etatAdmin;
    @FXML
    private TableView<Reclamation> table1;
    @FXML
   private TableView<Reclamation> table2;
    @FXML
    private TableColumn<Reclamation,Button> traitement;
    public static ObservableList<Reclamation> obs1;
    @FXML
    private TextField cher;
    @FXML
    private TableColumn<Reclamation,String> fxregion;
    @FXML
    public ComboBox<String> combobox;
ObservableList<String> lista =FXCollections.observableArrayList("Reclamation_Produit","Reclamation_Commande","Autres");
    @FXML
    private Button fxretour;

    /**
     * Initializes the controller class.
     */
     private void initColumns() {
        //CId.setCellValueFactory(new PropertyValueFactory<>("IdAnnoce"));
     //   CDescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionAnnonce"));
       // CDate.setCellValueFactory(new PropertyValueFactory<>("DateAnnonce"));
        //CTitre.setCellValueFactory(new PropertyValueFactory<>("TitreAnnoce"));
        // CPicture.setCellValueFactory(new PropertyValueFactory<>("Picture"));
    idrAdmin.setCellValueFactory(new PropertyValueFactory<>("idreclamation") );
      iduAdmin.setCellValueFactory(new PropertyValueFactory<>("iduser") );
       nomAdmin.setCellValueFactory(new PropertyValueFactory<>("nom") );
             fxregion.setCellValueFactory(new PropertyValueFactory<>("region") );
           typeAdmin.setCellValueFactory(new PropertyValueFactory<>("type") );
         
          
        //    t.setCellValueFactory(new PropertyValueFactory<>("region") );
          //  fxdate.setCellValueFactory(new PropertyValueFactory<>("date") );
       descriptionAdmin.setCellValueFactory(new PropertyValueFactory<>("description") );
            etatAdmin.setCellValueFactory(new PropertyValueFactory<>("etat") );
           traitement.setCellValueFactory(new PropertyValueFactory<>("button") );
    }
     
     private void loadData1() {
           ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers;
        try {
            pers = (ArrayList<Reclamation>) rcrud.getAlReclamationById();
            ObservableList<Reclamation> obs=FXCollections.observableArrayList(pers);
       
         table1.setItems(obs);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void loadData2() {
           ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers1;
        try {
           int id = table1.getSelectionModel().getSelectedItem().getIduser() ;
            pers1 = (ArrayList<Reclamation>) rcrud. getAlReclamationID( id);
             obs1=FXCollections.observableArrayList(pers1);
       
         table2.setItems(obs1);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }}
     
    /* 
       private void loadData3() {
           ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers1;
        try {
           int id = table1.getSelectionModel().getSelectedItem().getIduser() ;
          
            pers1 = (ArrayList<Reclamation>) rcrud. getAlReclamationIDFiltre( id,type);
             obs1=FXCollections.observableArrayList(pers1);
       
         table2.setItems(obs1);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }}*/
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
          //CDate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
      //  idAdmin.setCellFactory(TextFieldTableCell.forTableColumn());
        // fxidu.setCellFactory(TextFieldTableCell.forTableColumn());
          nomAdmin.setCellFactory(TextFieldTableCell.forTableColumn());
               fxregion.setCellFactory(TextFieldTableCell.forTableColumn());
      typeAdmin.setCellFactory(TextFieldTableCell.forTableColumn());
     //       fxdate.setCellFactory(TextFieldTableCell.forTableColumn());
           //.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
  descriptionAdmin.setCellFactory(TextFieldTableCell.forTableColumn());
            etatAdmin.setCellFactory(TextFieldTableCell.forTableColumn());
            
        initColumns();
        loadData1();
        combobox.setItems(lista);
        
       
    }    

    @FXML
    private void select(MouseEvent event) {
     //  int id = table1.getSelectionModel().getSelectedItem().getIduser() ;
          initColumns();
         loadData2(); 
         
    }
    
    @FXML
    private void search_sup(KeyEvent event) {
        ReclamationCRUD searchtoup = new ReclamationCRUD();
        String msg = cher.getText().concat("%");
        // ll arfaoui ylawej
        ArrayList<Reclamation> cat = (ArrayList<Reclamation>) searchtoup.chercher(msg);
        ObservableList<Reclamation> obs1 = FXCollections.observableArrayList(cat);
       table1.setItems(obs1);
    }

    @FXML
    private void filtre(ActionEvent event) {
         String type = combobox.getValue();
        
      initColumns();
   
           ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers1;
        try {
           int id = table1.getSelectionModel().getSelectedItem().getIduser() ;
          
            pers1 = (ArrayList<Reclamation>) rcrud. getAlReclamationIDFiltre( id,type);
             obs1=FXCollections.observableArrayList(pers1);
       
         table2.setItems(obs1);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent root;
          root=FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
                fxretour.getScene().setRoot(root);
    }
}
