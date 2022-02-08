/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Show_CustomerController implements Initializable {

    @FXML
    private TableColumn<?, ?> Cus_id;
    @FXML
    private TableColumn<?, ?> Cus_name;
    @FXML
    private TableColumn<?, ?> cus_address;
    @FXML
    private TableColumn<?, ?> Cus_email;
    @FXML
    private TableColumn<?, ?> Cus_phone;
    @FXML
    private JFXButton cus_update;
    @FXML
    private JFXButton cus_dlt;
    @FXML
    private TableView<?> Customertable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cus_update(ActionEvent event) {
    }

    @FXML
    private void cus_dlt(ActionEvent event) {
    }
    
}
