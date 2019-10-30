/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Categorie;
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
import Entites.Sendeamil;
import Services.Impl.CategorieCRUD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Firas
 */
public class AffichercategorieController implements Initializable {

    @FXML
    private Button affcatajou;
    @FXML
    private Button affcatmod;
    @FXML
   private TableColumn<Categorie, Integer> tableviewID;
    @FXML
    private TableColumn<Categorie, String> tableviewfami;
    @FXML
    private TableColumn<Categorie, String> tableviewlatin;
    @FXML
    private TableView tableview;
    @FXML
    private Button calcul;
    @FXML
    private TextField recherchercat;
    ObservableList<Categorie> obs = FXCollections.observableArrayList();
    @FXML
    private Button actuasupp1;
    @FXML
    private Button test;
    @FXML
    private Button envoiemail9;
    @FXML
    private Button retourpage1;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieCRUD ccrud = new CategorieCRUD();
        ArrayList<Categorie> pers = (ArrayList<Categorie>) ccrud.afficherCategorie();
        ObservableList<Categorie> obs = FXCollections.observableArrayList(pers);
        tableview.setItems(obs);
        tableviewID.setCellValueFactory(new PropertyValueFactory<>("id_cath"));
        tableviewfami.setCellValueFactory(new PropertyValueFactory<>("nom_cath"));
        tableviewlatin.setCellValueFactory(new PropertyValueFactory<>("nom_latin"));
       
    }
     
        
      @FXML
    private void affcarajou(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutercategorie.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
        
    }

    @FXML
    private void affcatmod(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifiercategorie.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();

    }

    @FXML
    private void calculatrice(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("calcul.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
    }

    @FXML
    private void search(KeyEvent event) {
        CategorieCRUD ccrud = new CategorieCRUD();
        String msg = recherchercat.getText().concat("%");
        // ll arfaoui ylawej
        ArrayList<Categorie> cat = (ArrayList<Categorie>) ccrud.chercher(msg);
        ObservableList<Categorie> obs = FXCollections.observableArrayList(cat);
        tableview.setItems(obs);}

    @FXML
    private void actuasupp1(ActionEvent event) {
         CategorieCRUD ccrud = new CategorieCRUD();
           ArrayList<Categorie> pers = (ArrayList<Categorie>) ccrud.afficherCategorie();
        ObservableList<Categorie> obs = FXCollections.observableArrayList(pers);
        tableview.setItems(obs);
        tableviewID.setCellValueFactory(new PropertyValueFactory<>("id_cath"));
        tableviewfami.setCellValueFactory(new PropertyValueFactory<>("nom_cath"));
        tableviewlatin.setCellValueFactory(new PropertyValueFactory<>("nom_latin"));
        Categorie c = new Categorie();
        tableview.setOnMouseClicked((MouseEvent event1) ->  {

            Categorie A = (Categorie) tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());

            c.setId_cath(A.getId_cath());
            c.setNom_cath(A.getNom_cath());
            c.setNom_latin(A.getNom_latin());
            ccrud.supprimerCategorie(c.getId_cath());

        });
        Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
        ajoutdoneAlert.setTitle("Done");
        ajoutdoneAlert.setContentText("Categorie supprimee");
        ajoutdoneAlert.show();
    }

    @FXML
    private void test(ActionEvent event) throws DocumentException, FileNotFoundException {
        Document document = new Document() ; 
        PdfWriter.getInstance(document,new FileOutputStream("hello.pdf"));
        document.open();
        try {
                   
                   Font f=new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p=new Paragraph("Pepeniere\n",f);
                   p.setAlignment(Element.ALIGN_CENTER);
                   document.add(p);
                   Font f1=new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p1=new Paragraph("list des categories",f1);
                   p1.setAlignment(Element.ALIGN_CENTER);
                   document.add(p1);
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                   LocalDateTime now = LocalDateTime.now();  
                   String d=   dtf.format(now);
                   Font f2=new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLACK);
                   Paragraph p2=new Paragraph("\nDate: "+d,f2);
                   document.add(p2);
                   document.add(new Paragraph("Gerant responsable : " ,f2));
                   document.add(new Paragraph(" "));
                   PdfPTable table = new PdfPTable(2);
                   table.setWidthPercentage(100);
                   table.setSpacingBefore(0f);
                   table.setSpacingAfter(0f);
        
                   Font f3=new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDEFINED, BaseColor.BLUE);
                   PdfPCell c1=new PdfPCell(new Phrase("famille de categorie",f3));
                   c1.setPadding(4f);
                   table.addCell(c1);
                   
                     c1=new PdfPCell(new Phrase("Nom latin ",f3));
                     c1.setPadding(4f);     
                   table.addCell(c1);
                   
                  CategorieCRUD s=new CategorieCRUD();
                    ArrayList<Categorie> e =(ArrayList<Categorie>)s.afficherCategorie();
                    for(int i=0;i<e.size();i++)
                    {
                      String n=e.get(i).getNom_cath();
                     Font f4=new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.UNDEFINED, BaseColor.BLACK);
                       c1=new PdfPCell(new Phrase(n,f4));
                       table.addCell(c1);
                                 
                       String dd=e.get(i).getNom_latin();
                
                       c1=new PdfPCell(new Phrase(dd,f4));
                       table.addCell(c1);
                      
                    }
                   
                   document.add(table);
                        
               } catch (DocumentException ex) {
                   Logger.getLogger(AffichercategorieController.class.getName()).log(Level.SEVERE, null, ex);
               }
               document.close();
        
    }

    @FXML
    private void envoiemailcat(ActionEvent event) throws Exception {
            Sendeamil.Send("firas.rejeb@esprit.tn"); 
    }

    @FXML
    private void retourpage1(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        st.setScene(scene);
        st.show();
    }
}
     
        
        
        
        
        


    

       
    

