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

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Show_ProductStockController implements Initializable {

    @FXML
    private TableColumn<?, ?> Stock_ProductName;
    @FXML
    private TableColumn<?, ?> StockProduct_Quantity;
    @FXML
    private TableColumn<?, ?> Stock_Upcoming;
    @FXML
    private JFXButton StockUpdate;
    @FXML
    private JFXButton StockDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void StockUpdate(ActionEvent event) {
    }

    @FXML
    private void StockDelete(ActionEvent event) {
    }
    
}
