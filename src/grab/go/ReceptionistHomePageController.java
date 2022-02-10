/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class ReceptionistHomePageController implements Initializable {

    @FXML
    private AnchorPane ReceptionistHomePage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
               ReceptionistHomePage.getChildren().setAll(pane);
    }

    @FXML
    private void genaratesBill(ActionEvent event) throws IOException {
      Parent pane=FXMLLoader.load(getClass().getResource("BillgenaratePage.fxml"));
                 ReceptionistHomePage.getChildren().setAll(pane);
    }
    
}
