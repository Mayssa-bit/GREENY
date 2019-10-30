/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class CalculController implements Initializable {

    @FXML
    private TextField area;
    @FXML
    private Button butt1;
    @FXML
    private Button butt2;
    @FXML
    private Button butt3;
    @FXML
    private Button butt4;
    @FXML
    private Button buutt5;
    @FXML
    private Button butt6;
    @FXML
    private Button butt7;
    @FXML
    private Button butt8;
    @FXML
    private Button butt9;
    @FXML
    private Button butt10;
    @FXML
    private Button butt11;
    @FXML
    private Button butt12;
    @FXML
    private Button butt14;
    @FXML
    private Button butt15;
    @FXML
    private Button butt17;
    @FXML
    private Button butt16;
    @FXML
    private Button butt18;
    static int flag=0;
    @FXML
    private Button reetourcalculaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void wahed(ActionEvent event) {
        area.setText(area.getText()+"1");
    }

    @FXML
    private void thnin(ActionEvent event) {
        area.setText(area.getText()+"2 ");
    }

    @FXML
    private void thletha(ActionEvent event) {
        area.setText(area.getText()+"3");
    }

    @FXML
    private void arbaa(ActionEvent event) {
        area.setText(area.getText()+"4");
    }

    @FXML
    private void khamsa(ActionEvent event) {
        area.setText(area.getText()+"5");
    }

    @FXML
    private void six(ActionEvent event) {
        area.setText(area.getText()+"6");
    }

    @FXML
    private void sabaa(ActionEvent event) {
        area.setText(area.getText()+"7");
    }

    @FXML
    private void thmanya(ActionEvent event) {
        area.setText(area.getText()+"8");
    }

    @FXML
    private void tesaa(ActionEvent event) {
        area.setText(area.getText()+"9");
    }

    @FXML
    private void point(ActionEvent event) {
        area.setText(area.getText()+".");
    }

    @FXML
    private void zero(ActionEvent event) {
        area.setText(area.getText()+"0");
    }

    @FXML
    private void reset(ActionEvent event) {
        area.setText("");
         flag= 0;
    }

    @FXML
    private void plus(ActionEvent event) {
        area.setText(area.getText()+" + ");
         flag= 1;
    }

    @FXML
    private void moin(ActionEvent event) {
        area.setText(area.getText()+" - ");
         flag= 2;
    }

    @FXML
    private void tharb(ActionEvent event) {
        area.setText(area.getText()+" * ");
         flag= 3;
    }

    @FXML
    private void kesma(ActionEvent event) {
        area.setText(area.getText()+" / ");
         flag= 4;
    }

    @FXML
    private void egal(ActionEvent event) {
        area.setText(area.getText()+" = ");
        String str = area.getText();
        String[] substr =str.split("\\s+");
        
        float num1 = Float.parseFloat(substr[0]);
        float num2 = Float.parseFloat(substr[2]);
         if (flag==1)
         {
             area.setText(area.getText()+" "+ (num1+num2));
         }
         if (flag==2)
         {
             area.setText(area.getText()+" "+ (num1-num2));
         }
         if (flag==3)
         {
             area.setText(area.getText()+" "+ (num1*num2));
         }
         if (flag==4)
         {
             area.setText(area.getText()+" "+ (num1/num2));
         }
         if (flag==5)
         {
            area.setText(area.getText()+" "+ (num1%num2));
         }
         
        
        
        
                
         
    }

    @FXML
    private void pourcentage(ActionEvent event) {
    area.setText(area.getText()+"%");
         flag= 5;
    }

    @FXML
    private void retourcalculatriceaff(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Affichercategorie.fxml"));
            Parent root=loader.load();
            Scene sc = new Scene(root);
            Stage st = new Stage();
            sc.setRoot(root);
            st.setScene(sc);
            st.show();
    }
    
}
