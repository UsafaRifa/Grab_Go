/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static grab.go.Show_ProductController.productList;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Add_ProductStockController implements Initializable {

    @FXML
    private JFXTextField Stock_Product;
    @FXML
    private JFXTextField Product_Quantity;
    @FXML
    private JFXTextField Upcoming_Quantity;
    @FXML
    private JFXButton Save_ProductStock;
    @FXML
    private JFXButton ResetProductStock;
    @FXML
    private TableView<product> ProductTable;
    @FXML
    private TableColumn<product, String> ProductIdCol;
    @FXML
    private TableColumn<product, String> ProductName;
    @FXML
    private JFXTextField ProductStock_Id;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    } 

   
    
    
    
    
    @FXML
    private void Save_ProductStock(ActionEvent event) throws ClassNotFoundException, SQLException {
        
       /*  String  StockProduct=  Stock_Product.getText() ;
         String  ProductQuantity=  Product_Quantity.getText() ;  
         String UpcomingQuantity= Upcoming_Quantity.getText() ;
           
     
       Stock st=new Stock( StockProduct, ProductQuantity,UpcomingQuantity );
        System.out.println(st);
        insertProduct(st);
         */ 
         
    }

    @FXML
    private void ResetProductStock(ActionEvent event) {
    }

    private void insertProduct(Stock st) throws ClassNotFoundException, SQLException {
        
        
        
        /*
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Stock(Product_name,Product_Quantity,Product_Upcoming) values('" + st.ProductName + "','" + st.ProductQuantity+ "','" + st.ProductUpcomingQuantity+ "')";
        System.out.println(query);
        boolean dataInserted = dbc.insertDataToDB(query);
        if(dataInserted)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Stock Information  Added");
            alert.showAndWait();
        }
        */
         
    }
    
    
    
    
    
    
    
    

    }
    

/*



    @FXML
    private void Save_ProductStock(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        
         String  StockProduct=  Stock_Product.getText() ;
         String  ProductQuantity=  Product_Quantity.getText() ;  
         String UpcomingQuantity= Upcoming_Quantity.getText() ;
           
     
       Stock st=new Stock( StockProduct, ProductQuantity,UpcomingQuantity );
        System.out.println(st);
        insertProduct(st);
       
    }

    @FXML
    private void ResetProductStock(ActionEvent event) {
    }

    private void insertProduct(Stock st) throws ClassNotFoundException, SQLException {
         DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Stock(Product_name,Product_Quantity,Product_Upcoming) values('" + st.ProductName + "','" + st.ProductQuantity+ "','" + st.ProductUpcomingQuantity+ "')";
        System.out.println(query);
        boolean dataInserted = dbc.insertDataToDB(query);
        if(dataInserted)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Stock Information  Added");
            alert.showAndWait();
        }
    }

  


*/