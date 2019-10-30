/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.User;
import Services.Impl.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MenuUtiisateurlController implements Initializable {

    @FXML
    private Button supprimer;
    @FXML
    private TableView<User> userTable;
    @FXML
    private TextField searchfield;
ObservableList<User> Liste_Users = FXCollections.observableArrayList();
ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
UserService su = new UserService();
    @FXML
    private TableColumn<?, ?> nomu;
    @FXML
    private TableColumn<?, ?> prenomu;
    @FXML
    private TableColumn<?, ?> emailu;
    @FXML
    private TableColumn<?, ?> phoneu;
    @FXML
    private TableColumn<?, ?> typeu;
    @FXML
    private Button retourid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Liste_Users = FXCollections.observableArrayList(su.getAll());
        userTable.setItems(Liste_Users);
         System.out.println(Liste_Users.get(0).getNom());
         nomu.setCellValueFactory(new PropertyValueFactory<>("nom") );
        nomu.cellFactoryProperty();
         prenomu.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        prenomu.cellFactoryProperty();
         emailu.setCellValueFactory(new PropertyValueFactory<>("email") );
        emailu.cellFactoryProperty();
         phoneu.setCellValueFactory(new PropertyValueFactory<>("phone") );
        phoneu.cellFactoryProperty();
         typeu.setCellValueFactory(new PropertyValueFactory<>("type") );
        typeu.cellFactoryProperty();
             ObservableList data = userTable.getItems();
        searchfield.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                userTable.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<User> subentries = FXCollections.observableArrayList();

            long count = userTable.getColumns().stream().count();
            for (int i = 0; i < userTable.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + userTable.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(userTable.getItems().get(i));
                        break;
                    }
                }
            }
            userTable.setItems(subentries);
        });
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event) {
        UserService su = new UserService();
        userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        User selectedItem = userTable.getSelectionModel().getSelectedItem();
        int a=selectedItem.getCin();
        System.out.println(a);
         Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supression");
                alert.setHeaderText("Attention");
                alert.setContentText("Etes vous sur que vous voulez supprimer ce compte ?");
                alert.showAndWait();
         su.delete(selectedItem);
    userTable.getItems().remove(selectedItem);
       Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("supression")
                .text("user supprimé")
                //.graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.show();
        // TODO
 
        
    }

    private void stat(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("StatUser.fxml"));
                Parent root=loader.load();
                 Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
            
                st.setScene(scene);
                
                st.show();
    }

    @FXML
    private void ClientList() {
        Liste_Users = FXCollections.observableArrayList(su.getAll());
        userTable.setItems(Liste_Users);
         System.out.println(Liste_Users.get(0).getNom());
         nomu.setCellValueFactory(new PropertyValueFactory<>("nom") );
        nomu.cellFactoryProperty();
         prenomu.setCellValueFactory(new PropertyValueFactory<>("prenom") );
        prenomu.cellFactoryProperty();
         emailu.setCellValueFactory(new PropertyValueFactory<>("email") );
        emailu.cellFactoryProperty();
         phoneu.setCellValueFactory(new PropertyValueFactory<>("phone") );
        phoneu.cellFactoryProperty();
         typeu.setCellValueFactory(new PropertyValueFactory<>("type") );
        typeu.cellFactoryProperty();
        
              ObservableList data = userTable.getItems();
        searchfield.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                userTable.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<User> subentries = FXCollections.observableArrayList();

            long count = userTable.getColumns().stream().count();
            for (int i = 0; i < userTable.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + userTable.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(userTable.getItems().get(i));
                        break;
                    }
                }
            }
            userTable.setItems(subentries);
        });
    }

    @FXML
    private void backtohome(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminHome.fxml"));
                Parent root=loader.load();
                 Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
            
                st.setScene(scene);
                
                st.show();
    }
    
}
