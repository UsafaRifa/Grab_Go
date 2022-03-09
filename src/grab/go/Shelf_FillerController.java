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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author FUJITSU
 */
public class Shelf_FillerController implements Initializable {

    @FXML
    private JFXButton Add_Product_toShelf;
    @FXML
    private HBox AddProductHbox;
    @FXML
    private Button P_Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void P_Back(ActionEvent event) {
    }

    @FXML
    private void addShelfOnAction(MouseEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Shelf_Fill.fxml"));
                 AddProductHbox.getChildren().setAll(pane);
    }
    
}
