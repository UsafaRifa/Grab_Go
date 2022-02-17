/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Show_ProductStockController implements Initializable {

    @FXML
    private TableColumn<Stock, String> Stock_ProductName;
    @FXML
    private TableColumn<Stock, String> StockProduct_Quantity;
    @FXML
    private TableColumn<Stock, String> Stock_Upcoming;
    @FXML
    private JFXButton StockUpdate;
    @FXML
    private JFXButton StockDelete;
    @FXML
    private TableView<Stock> Stock_Table;
    
    static ObservableList<Stock> StockList=FXCollections.observableArrayList();
    @FXML
    private TableColumn<Stock, String> Product_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Stock_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        try {
           StockList=getAllStock();
            
            
// TODO
        } catch (SQLException ex) {
            Logger.getLogger(Show_ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Show_ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
      Product_id.setCellValueFactory(new PropertyValueFactory<Stock, String>("ProductID")); 
        Stock_ProductName.setCellValueFactory(new PropertyValueFactory<Stock, String>("ProductName")); 
         
        StockProduct_Quantity.setCellValueFactory(new PropertyValueFactory<Stock, String>("ProductQuantity"));
         Stock_Upcoming.setCellValueFactory(new PropertyValueFactory<Stock, String>("ProductUpcomingQuantity"));
      
        
    Stock_Table.setItems(StockList);
    
        
        // TODO
    }    

    @FXML
    private void StockUpdate(ActionEvent event) {
        
        
    }

    @FXML
    private void StockDelete(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        ObservableList<Stock> selectedStock=FXCollections.observableArrayList();
        selectedStock=Stock_Table.getSelectionModel().getSelectedItems();
      
          deleteStock(selectedStock);
       StockList.removeAll(selectedStock);
    }

    private ObservableList<Stock> getAllStock() throws SQLException, ClassNotFoundException {
          ObservableList<Stock> stList=FXCollections.observableArrayList();
     DBconnection dbc =new DBconnection();
       dbc.connectToDB();
        String query="select * from Stock"; 
         dbc.queryToDB(query);
        ResultSet rs= dbc.queryToDB(query);
        
        while(rs.next()){

            
           String  Product_Id=rs.getString("Product_Id");  
        String Product_name=rs.getString("Product_name");
         String Product_Quantity=rs.getString("Product_Quantity");
         String Product_Upcoming=rs.getString("Product_Upcoming");
        
        
       
      
     
        
        Stock st =new  Stock (Product_Id,Product_name,Product_Quantity, Product_Upcoming);
        stList.add(st);
         
        }
        
       return stList; 
    
    }

    private void deleteStock(ObservableList<Stock> selectedProduct) throws ClassNotFoundException, SQLException {
       
          DBconnection dbc =new DBconnection();
          dbc.connectToDB();
       
        for (Stock st : selectedProduct) {
            String query = "DELETE FROM Stock WHERE  Product_Id ='"+st.ProductID+"'";
            dbc.DeleteDataToDB(query);
            System.out.println(query);
        
        }
    }
    
}
