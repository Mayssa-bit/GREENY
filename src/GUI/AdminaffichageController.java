/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.AffichercommandesController;
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
import Entites.Commandes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import Services.Impl.Commandesercices;

/**
 * FXML Controller class
 *
 * @author g
 */
public class AdminaffichageController implements Initializable {

    @FXML
    private TableColumn <Commandes, String> adresseco;
    @FXML
    private TableColumn<Commandes, String> emailco;
    @FXML
    private TableColumn<Commandes, String> numuco;
    @FXML
    private TableColumn<Commandes, String> quantiteco;
    @FXML
    private TableColumn<Commandes, String> prixcomco;
    @FXML
    private TableColumn<Commandes, String> datecco;
    @FXML
    private TableColumn<Commandes, String> datearrco;
    @FXML
    private TableColumn<Commandes, String>nomco;
    @FXML
    private TableColumn<Commandes, String> prenomco;
    @FXML
    private TableColumn<Commandes, String> nomproco;
    @FXML
    private TableColumn<Commandes, String> imageco;
    @FXML
    private TableColumn<Commandes, String> prixproco;
    @FXML
    private TableView<Commandes> afficheadmin;
    @FXML
    private Button chercher1;
    @FXML
    private TableColumn<Commandes, String>Validationn;
    @FXML
    private DatePicker date2;
    Date dateFinal2;
    Commandesercices serv = new Commandesercices();
    @FXML
    private Button suppadmin;
    @FXML
    private TextField textaff;
    @FXML
    private Button stat;
    @FXML
    private Button rapport;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Commandesercices comm =new Commandesercices();  
         ArrayList<Commandes> pers;
        try {
            pers = (ArrayList<Commandes>) comm.getAllcommandesvalide();
           
            ObservableList<Commandes> obs=FXCollections.observableArrayList(pers);
            afficheadmin.setItems(obs);
           // nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
         //  Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom") );
         //   numu.setCellValueFactory(new PropertyValueFactory<>("numu") );
         
          
            adresseco.setCellValueFactory(new PropertyValueFactory<>("adresse") );
            nomproco.setCellValueFactory(new PropertyValueFactory<>("prodname") );
            emailco.setCellValueFactory(new PropertyValueFactory<>("email") );
            numuco.setCellValueFactory(new PropertyValueFactory<>("numu") );
            quantiteco.setCellValueFactory(new PropertyValueFactory<>("quantité"));
             prixcomco.setCellValueFactory(new PropertyValueFactory<>("Prixcom") );
               datecco.setCellValueFactory(new PropertyValueFactory<>("datec") );
               datearrco.setCellValueFactory(new PropertyValueFactory<>("datear") );
               nomco.setCellValueFactory(new PropertyValueFactory<>("nom") );
               prenomco.setCellValueFactory(new PropertyValueFactory<>("prenom") );
              
               imageco.setCellValueFactory(new PropertyValueFactory<>("image") );
               prixproco.setCellValueFactory(new PropertyValueFactory<>("prixprod") );
               Validationn.setCellValueFactory(new PropertyValueFactory<>("Validation") );
               
       //     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         //   email.setCellValueFactory(new PropertyValueFactory<>("email") );
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void chercher11(ActionEvent event) throws SQLException, ParseException {
        
        
       String date = date2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        System.out.println(date);
        
        
        
        
        Commandesercices comm = new Commandesercices(); 
          ArrayList<Commandes> pers;
        try {
            pers = (ArrayList<Commandes>) comm.rrrr(date);
           
            ObservableList<Commandes> obs=FXCollections.observableArrayList(pers);
            afficheadmin.setItems(obs);
           // nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
         //  Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom") );
         //   numu.setCellValueFactory(new PropertyValueFactory<>("numu") );
         
          
            adresseco.setCellValueFactory(new PropertyValueFactory<>("adresse") );
            nomproco.setCellValueFactory(new PropertyValueFactory<>("prodname") );
            emailco.setCellValueFactory(new PropertyValueFactory<>("email") );
            numuco.setCellValueFactory(new PropertyValueFactory<>("numu") );
            quantiteco.setCellValueFactory(new PropertyValueFactory<>("quantité"));
             prixcomco.setCellValueFactory(new PropertyValueFactory<>("Prixcom") );
               datecco.setCellValueFactory(new PropertyValueFactory<>("datec") );
               datearrco.setCellValueFactory(new PropertyValueFactory<>("datear") );
               nomco.setCellValueFactory(new PropertyValueFactory<>("nom") );
               prenomco.setCellValueFactory(new PropertyValueFactory<>("prenom") );
              
               imageco.setCellValueFactory(new PropertyValueFactory<>("image") );
               prixproco.setCellValueFactory(new PropertyValueFactory<>("prixprod") );
               Validationn.setCellValueFactory(new PropertyValueFactory<>("Validation") );
               
       //     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         //   email.setCellValueFactory(new PropertyValueFactory<>("email") );
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void admindelete(ActionEvent event) throws SQLException {
        
       Commandesercices comm =new Commandesercices();
      if (!afficheadmin.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(" ");
            alert.setHeaderText("Etes-vous sur que vous voulez supprimer la commande ! : "
                    + afficheadmin.getSelectionModel().getSelectedItem().getProdname()+ "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                   
                comm.SupprimerComdPro(afficheadmin.getSelectionModel().getSelectedItem().getIdc());
                
     
            
            }
          
      }
       
         ArrayList<Commandes> pers;
        try {
            pers = (ArrayList<Commandes>) comm.getAllcommandesvalide();
           
            ObservableList<Commandes> obs=FXCollections.observableArrayList(pers);
            afficheadmin.setItems(obs);
           // nom.setCellValueFactory(new PropertyValueFactory<>("nom") );
         //  Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom") );
         //   numu.setCellValueFactory(new PropertyValueFactory<>("numu") );
         
          
            adresseco.setCellValueFactory(new PropertyValueFactory<>("adresse") );
            nomproco.setCellValueFactory(new PropertyValueFactory<>("prodname") );
            emailco.setCellValueFactory(new PropertyValueFactory<>("email") );
            numuco.setCellValueFactory(new PropertyValueFactory<>("numu") );
            quantiteco.setCellValueFactory(new PropertyValueFactory<>("quantité"));
             prixcomco.setCellValueFactory(new PropertyValueFactory<>("Prixcom") );
               datecco.setCellValueFactory(new PropertyValueFactory<>("datec") );
               datearrco.setCellValueFactory(new PropertyValueFactory<>("datear") );
               nomco.setCellValueFactory(new PropertyValueFactory<>("nom") );
               prenomco.setCellValueFactory(new PropertyValueFactory<>("prenom") );
              
               imageco.setCellValueFactory(new PropertyValueFactory<>("image") );
               prixproco.setCellValueFactory(new PropertyValueFactory<>("prixprod") );
               Validationn.setCellValueFactory(new PropertyValueFactory<>("Validation") );
               
       //     adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         //   email.setCellValueFactory(new PropertyValueFactory<>("email") );
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichercommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void chercherkey(KeyEvent event) {
        Commandesercices ps = new Commandesercices();
            String msg = textaff.getText().concat("%");
            //(!(msg.equals(""))){ 
            ArrayList<Commandes> pers=(ArrayList<Commandes>) ps.chercher(msg);
            ObservableList<Commandes> obs1 = FXCollections.observableArrayList(pers);
            afficheadmin.setItems(obs1);    
    }

    @FXML
    private void stat(ActionEvent event) throws SQLException {
         Commandesercices ps = new Commandesercices();
        
        
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
          dataset.setValue(ps.nbrvalide(), "commande", "validee");
          //
          dataset.setValue(ps.nbrnonvalide(), "commande", "nonvalidee");
          dataset.setValue(ps.total(), "commande ", " Total");
  JFreeChart chart=ChartFactory.createBarChart("commandes ", "", "commande", dataset);
  //chart.setBackgroundPaint(Color.YELLOW);
  //chart.getTitle().setPaint(Color.red);
  CategoryPlot p=chart.getCategoryPlot();
  //p.setRangeGridlinePaint(Color.BLUE);
  ChartFrame frame=new ChartFrame("commande Bar",chart);
  frame.setVisible(true);
  frame.setSize(450, 350);
        
        
        
        
        
    }

    @FXML
    private void rapport(ActionEvent event) {
        
        
 String ad="C:\\Users\\HP\\Desktop\\Pépinére1\\commandes.pdf";
                Document doc=new Document();
               try {
                    try {
                        PdfWriter.getInstance(doc, new FileOutputStream(ad));
                    } catch (DocumentException ex) {
                        Logger.getLogger(AdminaffichageController.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
               } catch (FileNotFoundException ex) {
                 Alert alerta = new Alert(Alert.AlertType.ERROR);
                         
                         alerta.setTitle("Notification");
                         alerta.setContentText("veuillez saisir un chemin VALIDE ! ");
                         alerta.showAndWait();
               }
               doc.open();
               try {
                   
                   Font f=new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p=new Paragraph("Pepeniere\n",f);
                   p.setAlignment(Element.ALIGN_CENTER);
                   doc.add(p);
Font f1=new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p1=new Paragraph("Rapports des Commandes",f1);
                   p1.setAlignment(Element.ALIGN_CENTER);
                   doc.add(p1);
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
String d=   dtf.format(now);
 Font f2=new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLACK);
 Paragraph p2=new Paragraph("\nDate: "+d,f2);
   doc.add(p2);
      doc.add(new Paragraph("Gerant responsable : " ,f2));
      doc.add(new Paragraph(" "));
                   PdfPTable table = new PdfPTable(8);
                   table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        
                   Font f3=new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDEFINED, BaseColor.BLUE);
                   PdfPCell c1=new PdfPCell(new Phrase("Nom du Produit",f3));
                   c1.setPadding(4f);
                   table.addCell(c1);
                   
                     c1=new PdfPCell(new Phrase("nom ",f3));
                     c1.setPadding(4f);     
                   table.addCell(c1);
                   
                     c1=new PdfPCell(new Phrase("Prenom ",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                   
                     c1=new PdfPCell(new Phrase("Email ",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                   
                     c1=new PdfPCell(new Phrase("Prix commande",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                   
                   
                   
                   c1=new PdfPCell(new Phrase("Quantite commande",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                   
                   c1=new PdfPCell(new Phrase("Date commande",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                 
                   
                   c1=new PdfPCell(new Phrase("Date arrive commande",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                  // table.setHeaderRows(0);
                  Commandesercices s=new Commandesercices();
                    ArrayList<Commandes> e =(ArrayList<Commandes>)s.getAllcommandesvalide();
                    for(int i=0;i<e.size();i++)
                    {
                      String n=e.get(i).getProdname();
                     Font f4=new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.UNDEFINED, BaseColor.BLACK);
                       c1=new PdfPCell(new Phrase(n,f4));
                       table.addCell(c1);
                       
                       
                       
                       String b=e.get(i).getNom();
                 //    Font f4=new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.UNDEFINED, BaseColor.BLACK);
                       c1=new PdfPCell(new Phrase(b,f4));
                       table.addCell(c1);
                        
                       
                       
                                 
                       String dd=e.get(i).getPrenom();
                 //    Font f4=new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.UNDEFINED, BaseColor.BLACK);
                       c1=new PdfPCell(new Phrase(dd,f4));
                       table.addCell(c1);
                       
                        
                        String r=e.get(i).getEmail();
                        c1=new PdfPCell(new Phrase(r,f4));
                        table.addCell(c1);
                        
               
                        
                        
                        int dom=e.get(i).getPrixcom();
                             String r2="";
                               r2+=dom;
                        c1=new PdfPCell(new Phrase(r2,f4));
                        table.addCell(c1);
                        
                        
                        
                        
                        
                        
                        int ddd=e.get(i).getQuantité();
                             String r6="";
                               r6+=ddd;
                        c1=new PdfPCell(new Phrase(r6,f4));
                        table.addCell(c1);
                        
                        
                        String date = e.get(i).getDatec().toString();
                        
                        c1=new PdfPCell(new Phrase(date,f4));
                        table.addCell(c1);
                        
                        
                        
                        
                           String date5 = e.get(i).getDatear().toString();
                        
                        c1=new PdfPCell(new Phrase(date5,f4));
                        table.addCell(c1);
                        
                        
                        
     
  
                      
                    }
                                       
                       
                  
                        
                   doc.add(table);
                    int ss=s.calculer();
                doc.add(new Paragraph("Total Prix commandes : "+ss ,f2));    
               } catch (DocumentException ex) {
                   Logger.getLogger(AdminaffichageController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(AdminaffichageController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.close();
                }
        
        
        
        
        
        
        
        


    
}
