/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class webcammain  extends Application {
public void start(Stage primaryStage) {
      
        try {
           Parent root = FXMLLoader.load(getClass().getResource("Webcam.fxml"));
        
        
        Scene scene = new Scene(root);
        
       
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }}
    
    public static void main(String[] args) {
         launch(args);
    }
}
