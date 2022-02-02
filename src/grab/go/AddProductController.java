/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddProductController implements Initializable {

    @FXML
    private JFXTextField Pro_id;
    @FXML
    private JFXTextField Pro_name;
    @FXML
    private JFXComboBox<?> Shelf_No;
    @FXML
    private JFXDatePicker MFG;
    @FXML
    private JFXDatePicker Expire;
    @FXML
    private JFXTextField Price;
    @FXML
    private JFXCheckBox Ava_Stock;
    @FXML
    private Button Save_pro;
    @FXML
    private Button Reset_Pro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Save_pro(ActionEvent event) {
    }

    @FXML
    private void Reset_Pro(ActionEvent event) {
    }
    
}
