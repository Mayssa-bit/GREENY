/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Service.EventService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayss
 */
public class UpdateEventController implements Initializable {

    @FXML
    private DatePicker UpdateDebutId;
    @FXML
    private TextField UpdateNomId;
    @FXML
    private DatePicker UpdateFinId;
    @FXML
    private TextField UpdateAdresseId;
    @FXML
    private TextField UpdateEtatId;
    @FXML
    private TextField UpdatePlaceId;
    @FXML
    private TextField UpdateStandId;
    @FXML
    private TextField UpdatePrixId;
    @FXML
    private Button UpdateEventId;
    @FXML
    private TextField UpdateImageId;
    File file;
    Stage stage;
    @FXML
    private TextField IdId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateFinId.setDisable(true);
        UpdateDebutId.setDayCellFactory(picker -> new DateCell() {
        @Override
            public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {        
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }
        });
        UpdateDebutId.valueProperty().addListener(new ChangeListener(){
            @Override
            public void changed (ObservableValue observable, Object oldValue, Object newValue){
            UpdateFinId.setDisable(false);
            UpdateFinId.setDayCellFactory(picker -> new DateCell() {
                @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        if (date.isBefore(UpdateDebutId.getValue())) {  
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                });
            }
        });
    }   

    @FXML
    private void UpdateImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                
                new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif")
        );
        file = fileChooser.showOpenDialog(stage);
        if (file!=null) {
            try {
                String img = file.toURI().toURL().toString();
                System.out.println(img);
                UpdateImageId.setText(img);
            } catch (MalformedURLException ex) {
                Logger.getLogger(UpdateEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void Updateevent(ActionEvent event) throws SQLException, IOException {
        if(UpdateNomId.getText().isEmpty() | UpdateAdresseId.getText().isEmpty() | UpdateDebutId.getValue()==null|UpdateFinId.getValue()==null | UpdateEtatId.getText().isEmpty()|UpdatePlaceId.getText().isEmpty()|UpdateStandId.getText().isEmpty()|UpdatePrixId.getText().isEmpty())
            {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("warning");
            alert.setHeaderText(null);
            alert.setContentText("Verify Your TextFields");
            alert.showAndWait();
            
             }
	else{
            Event e = new Event();   
            if (!UpdateNomId.getText().toString().equals("")){
                e.setNomEvenement(UpdateNomId.getText());}
            if (!UpdateAdresseId.getText().toString().equals("")){
                e.setAdresse(UpdateAdresseId.getText());}
            if(!Date.valueOf(UpdateDebutId.getValue()).toString().equals("")){
                e.setDateDebut(Date.valueOf(UpdateDebutId.getValue()));}
            if(!Date.valueOf(UpdateFinId.getValue()).toString().equals("")){
                e.setDateFin(Date.valueOf(UpdateFinId.getValue()));}
            if (!UpdateEtatId.getText().toString().equals("")){
                e.setEtat(UpdateEtatId.getText());}
            if (!UpdatePlaceId.getText().toString().equals("")){
            e.setNbPlace(Integer.parseInt(UpdatePlaceId.getText()));}
            if (!UpdateStandId.getText().toString().equals("")){
                e.setNbStand(Integer.parseInt(UpdateStandId.getText()));}
            if (!UpdatePrixId.getText().toString().equals("")){
                e.setPrix(Integer.parseInt(UpdatePrixId.getText()));}
            if (!UpdateImageId.getText().toString().equals("")){
                e.setImage(UpdateImageId.getText());}
            EventService es = new EventService();
            es.updateEvenement(e,Integer.parseInt(IdId.getText()));
            
            Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
            ajoutdoneAlert.setTitle("Done");
            ajoutdoneAlert.setContentText("Evénement Modifié");
            ajoutdoneAlert.show();
            
            //((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ConsulterEventAdmin.fxml"));
            Parent root=loader.load();
            UpdateAdresseId.getScene().setRoot(root);
//            Scene sc = new Scene(root);
//            Stage st = new Stage();
//            sc.setRoot(root);
//            st.setScene(sc);
//            st.show();
        }
               
    }
    
    
}
