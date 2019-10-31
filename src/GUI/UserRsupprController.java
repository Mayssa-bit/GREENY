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
import static Gui.ConsulterReclamationController.descri;
import static Gui.ConsulterReclamationController.idsupp;
import static Gui.ConsulterReclamationController.name;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class UserRsupprController implements Initializable {

    @FXML
    private TextFlow text;
    @FXML
    private Button ok;
    @FXML
    private Text textData;
    @FXML
    private Button delete;
    @FXML
    private Button impr;
    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ok(ActionEvent event) {
        
        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();

    }
    
     public void setData(String id, String name, String desc) {
        
        textData.setText("Type : " + id + "  Name : " + name + "  Description : " + desc);

    }

    @FXML
    private void Delete(ActionEvent event) throws IOException {
      int id = idsupp ;
        Reclamation r = new Reclamation();
        r.setIdreclamation(id);
        ReclamationCRUD r1 = new ReclamationCRUD();
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation");
        alert1.setContentText("Etes vous sur de vouloir Annuler cette Reclamation défintivement");
        alert1.setHeaderText(null);
        Optional<ButtonType> action = alert1.showAndWait();
        if (action.get() == ButtonType.OK) {
        r1.supprimerReclamation(r);
        
         
       FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterReclamation.fxml"));
            Parent root=loader.load();
         //   Stage st = new Stage();
         //   Scene scene = new Scene(root);
         delete.getScene().setRoot(root);

        
        
         /*    Parent root;        
             
          root=FXMLLoader.load(getClass().getResource("../gui/ConsulterReclamation.fxml"));
                delete.getScene().setRoot(root);
*/
        }  }

    @FXML
    private void impr(ActionEvent event) throws SQLException {
        String ad="C:\\Users\\HP\\Desktop\\Pépinére1\\reclamation.pdf";
                Document doc=new Document();
               try {
                    try {
                        PdfWriter.getInstance(doc, new FileOutputStream(ad));
                    } catch (DocumentException ex) {
                        Logger.getLogger(UserRsupprController.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
               } catch (FileNotFoundException ex) {
                 Alert alerta = new Alert(Alert.AlertType.ERROR);
                         
                         alerta.setTitle("Notification");
                         alerta.setContentText("veuillez saisir un chemin VALIDE ! ");
                         alerta.showAndWait();
               }
               doc.open();
               try {
                    Font fa=new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.UNDERLINE, BaseColor.GREEN.brighter());
                   Paragraph united=new Paragraph("UNITED",fa);
                   united.setAlignment(Element.ALIGN_RIGHT);
                   doc.add(united);
                   
                   Font f=new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.UNDERLINE, BaseColor.GREEN.darker());
                   Paragraph p=new Paragraph("Pepeniere\n",f);
                   p.setAlignment(Element.ALIGN_CENTER);
                   doc.add(p);
Font f1=new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p1=new Paragraph("Lettre de Reclamation",f1);
                   p1.setAlignment(Element.ALIGN_CENTER);
                   doc.add(p1);
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
String d=   dtf.format(now);
 Font f2=new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLACK);
 Paragraph p2=new Paragraph("\nDate: "+d,f2);
   doc.add(p2);
      doc.add(new Paragraph("NOM ET PRENOM : : " ,f2));
      doc.add(new Paragraph(" "+name));
                   PdfPTable table = new PdfPTable(8);
                   table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        
                   Font f3=new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDEFINED, BaseColor.BLUE);
                 //  PdfPCell c1=new PdfPCell(new Phrase("Nom du Produit",f3));
                //   c1.setPadding(4f);
                 //  table.addCell(c1);
              
                  // table.setHeaderRows(0);
                  ReclamationCRUD s=new ReclamationCRUD();
                    ArrayList<Reclamation> e =(ArrayList<Reclamation>)s.getAllcommandes();
              
                   doc.add(table);
                  
                doc.add(new Paragraph("Reclamation: " ,f2)); 
                doc.add(new Paragraph(" "+descri));
               } catch (DocumentException ex) {
                   Logger.getLogger(UserRsupprController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(UserRsupprController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.close();
    }
    
    
}
