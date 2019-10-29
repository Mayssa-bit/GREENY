/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Service.EventService;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayssa
 */
public class AddEventController implements Initializable {

    @FXML
    private TextField addNomEventid;
    @FXML
    private TextField AddAdresseEventid;
    @FXML
    private DatePicker AddFinEventid;
    @FXML
    private TextField AddEtatEventid;
    @FXML
    private TextField AddPlaceEventid;
    @FXML
    private TextField AddStandEventid;
    @FXML
    private TextField AddPrixEventid;
    @FXML
    private Button BackAddEventid;
    @FXML
    private DatePicker testdate;
    private TextField updateIdEventid;
    @FXML
    private TextField imageeventid;
    @FXML
    private Button AddEventid;
    
    File file;
    Stage stage;


    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddFinEventid.setDisable(true);
        testdate.setDayCellFactory(picker -> new DateCell() {
        @Override
            public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {        
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }
        });
        testdate.valueProperty().addListener(new ChangeListener(){
            @Override
            public void changed (ObservableValue observable, Object oldValue, Object newValue){
            AddFinEventid.setDisable(false);
            AddFinEventid.setDayCellFactory(picker -> new DateCell() {
                @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        if (date.isBefore(testdate.getValue())) {  
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                });
            }
        });
    }             
          
          

   
    @FXML
    private void AddEvent(ActionEvent event) throws SQLException, IOException {
        if(addNomEventid.getText().isEmpty() | AddAdresseEventid.getText().isEmpty() | testdate.getValue()==null|AddFinEventid.getValue()==null | AddEtatEventid.getText().isEmpty()|AddPlaceEventid.getText().isEmpty()|AddStandEventid.getText().isEmpty()|AddPrixEventid.getText().isEmpty())
            {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify Your TextFields");
            alert.showAndWait();
            
             }
	else{
            Event e = new Event();
            e.setNomEvenement(addNomEventid.getText());
            e.setAdresse(AddAdresseEventid.getText());
            e.setDateDebut(Date.valueOf(testdate.getValue()));
            e.setDateFin(Date.valueOf(AddFinEventid.getValue()));
            e.setEtat(AddEtatEventid.getText());
            e.setNbPlace(Integer.parseInt(AddPlaceEventid.getText()));
            e.setNbStand(Integer.parseInt(AddStandEventid.getText()));
            e.setPrix(Integer.parseInt(AddPrixEventid.getText()));
            e.setImage(imageeventid.getText());
            
            
            EventService es = new EventService();
            es.insererEvenement(e);
            // ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterEventAdmin.fxml"));
            Parent root=loader.load();
             Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
            ajoutdoneAlert.setTitle("Done");
            ajoutdoneAlert.setContentText("Evénement ajouté");
            ajoutdoneAlert.show();
            AddAdresseEventid.getScene().setRoot(root);
//            Stage st = new Stage();
//            Scene scene = new Scene(root);
//            scene.setRoot(root);
//            st.setScene(scene);
//            st.show();
        }
           
    }


    private void UpdateEvent(ActionEvent event) throws IOException, SQLException {
        if(addNomEventid.getText().isEmpty() | AddAdresseEventid.getText().isEmpty() | testdate.getValue()==null|AddFinEventid.getValue()==null | AddEtatEventid.getText().isEmpty()|AddPlaceEventid.getText().isEmpty()|AddStandEventid.getText().isEmpty()|AddPrixEventid.getText().isEmpty())
            {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify Your TextFields");
            alert.showAndWait();
            
             }
	else{
            Event e = new Event();   
            if (!addNomEventid.getText().toString().equals("")){
                e.setNomEvenement(addNomEventid.getText());}
            if (!AddAdresseEventid.getText().toString().equals("")){
                e.setAdresse(AddAdresseEventid.getText());}
            if(!Date.valueOf(testdate.getValue()).toString().equals("")){
                e.setDateDebut(Date.valueOf(testdate.getValue()));}
            if(!Date.valueOf(AddFinEventid.getValue()).toString().equals("")){
                e.setDateFin(Date.valueOf(AddFinEventid.getValue()));}
            if (!AddEtatEventid.getText().toString().equals("")){
                e.setEtat(AddEtatEventid.getText());}
            if (!AddPlaceEventid.getText().toString().equals("")){
            e.setNbPlace(Integer.parseInt(AddPlaceEventid.getText()));}
            if (!AddStandEventid.getText().toString().equals("")){
                e.setNbStand(Integer.parseInt(AddStandEventid.getText()));}
            if (!AddPrixEventid.getText().toString().equals("")){
                e.setPrix(Integer.parseInt(AddPrixEventid.getText()));}
            if (!AddPrixEventid.getText().toString().equals("")){
                e.setPrix(Integer.parseInt(AddPrixEventid.getText()));}
            if (!imageeventid.getText().toString().equals("")){
                e.setImage(imageeventid.getText());}
            EventService es = new EventService();
            es.updateEvenement(e,Integer.parseInt(updateIdEventid.getText()));
            
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterEventAdmin.fxml"));
            Parent root=loader.load();
            AddAdresseEventid.getScene().setRoot(root);
//            Scene sc = new Scene(root);
//            Stage st = new Stage();
//            sc.setRoot(root);
//            st.setScene(sc);
//            st.show();
        }
    }


    
    @FXML
    private void BackAddEvent(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterEventAdmin.fxml"));
                Parent root=loader.load();
                AddAdresseEventid.getScene().setRoot(root);
//                Stage st = new Stage();
//                Scene scene = new Scene(root);
//                scene.setRoot(root);
//                st.setScene(scene);
//                st.show();
    }


    @FXML
    private void ajoutphoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                
                new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif")
        );
        file = fileChooser.showOpenDialog(stage);
        if (file!=null) {
            try {
                String img = file.toURI().toURL().toString();
                System.out.println(img);
                imageeventid.setText(img);
            } catch (MalformedURLException ex) {
                Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }}

     
   


    

