/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Add_CustomerController implements Initializable {

    @FXML
    private JFXTextField cus_id;
    @FXML
    private JFXTextField cus_name;
    @FXML
    private JFXTextField cus_add;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXPasswordField cus_pass;
    @FXML
    private JFXButton save_cus_info;
    @FXML
    private JFXButton reset_cus_info;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        // TODO
    }  

    @FXML
    private void save_cus_info(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        
        
       String CustomerId= cus_id.getText() ;
       String CustomerName= cus_name.getText() ; 
       String CustomerAddress= cus_add.getText() ; 
       String CustomerEmail= email.getText() ; 
       String CustomerPhone= phone.getText() ; 
       String CustomerPassword=cus_pass.getText() ; 
            
            
           
     
       Customer cd=new Customer( CustomerId,CustomerName,CustomerAddress, CustomerEmail,CustomerPhone, CustomerPassword);
        System.out.println(cd);
        insertCustomer(cd);
    }

    @FXML
    private void reset_cus_info(ActionEvent event) {
    }

    private void insertCustomer(Customer cd) throws ClassNotFoundException, SQLException {
      
        
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Customer (CustomerId, CustomerName,CustomerAddress,CustomerEmail,CustomerPhone,CustomerPassword) values('" + cd.CustomerID+ "','" + cd.CustomerName+ "','" + cd.CustomerAddress + "','" + cd.CustomerEmail + "','" + cd.CustomerPhoneNumber + "','" + cd.CustomerPassword+ "')";
        System.out.println(query);
        boolean dataInserted = dbc.insertDataToDB(query);
        if(dataInserted)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Customer Added");
            alert.showAndWait();
        }
    }

    
    
    
    
    
    
}
