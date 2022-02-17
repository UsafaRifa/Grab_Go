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


public class Customer_MngController implements Initializable {

    @FXML
    private JFXButton Add_Customer;
    @FXML
    private JFXButton All_Customer;
    @FXML
    private JFXButton Back;
    @FXML
    private HBox hbox_customer;
    @FXML
    private AnchorPane CustomerPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add_Customer(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Add_Customer.fxml"));
                 hbox_customer.getChildren().setAll(pane);
        
        
        
    }

    @FXML
    private void All_Customer(ActionEvent event) throws IOException {
        
        
        Parent pane=FXMLLoader.load(getClass().getResource("Show_Customer.fxml"));
                 hbox_customer.getChildren().setAll(pane);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
         Parent pane=FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
               CustomerPage.getChildren().setAll(pane);
    }
    
}
