/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import static grab.go.GrabAndGoController.EmployeeHbox;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class ShowEmployeeController implements Initializable {
    @FXML
    private TableView<Employee> EmployeeTable;
    @FXML
    private TableColumn<Employee, String> EmployeeIDCol;
    @FXML
    private TableColumn<Employee, String> Firstnamecol;
    @FXML
    private TableColumn<Employee, String> LastnameCol;
    @FXML
    private TableColumn<Employee, String> phoneNumberCol;
    @FXML
    private TableColumn<Employee, String> AddressCol;
    @FXML
    private TableColumn<Employee, String> designationCol;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button UpdateButton;
     static ObservableList<Employee> Emplist=FXCollections.observableArrayList();
    @FXML
    private AnchorPane tableanc;
    @FXML
    private TableColumn<Employee, LocalDate> dateofBirthCol;
    @FXML
    private TableColumn<Employee, LocalDate> DateofJoiningCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        EmployeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        try {
            Emplist=getAllEmployee();
        } catch (SQLException ex) {
            Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        EmployeeIDCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("EmployeeID")); 
        Firstnamecol.setCellValueFactory(new PropertyValueFactory<Employee,String>("FirstName"));
        LastnameCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("LasttName"));        
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("PhoneNumber"));
        dateofBirthCol.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("DateofBirth"));
        AddressCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("Address"));
        DateofJoiningCol.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("DateofJoining"));
        designationCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("Degisnation"));
        
        EmployeeTable.setItems(Emplist);
        

        
    }    
    public  ObservableList<Employee> getAllEmployee() throws SQLException, ClassNotFoundException{
         ObservableList<Employee> empList=FXCollections.observableArrayList();
     DBconnection dbc =new DBconnection();
       dbc.connectToDB();
        String query="select * from Employee"; 
         dbc.queryToDB(query);
        ResultSet rs= dbc.queryToDB(query);
        
        while(rs.next()){
        String EmpID=rs.getString("EmployeeID");
        String Fname=rs.getString("FirstName");
        String Lname=rs.getString("LastName");
        String phone=rs.getString("PhoneNumber");
        String address=rs.getString("EmpAddress");
        String designation=rs.getString("Designation");
        Date dob=rs.getDate("DateofBirth");
        Date doj=rs.getDate("DateofJoining");
        
      LocalDate ld_dob=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dob) );
      LocalDate ld_doj=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(doj) );
        
        Employee emp =new Employee(Fname,Lname,EmpID,phone,address,designation,ld_dob,ld_doj);
        empList.add(emp);
         
        }
        
       return empList; 
    
    
    
    } 
    public static Employee empn = new Employee();

    @FXML
    private void UpdateButtonOnAction(ActionEvent event) throws IOException {
    ObservableList<Employee> selectedemp=FXCollections.observableArrayList();
        selectedemp=EmployeeTable.getSelectionModel().getSelectedItems();
         for (Employee dn : selectedemp) {
          empn.setEmployeeID(dn.EmployeeID);
          empn.setFirstName(dn.FirstName);
          empn.setLasttName(dn.LasttName);
          empn.setPhoneNumber(dn.PhoneNumber);
          empn.setDateofBirth(dn.DateofBirth);
          empn.setAddress(dn.Address);
          empn.setDateofJoining(dn.DateofJoining);
          empn.setDegisnation(dn.Degisnation);
          
          
        }
       
            Parent pane=FXMLLoader.load(getClass().getResource("UpdateEmployeeInfo.fxml"));
            tableanc.getChildren().setAll(pane);
     
                
    
    }
    
      public  void deleteEmployee(ObservableList<Employee> selectedEmployee) throws SQLException, ClassNotFoundException {

         DBconnection dbc =new DBconnection();
          dbc.connectToDB();
       
        for (Employee Emp : selectedEmployee) {
            String query = "DELETE FROM Employee WHERE EmployeeID=" + Emp.EmployeeID + "";
           dbc.DeleteDataToDB(query);
       
        
        }
            
    }

    @FXML
    private void DeleteonAction(ActionEvent event) throws ClassNotFoundException, SQLException {
      ObservableList<Employee> selectedEmployee=FXCollections.observableArrayList();
        selectedEmployee=EmployeeTable.getSelectionModel().getSelectedItems();
      
          deleteEmployee(selectedEmployee);
        Emplist.removeAll(selectedEmployee);
    
    }
    
}
