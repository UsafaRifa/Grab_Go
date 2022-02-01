/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class AddEmployeeController implements Initializable {

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
    private Button savebtn;
    @FXML
    private Button reset;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveEmployeeInformation(ActionEvent event) throws ClassNotFoundException, SQLException  {
    String Fname=EmployeeFirstName.getText();
    String Lname=EmployeeLastName.getText();
    String phone=EmployeePhoneNumber.getText();
    String Des=EmployeeDesignation.getText();
    String Address=EmployeeAddress.getText();
    
    
     if(Fname.equals("") && Lname.equals("") && Address.equals("")) return;
   
     
     Employee emp =new Employee(Fname,Lname,phone,Address,Des);
     insertEmployee(emp);
       System.out.println(emp);
    
    }

    private void insertEmployee(Employee emp)throws ClassNotFoundException, SQLException{
        
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Employee(FirstName, LastName,PhoneNumber,EmpAddress,Designation) values('"+emp.FirstName+"','"+emp.LasttName+"','"+emp.PhoneNumber+"','"+emp.Address+"','"+emp.Degisnation+"')";
        System.out.println(query);
        boolean dataInserted = dbc.insertDataToDB(query);
        System.out.println("Inserted?: "+dataInserted);
    }

    @FXML
    private void reset(ActionEvent event) {
    }
}
