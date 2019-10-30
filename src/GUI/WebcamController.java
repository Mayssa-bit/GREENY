/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.WebcamController.image;
import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.mail.Service;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class WebcamController implements Initializable {

    @FXML
    private Button captureid;
    @FXML
    private ImageView imId;
    @FXML
    private Button recapid;
    @FXML
    private Button validerid;
    Webcam webcam;
    
    public static Image image;
    public static boolean take = false;
    
    ScheduledService tst;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webcam = Webcam.getDefault();
       
        webcam.setViewSize(new Dimension(320, 240));
        webcam.open();
         class VideoFeederTaker extends ScheduledService{

            
      
        
        @Override
        protected Task createTask() {
            return new Task<Void>(){

            @Override
            protected Void call() throws Exception {
               
              
               image = SwingFXUtils.toFXImage(webcam.getImage(), null);
               imId.setImage(image);
               Thread.sleep(100);
                
               return null;
                
             }
            };
        }
    }
        validerid.setVisible(false);
        tst = new VideoFeederTaker();
         tst.start();
        
        //
    }    

        // TODO
        

    @FXML
    private void CaptureAction(ActionEvent event) {
        tst.cancel();
        image = SwingFXUtils.toFXImage(webcam.getImage(), null);
        imId.setImage(image);
        captureid.setVisible(false);
        validerid.setVisible(true);
        recapid.setDisable(false);
    }

    @FXML
    private void RecapAction(ActionEvent event) {
        captureid.setVisible(true);
        validerid.setVisible(false);
        recapid.setDisable(false);
        tst.restart();
    }

    @FXML
    private void ValidAction(ActionEvent event) {
        take=true;
         webcam.close();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
 
    
}
