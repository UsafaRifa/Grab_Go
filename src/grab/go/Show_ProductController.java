/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Show_ProductController implements Initializable {

    @FXML
    private TableColumn<?, ?> ProductIdCol;
    @FXML
    private TableColumn<?, ?> ProductName;
    @FXML
    private TableColumn<?, ?> AvailableStocks;
    @FXML
    private TableColumn<?, ?> ShelfNo;
    @FXML
    private TableColumn<?, ?> MFGDate;
    @FXML
    private TableColumn<?, ?> ExpireDate;
    @FXML
    private TableColumn<?, ?> UnitPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
