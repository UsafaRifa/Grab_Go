/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;


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
    private JFXButton save_cus_info;
    @FXML
    private JFXButton reset_cus_info;
    @FXML
    private JFXComboBox<String> MembershipType;

          ObservableList<String> typeall = FXCollections.observableArrayList(
                  "Gold", "Silver","Platinum"
        );
    @FXML
    private JFXTextField Credit_cus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MembershipType.setItems(typeall);
        
        
        // TODO
    }  

    @FXML
    private void save_cus_info(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        
        
       String CustomerId= cus_id.getText() ;
       String CustomerName= cus_name.getText() ; 
       String CustomerAddress= cus_add.getText() ; 
       String CustomerEmail= email.getText() ; 
       String CustomerPhone= phone.getText() ; 
       String Membershiptype=MembershipType.getValue(); 
       String Creditcus=Credit_cus.getText(); 
            
     
       Customer cd=new Customer( CustomerId,CustomerName,CustomerAddress, CustomerEmail,CustomerPhone, Membershiptype,Creditcus);
        System.out.println(cd);
       insertCustomer(cd);
         cus_id.clear();
         cus_name.clear();
         email.clear();
         phone.clear();   
         cus_add.clear();
         MembershipType.setItems(typeall);
         Credit_cus.clear();
    }

    @FXML
    private void reset_cus_info(ActionEvent event) {
   
    }

    private void insertCustomer(Customer cd) throws ClassNotFoundException, SQLException {
      
        
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Customer (CustomerId, CustomerName,CustomerAddress,CustomerEmail,CustomerPhone,MembershipType,CustomerCredit) values('" + cd.CustomerID+ "','" + cd.CustomerName+ "','" + cd.CustomerAddress + "','" + cd.CustomerEmail + "','" + cd.CustomerPhoneNumber + "','" + cd.MembershipType+ "','" + cd.Credit+ "')";
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
