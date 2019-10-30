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
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class StatUserController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private Button shstatid;
    @FXML
    private Button backid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void load2DataPieChart(ActionEvent event) {
        UserService us = new UserService();
        User u = new User();
        List<User> statsU = us.getAll();
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
        for(User l :statsU){
            
            pieChartData.add(new PieChart.Data(l.getNom(),l.getScore()));
            
        }
        pieChart.setData(pieChartData);
        
    }

    @FXML
    private void Close(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("MenuUtiisateurl.fxml"));
                Parent root=loader.load();
                Stage st = new Stage();
                Scene scene = new Scene(root);
                scene.setRoot(root);
                st.setScene(scene);
                st.show();
    }
    }
    

