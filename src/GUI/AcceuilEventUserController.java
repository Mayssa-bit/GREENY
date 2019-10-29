/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Service.EventService;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayss
 */
public class AcceuilEventUserController implements Initializable {

    @FXML
    private Button BackAcceuilEventUserId;
    @FXML
    private Button NoteEventUserId;
    @FXML
    private Button ReserverEventUserId;
    @FXML
    private TableView<Event> UserEventTableId;
    @FXML
    private TableColumn<Event, String> NomId;
    @FXML
    private TableColumn<Event, String> AdresseId;
    @FXML
    private TableColumn<Event, String> DebutId;
    @FXML
    private TableColumn<Event, String> FinId;
    @FXML
    private TableColumn<Event, String> EtatId;
    @FXML
    private TableColumn<Event, String> PlaceId;
    @FXML
    private TableColumn<Event, String> StandId;
    @FXML
    private TableColumn<Event, String> PrixId;
    @FXML
    private TableColumn<Event, String> ImageId;
    ObservableList<Event> List_Event = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                try {
                    EventService es = new EventService();
                    Event e = new Event();
                    ArrayList<Event> pers;
                    try {
                        pers = (ArrayList<Event>) es.displayEvenement();
                        ObservableList<Event> obs=FXCollections.observableArrayList(pers);
                        UserEventTableId.setItems(obs);
                        NomId.setCellValueFactory(new PropertyValueFactory<>("nomEvenement") );
                        //NomId.cellFactoryProperty();
                        AdresseId.setCellValueFactory(new PropertyValueFactory<>("adresse") );
                        //AdresseId.cellFactoryProperty();
                        DebutId.setCellValueFactory(new PropertyValueFactory<>("dateDebut") );
                        //DebutId.cellFactoryProperty();
                        FinId.setCellValueFactory(new PropertyValueFactory<>("dateFin") );
                        //FinId.cellFactoryProperty();
                        EtatId.setCellValueFactory(new PropertyValueFactory<>("etat") );
                        // EtatId.cellFactoryProperty();
                        PlaceId.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                        //PlaceId.cellFactoryProperty();
                        StandId.setCellValueFactory(new PropertyValueFactory<>("nbStand") );
                        //StandsId.cellFactoryProperty();
                        PrixId.setCellValueFactory(new PropertyValueFactory<>("prix") );
                        //PrixId.cellFactoryProperty();
                        ImageId.setCellValueFactory(new PropertyValueFactory<>("image"));
                        //ImageId.cellFactoryProperty();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(AcceuilEventUserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
            Logger.getLogger(AcceuilEventUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void BackAcceuilEventUser(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AcceuilEvent.fxml"));
            Parent root=loader.load();
            Stage st = new Stage();
            Scene scene = new Scene(root);
            scene.setRoot(root);
            st.setScene(scene);
            st.show();
    }


    @FXML
    private void ReserverEventUser(ActionEvent event) {
    }


    @FXML
    private void NoteEventUser(ActionEvent event) {
    }
    
}
