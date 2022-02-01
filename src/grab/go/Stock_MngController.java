/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Stock_MngController implements Initializable {

    @FXML
    private JFXButton Add_P_Stock;
    @FXML
    private JFXButton Show_P_Stock;
    @FXML
    private JFXButton Back_Stock;
    @FXML
    private AnchorPane Stock_page;
    @FXML
    private HBox stockHbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add_P_Stock(ActionEvent event) throws IOException {
        
        Parent pane=FXMLLoader.load(getClass().getResource("Add_ProductStock.fxml"));
                 stockHbox.getChildren().setAll(pane);
    }

    @FXML
    private void Back_Stock(ActionEvent event) throws IOException {
        
             Parent pane=FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
                Stock_page.getChildren().setAll(pane);
    
    }

    @FXML
    private void Show_P_Stock(ActionEvent event) throws IOException {
        
        Parent pane=FXMLLoader.load(getClass().getResource("Show_ProductStock.fxml"));
                 stockHbox.getChildren().setAll(pane);
        
       
    
    }
    
}
