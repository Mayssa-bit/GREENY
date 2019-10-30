/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Event;
import Services.Impl.EventService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
 * @author HIDOUS MAYSSA
 */
public class ConsulterEventAdminController implements Initializable {

    @FXML
    private TableView<Event> AdminEventTableId;
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
    private TableColumn<Event, String> StandsId;
    @FXML
    private TableColumn<Event, String> PrixId;
    @FXML
    private TableColumn<Event, String> ImageId;
    @FXML
    private Button BackConsulterEventId;
    @FXML
    private Button AddEventId;
    @FXML
    private Button DeleteEventId;
    ObservableList<Event> List_Event = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    @FXML
    private Button UpdateEventid;
    @FXML
    private TextField rechercheid;

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
                ObservableList<Event> obs = FXCollections.observableArrayList(pers);
                AdminEventTableId.setItems(obs);
                NomId.setCellValueFactory(new PropertyValueFactory<>("nomEvenement"));
                AdresseId.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                DebutId.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
                FinId.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
                EtatId.setCellValueFactory(new PropertyValueFactory<>("etat"));
                PlaceId.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                StandsId.setCellValueFactory(new PropertyValueFactory<>("nbStand"));
                PrixId.setCellValueFactory(new PropertyValueFactory<>("prix"));
                ImageId.setCellValueFactory(new PropertyValueFactory<>("image"));

            } catch (SQLException ex) {
                Logger.getLogger(ConsulterEventAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterEventAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BackConsulterEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
        Parent root = loader.load();
        AddEventId.getScene().setRoot(root);
    }

    @FXML
    private void AddEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEvent.fxml"));
        Parent root = loader.load();
        AddEventId.getScene().setRoot(root);
    }

    @FXML
    private void DeleteEvent(ActionEvent event) throws SQLException {

        Alert ajoutdoneAlert = new Alert(Alert.AlertType.CONFIRMATION);
        ajoutdoneAlert.setTitle("Confirmer");
        ajoutdoneAlert.setContentText("Etes vous sur de vouloir supprimer cet event");
        Optional<ButtonType> result = ajoutdoneAlert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Event e_sup = new Event();
            EventService es = new EventService();

            Event E = AdminEventTableId.getItems().get(AdminEventTableId.getSelectionModel().getSelectedIndex());
            e_sup.setIdEvenement(E.getIdEvenement());
            es.deleteEvenementById(e_sup.getIdEvenement());
            try {
                EventService es2 = new EventService();
                Event e = new Event();
                ArrayList<Event> pers;
                try {
                    pers = (ArrayList<Event>) es2.displayEvenement();
                    ObservableList<Event> obs = FXCollections.observableArrayList(pers);
                    AdminEventTableId.setItems(obs);
                    NomId.setCellValueFactory(new PropertyValueFactory<>("nomEvenement"));
                    AdresseId.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                    DebutId.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
                    FinId.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
                    EtatId.setCellValueFactory(new PropertyValueFactory<>("etat"));
                    PlaceId.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
                    StandsId.setCellValueFactory(new PropertyValueFactory<>("nbStand"));
                    PrixId.setCellValueFactory(new PropertyValueFactory<>("prix"));
                    ImageId.setCellValueFactory(new PropertyValueFactory<>("image"));

                } catch (SQLException ex) {
                    Logger.getLogger(ConsulterEventAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsulterEventAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

    }

    @FXML
    private void UpdateEvent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateEvent.fxml"));
        Parent root = loader.load();
        BackConsulterEventId.getScene().setRoot(root);
    }

    @FXML
    private void searchEvent(KeyEvent event) throws SQLException {
        EventService searchtoup = new EventService();
        String msg = rechercheid.getText().concat("%");
        ArrayList<Event> ev = (ArrayList<Event>) searchtoup.chercher(msg);
        ObservableList<Event> obs1 = FXCollections.observableArrayList(ev);
        AdminEventTableId.setItems(obs1);
    }
}

