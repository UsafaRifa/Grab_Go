/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXButton;
import static grab.go.ShowEmployeeController.empn;
import static grab.go.Show_ProductController.productList;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class Show_CustomerController implements Initializable {

    @FXML
    private TableColumn<Customer,String > Cus_id;
    @FXML
    private TableColumn<Customer,String > Cus_name;
    @FXML
    private TableColumn<Customer,String > cus_address;
    @FXML
    private TableColumn<Customer,String > Cus_email;
    @FXML
    private TableColumn<Customer,String > Cus_phone;
   
    @FXML
    private TableView<Customer> Customertable;

     static ObservableList<Customer> Cuslist=FXCollections.observableArrayList();
    @FXML
    private TableColumn<Customer,String> membershipType;
    @FXML
    private TableColumn<Customer,String> credit;
    
     @FXML
    private JFXButton cus_update;
    @FXML
    private JFXButton cus_dlt;
    @FXML
    private AnchorPane customertableFX;
     
     
     
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         Customertable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         
        try {
            Cuslist=getAllcustomer();
        } catch (SQLException ex) {
            Logger.getLogger(Show_CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Show_CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
          Cus_id.setCellValueFactory(new PropertyValueFactory<Customer,String>("CustomerID")); 
        Cus_name.setCellValueFactory(new PropertyValueFactory<Customer,String>("CustomerName"));
        cus_address.setCellValueFactory(new PropertyValueFactory<Customer,String>("CustomerAddress"));        
        Cus_email.setCellValueFactory(new PropertyValueFactory<Customer,String>("CustomerEmail"));
        
         Cus_phone.setCellValueFactory(new PropertyValueFactory<Customer,String>("CustomerPhoneNumber"));
         membershipType.setCellValueFactory(new PropertyValueFactory<Customer,String>("MembershipType"));
         credit.setCellValueFactory(new PropertyValueFactory<Customer,String>("Credit"));
        
       Customertable.setItems(Cuslist);
       
    }   
    
    
    public  ObservableList<Customer> getAllcustomer() throws SQLException, ClassNotFoundException{
       ObservableList<Customer> Clist=FXCollections.observableArrayList();
     DBconnection dbc =new DBconnection();
       dbc.connectToDB();
        String query="select*from Customer"; 
         dbc.queryToDB(query);
        ResultSet rs= dbc.queryToDB(query);
        

        while(rs.next()){
        String CusId =rs.getString("CustomerId");
        String CusName =rs.getString("CustomerName");  
        String CusAddress=rs.getString("CustomerAddress");
        String CusEmail=rs.getString("CustomerEmail");
        String CusPhone=rs.getString("CustomerPhone");
        String CusMembershipType=rs.getString("MembershipType");
        String CusCredit=rs.getString("CustomerCredit");
       
     
        Customer cus =new   Customer (CusId,CusName,CusAddress, CusEmail,CusPhone,CusMembershipType,CusCredit);
       Clist.add(cus);
         
        }
        
       return Clist; 
    
  
    
    } 
      public static Customer customer  = new Customer();

    @FXML
    private void cus_update(ActionEvent event) throws IOException {
   ObservableList<Customer> selectedemp=FXCollections.observableArrayList();
        selectedemp=Customertable.getSelectionModel().getSelectedItems();
         for (Customer dn : selectedemp) {
         customer.setCustomerID(dn.CustomerID);
         customer.setCustomerName(dn.CustomerName);
         customer.setCustomerPhoneNumber(dn.CustomerPhoneNumber);
         customer.setCustomerAddress(dn.CustomerAddress);
         customer.setCustomerEmail(dn.CustomerEmail);
         customer.setCredit(dn.Credit);
         customer.setMembershipType(dn.MembershipType);
          
        }
       
            Parent pane=FXMLLoader.load(getClass().getResource("UpdateCustomerInfo.fxml"));
            customertableFX.getChildren().setAll(pane);
     
                
    
    
    
    
    }

    @FXML
    private void cus_dlt(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        
        
         ObservableList<Customer> selectedCustomer=FXCollections.observableArrayList();
       selectedCustomer=Customertable.getSelectionModel().getSelectedItems();
      
          deleteCustomer(selectedCustomer);
     Cuslist .removeAll(selectedCustomer);
    }

    private void deleteCustomer(ObservableList<Customer> selectedCustomer) throws ClassNotFoundException, SQLException {
        DBconnection dbc =new DBconnection();
          dbc.connectToDB();
       
       
        for ( Customer cus:selectedCustomer) {
            String query = "DELETE FROM Customer WHERE CustomerId ='"+cus.CustomerID+"'";
            dbc.DeleteDataToDB(query);
            System.out.println(query);
        
        }
    }

   
    
}
