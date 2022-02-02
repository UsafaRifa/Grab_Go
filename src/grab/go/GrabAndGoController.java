/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class GrabAndGoController implements Initializable {

    @FXML
    private Button addEmployeeButton;
    @FXML
    private Button showEmployee;
    public static HBox EmployeeHbox;
    @FXML
    private AnchorPane GrabPage;
    @FXML
    private HBox EmployeeHbox1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }  

    @FXML
    private void addEmployee(ActionEvent event) throws IOException {
    
      Parent pane=FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
                EmployeeHbox1.getChildren().setAll(pane);
    
    }

    @FXML
    private void showAll(ActionEvent event) throws IOException {
             Parent pane=FXMLLoader.load(getClass().getResource("ShowEmployee.fxml"));
                EmployeeHbox1.getChildren().setAll(pane);
    
    }

    
}
