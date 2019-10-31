/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Reclamation;
import Services.Impl.ReclamationCRUD;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ConsulterReclamationController implements Initializable {
private String querry;
    @FXML
 private  TableColumn<Reclamation, String > fxidr;
    @FXML
  private TableColumn<Reclamation, String> fxtype;
    @FXML
  private TableColumn<Reclamation, String> fxidu;
    @FXML
   private  TableColumn<Reclamation, String> fxnom;
    @FXML 
  private  TableColumn<Reclamation, String> fxregion;
    @FXML
  private TableColumn<Reclamation, Date> fxdate;
    @FXML
 private  TableColumn<Reclamation, String> fxdesciption;
    @FXML
 private TableColumn<Reclamation, String> fxetat;
    @FXML
  private Button buttonajouter;
    @FXML
 private Button idRetourC;
    @FXML
 private TableView<Reclamation> tableafficher;
    @FXML
    private Button Supp;
protected static int idsupp ;
protected static String name ;
protected static String descri ;
    @FXML
    private TextField cherche;
     @FXML
        public ComboBox<String> combobox;
ObservableList<String> lista =FXCollections.observableArrayList("Reclamation_Produit","Reclamation_Commande","Autres");
    private void initColumns() {
        //CId.setCellValueFactory(new PropertyValueFactory<>("IdAnnoce"));
     //   CDescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionAnnonce"));
       // CDate.setCellValueFactory(new PropertyValueFactory<>("DateAnnonce"));
        //CTitre.setCellValueFactory(new PropertyValueFactory<>("TitreAnnoce"));
        // CPicture.setCellValueFactory(new PropertyValueFactory<>("Picture"));
    fxidr.setCellValueFactory(new PropertyValueFactory<>("idreclamation") );
           fxtype.setCellValueFactory(new PropertyValueFactory<>("type") );
            fxidu.setCellValueFactory(new PropertyValueFactory<>("iduser") );
            fxnom.setCellValueFactory(new PropertyValueFactory<>("nom") );
            fxregion.setCellValueFactory(new PropertyValueFactory<>("region") );
            fxdate.setCellValueFactory(new PropertyValueFactory<>("date") );
       fxdesciption.setCellValueFactory(new PropertyValueFactory<>("description") );
            fxetat.setCellValueFactory(new PropertyValueFactory<>("etat") );
    }
    private void loadData() {
           ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers;
        try {
            pers = (ArrayList<Reclamation>) rcrud.getAllcommandes();
            ObservableList<Reclamation> obs=FXCollections.observableArrayList(pers);
       
         tableafficher.setItems(obs);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
                 
        
        
    }
    
    
     private void loadData1() {
           ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers;
        try {
            pers = (ArrayList<Reclamation>) rcrud.getAllcommandes();
            ObservableList<Reclamation> obs=FXCollections.observableArrayList(pers);
       
         tableafficher.setItems(obs);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
                 
        
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //   fxidr.setCellFactory(TextFieldTableCell.forTableColumn());
        //CDate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
         fxtype.setCellFactory(TextFieldTableCell.forTableColumn());
        // fxidu.setCellFactory(TextFieldTableCell.forTableColumn());
          fxnom.setCellFactory(TextFieldTableCell.forTableColumn());
           fxregion.setCellFactory(TextFieldTableCell.forTableColumn());
     //       fxdate.setCellFactory(TextFieldTableCell.forTableColumn());
            fxdate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
    fxdesciption.setCellFactory(TextFieldTableCell.forTableColumn());
              fxetat.setCellFactory(TextFieldTableCell.forTableColumn());
            combobox.setItems(lista);
        initColumns();
        loadData();
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent root;
          root=FXMLLoader.load(getClass().getResource("PageReclamation.fxml"));
                buttonajouter.getScene().setRoot(root);
    }

    @FXML
    private void RetourC(ActionEvent event) throws IOException {
        Parent root;
          root=FXMLLoader.load(getClass().getResource("UserHome.fxml"));
                idRetourC.getScene().setRoot(root);
    }

    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
       FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterReclamation.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         Supp.getScene().setRoot(root);
    }
 /*
    @FXML
    private void pageS(MouseEvent event) throws IOException {
       if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
              Parent root;
          root=FXMLLoader.load(getClass().getResource("../gui/SupprimerReclamation.fxml"));
                idRetourC.getScene().setRoot(root);}
        }
*/   
    
     @FXML
    private void pageS(MouseEvent event) throws IOException {
        
        
          
          
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("UserRsuppr.fxml"));
                
                try {
                    Loader.load();
                } catch (IOException ex) {
                 ex.printStackTrace();
                    
                    Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                UserRsupprController alertBoxController = Loader.getController();
                alertBoxController.setData(""+tableafficher.getSelectionModel().getSelectedItem().getType(), tableafficher.getSelectionModel().getSelectedItem().getNom(),""+tableafficher.getSelectionModel().getSelectedItem().getDescription());
                idsupp = tableafficher.getSelectionModel().getSelectedItem().getIdreclamation() ;      
                  name = tableafficher.getSelectionModel().getSelectedItem().getNom() ;      
                    descri = tableafficher.getSelectionModel().getSelectedItem().getDescription() ;      
                     
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                
                
                
                
    }     

    @FXML
    private void search_sup(KeyEvent event) {
           ReclamationCRUD searchtoup = new ReclamationCRUD();
        String msg = cherche.getText().concat("%");
        // ll arfaoui ylawej
        ArrayList<Reclamation> cat = (ArrayList<Reclamation>) searchtoup.chercher(msg);
        ObservableList<Reclamation> obs1 = FXCollections.observableArrayList(cat);
       tableafficher.setItems(obs1);
    }

    @FXML
    private void Select_Type(ActionEvent event) {
          fxtype.setCellFactory(TextFieldTableCell.forTableColumn());
        // fxidu.setCellFactory(TextFieldTableCell.forTableColumn());
          fxnom.setCellFactory(TextFieldTableCell.forTableColumn());
           fxregion.setCellFactory(TextFieldTableCell.forTableColumn());
     //       fxdate.setCellFactory(TextFieldTableCell.forTableColumn());
            fxdate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
    fxdesciption.setCellFactory(TextFieldTableCell.forTableColumn());
              fxetat.setCellFactory(TextFieldTableCell.forTableColumn());
        
        initColumns();
        String type =combobox.getValue();
          ReclamationCRUD rcrud =new ReclamationCRUD();  
    
          ArrayList<Reclamation> pers;
        try {
            pers = (ArrayList<Reclamation>) rcrud.getAllcommandesFiltrer(type);
            ObservableList<Reclamation> obs=FXCollections.observableArrayList(pers);
       
         tableafficher.setItems(obs);
            } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
       
  
}
