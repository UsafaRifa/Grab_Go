
package grab.go;

import DatabaseConnection.DBconnection;

import Exceptions.NullValueException;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class AddEmployeeController implements Initializable {

    @FXML
    private Button savebtn;
    @FXML
    private JFXDatePicker Bdate;
    @FXML
    private Button reset;
    @FXML
    private JFXTextField EmployeeFirstName;
    @FXML
    private JFXTextField EmployeePhoneNumber;
    @FXML
    private JFXTextArea EmployeeAddress;
    @FXML
    private JFXTextField EmployeeDesignation;
    @FXML
    private JFXTextField EmployeeLastName;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         NumberValidator numValidator=new NumberValidator();
        EmployeePhoneNumber.getValidators().add(numValidator);
        numValidator.setMessage("add only 11 digits of your phone number");
        EmployeePhoneNumber.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if(!t1){
                    EmployeePhoneNumber.validate();
                    
                }else{
                    EmployeePhoneNumber.setText("");
                }   
            }
       });
        
       RegexValidator validate = new RegexValidator();
       validate.setRegexPattern("[A-Za-z\\s]+");
       EmployeeFirstName.setValidators(validate);
       EmployeeFirstName.getValidators().get(0).setMessage("Name Should be contain only Alphabets");
       EmployeeLastName.setValidators(validate);
       EmployeeLastName.getValidators().get(0).setMessage("Name Should be contain only Alphabets");
       EmployeeFirstName.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if(!t1){
                    EmployeeFirstName.validate();
                }  
            }
       });
       
        EmployeeLastName.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if(!t1){
                    EmployeeLastName.validate();
                }  
            }
       });
    }

    @FXML
    private void reset() {
        EmployeeFirstName.setText("");
        EmployeePhoneNumber.setText("");
        EmployeeLastName.setText("");
        EmployeeDesignation.setText("");
        EmployeeAddress.setText("");
        Bdate.setValue(null);
    }
    public static boolean isNumeric(String str) { 
        try {  
                Double.parseDouble(str);  
                return true;
        } catch(NumberFormatException e){  
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Number is not valid");
            alert.setContentText(null);
            alert.showAndWait();
            return false;
        }  
    }

    private boolean validatePnum(){
       if(EmployeePhoneNumber.getText().length()== 11)
        return true;
       else
         return false;
    }
    private boolean validateFields() {
        try {
            if (EmployeeFirstName.getText().isEmpty() || EmployeeLastName.getText().isEmpty() || EmployeePhoneNumber.getText().isEmpty() || EmployeeDesignation.getText().isEmpty()
                    || EmployeeAddress.getText().isEmpty() || Bdate.getEditor().getText().isEmpty()) {

                //Alert Message
                throw new NullValueException("Information Missing!!!", "Please provide all the informations properly.");
            }
        } catch (NullValueException e) {
            return false;
        }
        return true;
    }


    @FXML
    private void saveEmployeeInformation(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (validateFields() && isNumeric(EmployeePhoneNumber.getText()) && validatePnum() ) {
            String Fname = EmployeeFirstName.getText();
            String Lname = EmployeeLastName.getText();
            String phone = EmployeePhoneNumber.getText();
            String Des = EmployeeDesignation.getText();
            String Address = EmployeeAddress.getText();
            LocalDate dob = Bdate.getValue();
            LocalDate doJoining= LocalDate.now();

            Employee emp = new Employee(Fname, Lname, phone, Address, Des, dob, doJoining);
            insertEmployee(emp);
            System.out.println(emp);
            reset();

        }
    }

    private void insertEmployee(Employee emp) throws ClassNotFoundException, SQLException {
      
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Employee(FirstName, LastName,PhoneNumber,DateofBirth,EmpAddress,DateofJoining,Designation) values('" + emp.FirstName + "','" + emp.LasttName + "','" + emp.PhoneNumber + "','" + emp.DateofBirth + "','" + emp.Address + "','" + emp.DateofJoining + "','" + emp.Degisnation + "')";
        System.out.println(query);
        boolean dataInserted = dbc.insertDataToDB(query);
        if(dataInserted)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Employee Added");
            alert.showAndWait();
        }
    }
}
