/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    private AnchorPane UpdateEmpanc;
    @FXML
    private DatePicker dob;
    @FXML
    private JFXTextField emp_id;
    @FXML
    private TextField doj;
    LocalDate dateofJoining;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String employee_id=ShowEmployeeController.empn.EmployeeID;
        String Fname=ShowEmployeeController.empn.FirstName;
        String Lname=ShowEmployeeController.empn.LasttName;
        String phone=ShowEmployeeController.empn.PhoneNumber;
        LocalDate dateofBirth=ShowEmployeeController.empn.DateofBirth;
        dateofJoining=ShowEmployeeController.empn.DateofJoining;
        String Des=ShowEmployeeController.empn.Degisnation;
        String Address=ShowEmployeeController.empn.Address;
          emp_id.setText(employee_id);
          EmployeeFirstName.setText(Fname);
          EmployeeLastName.setText(Lname);
          EmployeePhoneNumber.setText(phone);
          dob.setValue(dateofBirth);
          EmployeeAddress.setText(Address);
          doj.setText(dateofJoining.toString());
          EmployeeDesignation.setText(Des);
         
    
       
        
    }    

    @FXML
    private void updateEmployeeInformation(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    String Fname=EmployeeFirstName.getText();
    String Lname=EmployeeLastName.getText();
    String phone=EmployeePhoneNumber.getText();
    String Des=EmployeeDesignation.getText();
    String Address=EmployeeAddress.getText();
    LocalDate dateofBirth= dob.getValue();
    
    String id=ShowEmployeeController.empn.EmployeeID;
    
     if(Fname.equals("") && Lname.equals("") && Address.equals("")) return;
   
     
     Employee emp =new Employee(Fname,Lname,id,phone,Address,Des,dateofBirth,dateofJoining);
     updateEmployee(emp);
       System.out.println(emp);
        
        
        
        
          Parent pane=FXMLLoader.load(getClass().getResource("ShowEmployee.fxml"));
                UpdateEmpanc.getChildren().setAll(pane);
       
        
     
    }

    
    private void updateEmployee(Employee emp) throws ClassNotFoundException, SQLException{
        int id=Integer.parseInt(emp.EmployeeID);
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
      String query = "UPDATE Employee SET FirstName='"+emp.FirstName+"', LastName='"+emp.LasttName+"', PhoneNumber='"+emp.PhoneNumber+"',DateofBirth='"+emp.DateofBirth+"',EmpAddress='"+emp.Address+"',Designation='"+emp.Degisnation+"' WHERE EmployeeID="+id+"";
    
       System.out.println(query);
        //ResultSet dataInserted = dbc.queryToDB(query);
         boolean dataInserted = dbc.insertDataToDB(query);
        System.out.println("Updated?: "+dataInserted);

       // System.out.println("Inserted?: "+dataInserted);
       
    }
    
}
