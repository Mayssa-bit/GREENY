/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Entities.Reservation;
import Service.EventService;
import Service.ReservationService;
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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import utils.EMAIL;

/**
 * FXML Controller class
 *
 * @author mayss
 */
public class AcceuilEventUserController implements Initializable {

    @FXML
    private Button BackAcceuilEventUserId;
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
    
    @FXML
    private Button AnnulerBt;
    @FXML
    private Button ReserverBt;
    @FXML
    private TextField ptf;
    @FXML
    private Spinner<Integer> nbsp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
          nbsp.setValueFactory(valueFactory);
          nbsp.valueProperty().addListener((e,o,n)->{
               ptf.setText("Prix: "+nbsp.getValue()*UserEventTableId.getSelectionModel().getSelectedItem().getPrix()+"Dt");
                 
           
          });
          ReserverEventUserId.setDisable(true);
          UserEventTableId.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
        ReserverEventUserId.setDisable(false);
    }
});
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
//            Stage st = new Stage();
//            Scene scene = new Scene(root);
//            scene.setRoot(root);
//            st.setScene(scene);
//            st.show();
    }


    @FXML
    private void ReserverEventUser(ActionEvent event) {
        
        
        
       
            ReserverEventUserId.setVisible(false);
            AnnulerBt.setVisible(true);
            ReserverBt.setVisible(true);
            nbsp.setVisible(true);
            nbsp.getValueFactory().setValue(Integer.MIN_VALUE);
            ptf.setVisible(true);
            
            
      
        
        
    }



    @FXML
    private void annulerbta(ActionEvent event) {
        ReserverEventUserId.setVisible(true);
        AnnulerBt.setVisible(false);
        ReserverBt.setVisible(false);
       nbsp.setVisible(false);
      ptf.setVisible(false);
        
    }

    @FXML
    private void reserverbta(ActionEvent event) throws IOException {
        
        try {
            Event eee=UserEventTableId.getSelectionModel().getSelectedItem();
            Reservation r = new Reservation(eee.getIdEvenement(), 13, nbsp.getValue());
            ReservationService rs = new ReservationService();
            if(rs.reserver(r)==1){
                Alert ajoutdoneAlert = new Alert(Alert.AlertType.INFORMATION);
            ajoutdoneAlert.setTitle("Reservation");
            ajoutdoneAlert.setContentText("Réservation validée");
            ajoutdoneAlert.showAndWait();
                 Parent root = FXMLLoader.load(getClass().getResource("AcceuilEventUser.fxml"));
                 AnnulerBt.getScene().setRoot(root);
                 EMAIL.sendEmail("mayssa.hidous@esprit.tn", "Reservation", "Vous avier reserver le "+eee.getDateDebut()+" pour "+r.getNbp()+" personne(s) au nom de Mayssa a l evennement "+eee.getNomEvenement()+" veuiller vous presenter qvec cette reservqqtion au pres de gichet afain de payer la somme de "+eee.getPrix()*r.getNbp()+ " DT Merci");
                System.out.println("reserver");
            }
            else {
                 Alert ajoutdoneAlert = new Alert(Alert.AlertType.WARNING);
            ajoutdoneAlert.setTitle("alerte");
            ajoutdoneAlert.setContentText("Pas de place disponible");
            ajoutdoneAlert.showAndWait();
                System.out.println("error");
            }
            
            
            ReserverEventUserId.setVisible(true);
            AnnulerBt.setVisible(false);
            ReserverBt.setVisible(false);
            nbsp.setVisible(false);
            ptf.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilEventUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void spchanged(InputMethodEvent event) {
        
        ptf.setText("Prix: "+nbsp.getValue()*UserEventTableId.getSelectionModel().getSelectedItem().getPrix()+"Dt");
        
        System.out.println("aaaaaaaaaaaaaaaa");
        
    }
    
}
