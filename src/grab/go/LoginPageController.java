/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class LoginPageController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXComboBox<String> loginas;
        ObservableList<String> logtype = FXCollections.observableArrayList(
                  "Admin","Receptionist","Shelf Filler"

        );
    @FXML
    private AnchorPane LoginPage;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loginas.setItems(logtype);
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
    String Username =username.getText();
    String Password =password.getText();
    String Logas =loginas.getValue();
    
    if(Logas.equals("Admin")){
    
    
         Parent pane=FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
               LoginPage.getChildren().setAll(pane);
    }else if(Logas.equals("Receptionist")){
               Parent pane=FXMLLoader.load(getClass().getResource("ReceptionistHomePage.fxml"));
               LoginPage.getChildren().setAll(pane);
    
    }else if(Logas.equals("Shelf Filler")){
               Parent pane=FXMLLoader.load(getClass().getResource("Shelf_Filler.fxml"));
               LoginPage.getChildren().setAll(pane);
    
    }
    
    }
    
}
