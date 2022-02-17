/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class UpdateCustomerInfoController implements Initializable {

    @FXML
    private JFXTextField emp_id;
    @FXML
    private JFXTextField Customername;
    @FXML
    private JFXTextField CustomerPhone;
    @FXML
    private JFXTextArea CustomerAddress;
    @FXML
    private JFXTextField CustomerCredit;
    @FXML
    private ComboBox<String> CustomerMember;
    @FXML
    private JFXTextField CustomerEmail;
ObservableList<String> typeall = FXCollections.observableArrayList(
                  "Gold", "Silver","Platinum");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         CustomerMember.setItems(typeall);
         String CustomerId= Show_CustomerController.customer.CustomerID ;
       String CustomerName= Show_CustomerController.customer.CustomerName ; 
       String Customeraddress= Show_CustomerController.customer.CustomerAddress ; 
       String Customeremail= Show_CustomerController.customer.CustomerEmail ; 
       String Customerphone= Show_CustomerController.customer.CustomerPhoneNumber ; 
       String Membershiptype=Show_CustomerController.customer.MembershipType; 
       String Creditcus=Show_CustomerController.customer.Credit; 
          emp_id.setText(CustomerId);
          Customername.setText(CustomerName);   
          CustomerPhone.setText(Customerphone); 
          CustomerAddress.setText(Customeraddress);  
          CustomerCredit.setText(Creditcus);  
          CustomerMember.setValue(Membershiptype);
          CustomerEmail.setText(Customeremail);
          
         
    }    

    @FXML
    private void updatecustomer(ActionEvent event) throws ClassNotFoundException, SQLException {
       String CustomerId= emp_id.getText() ;
       String CustomerName= Customername.getText() ; 
       String Customeraddress= CustomerAddress.getText() ; 
       String Customeremail= CustomerEmail.getText() ; 
       String Customerphone= CustomerPhone.getText() ; 
       String Membershiptype=CustomerMember.getValue(); 
       String Creditcus=CustomerCredit.getText(); 
       Customer cd=new Customer( CustomerId,CustomerName,Customeraddress, Customeremail,Customerphone, Membershiptype,Creditcus);
         System.out.println(cd);
         updateCustomer(cd);
         emp_id.clear();
         Customername.clear();
        CustomerAddress.clear();
        CustomerEmail.clear();
                CustomerPhone.clear();
                CustomerMember.setItems(typeall);
                        CustomerCredit.clear();
    }
        private void updateCustomer(Customer cs) throws ClassNotFoundException, SQLException{
       
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
      String query = "UPDATE Customer SET CustomerName='"+cs.CustomerName+"', CustomerAddress='"+cs.CustomerAddress+"', CustomerEmail='"+cs.CustomerEmail+"',CustomerPhone='"+cs.CustomerPhoneNumber+"',MembershipType='"+cs.MembershipType+"',CustomerCredit='"+cs.Credit+"' WHERE CustomerId='"+cs.CustomerID+"'";
    
       System.out.println(query);
        //ResultSet dataInserted = dbc.queryToDB(query);
         boolean dataInserted = dbc.insertDataToDB(query);
        System.out.println("Updated?: "+dataInserted);

       // System.out.println("Inserted?: "+dataInserted);
       /*CustomerId varchar(50),
CustomerName varchar(50),
CustomerAddress varchar(50),
CustomerEmail varchar(50),
CustomerPhone varchar(50),
MembershipType varchar(50),
CustomerCredit varchar(50)*/
       
    }
}
