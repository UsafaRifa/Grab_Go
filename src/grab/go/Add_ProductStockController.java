/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Add_ProductStockController implements Initializable {

    @FXML
    private JFXTextField Stock_Product;
    @FXML
    private JFXTextField Product_Quantity;
    @FXML
    private JFXTextField Upcoming_Quantity;
    @FXML
    private JFXButton Save_ProductStock;
    @FXML
    private JFXButton ResetProductStock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Save_ProductStock(ActionEvent event) {
    }

    @FXML
    private void ResetProductStock(ActionEvent event) {
    }
    
}
