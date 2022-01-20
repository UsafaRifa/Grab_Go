/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author FUJITSU
 */
public class UpdateEmployeeInfoController implements Initializable {

    @FXML
    private TextField EmployeeFirstName;
    @FXML
    private TextField EmployeePhoneNumber;
    @FXML
    private TextField EmployeeLastName;
    @FXML
    private TextField EmployeeDesignation;
    @FXML
    private TextArea EmployeeAddress;
    @FXML
    private Button updatebtn;
    @FXML
    private Button reset;
    @FXML
    private AnchorPane UpdateEmpanc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Fname=ShowEmployeeController.empn.FirstName;
        String Lname=ShowEmployeeController.empn.LasttName;
        String phone=ShowEmployeeController.empn.PhoneNumber;
        String Des=ShowEmployeeController.empn.Degisnation;
        String Address=ShowEmployeeController.empn.Address;
          EmployeeFirstName.setText(Fname);
          EmployeeLastName.setText(Lname);
          EmployeePhoneNumber.setText(phone);
          EmployeeAddress.setText(Address);
          EmployeeDesignation.setText(Des);
         
    
       
        
    }    

    @FXML
    private void updateEmployeeInformation(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    String Fname=EmployeeFirstName.getText();
    String Lname=EmployeeLastName.getText();
    String phone=EmployeePhoneNumber.getText();
    String Des=EmployeeDesignation.getText();
    String Address=EmployeeAddress.getText();
    String id=ShowEmployeeController.empn.EmployeeID;
    
     if(Fname.equals("") && Lname.equals("") && Address.equals("")) return;
   
     
     Employee emp =new Employee(Fname,Lname,id,phone,Address,Des);
     updateEmployee(emp);
       System.out.println(emp);
        
        
        
        
          Parent pane=FXMLLoader.load(getClass().getResource("ShowEmployee.fxml"));
                UpdateEmpanc.getChildren().setAll(pane);
       
        
     
    }

    @FXML
    private void reset(ActionEvent event) {
   
    
    }
    
    private void updateEmployee(Employee emp) throws ClassNotFoundException, SQLException{
        int id=Integer.parseInt(emp.EmployeeID);
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
      String query = "UPDATE Employee SET FirstName='"+emp.FirstName+"', LastName='"+emp.LasttName+"', PhoneNumber='"+emp.PhoneNumber+"',EmpAddress='"+emp.Address+"',Designation='"+emp.Degisnation+"' WHERE EmployeeID="+id+"";
    
       System.out.println(query);
        //ResultSet dataInserted = dbc.queryToDB(query);
         boolean dataInserted = dbc.insertDataToDB(query);
        System.out.println("Updated?: "+dataInserted);

       // System.out.println("Inserted?: "+dataInserted);
       
    }
    
}
