/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import static grab.go.ShowEmployeeController.Emplist;
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


public class Show_ProductController implements Initializable {

    @FXML
    private TableColumn<product, String> ProductIdCol;
    @FXML
    private TableColumn<product, String> ProductName;
    @FXML
    private TableColumn<product, String>AvailableStocks;
    @FXML
    private TableColumn<product, String>ShelfNo;
    @FXML
    private TableColumn<product, LocalDate> MFGDate;
    @FXML
    private TableColumn<product, LocalDate> ExpireDate;
    @FXML
    private TableColumn<product, String> UnitPrice;
    @FXML
    private TableView<product> ProductTable;
    
     static ObservableList<product> productList=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProductTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        try {
            productList=getAllProduct();
            
            
// TODO
        } catch (SQLException ex) {
            Logger.getLogger(Show_ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Show_ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        ProductIdCol.setCellValueFactory(new PropertyValueFactory<product, String>("Product_Id")); 
        ProductName.setCellValueFactory(new PropertyValueFactory<product, String>("Product_Name"));
        AvailableStocks.setCellValueFactory(new PropertyValueFactory<product, String>("Available_Stock"));        
        ShelfNo.setCellValueFactory(new PropertyValueFactory<product, String>("Shelf_no"));
        MFGDate.setCellValueFactory(new PropertyValueFactory<product, LocalDate>("MFG_Date"));
        ExpireDate.setCellValueFactory(new PropertyValueFactory<product, LocalDate>("Exp_Date"));
        UnitPrice.setCellValueFactory(new PropertyValueFactory<product, String>("Unit_Price"));
        
       ProductTable.setItems(productList);
    
    
    }    
    public  ObservableList<product> getAllProduct() throws SQLException, ClassNotFoundException{
       ObservableList<product> pdList=FXCollections.observableArrayList();
     DBconnection dbc =new DBconnection();
       dbc.connectToDB();
        String query="select * from Products"; 
         dbc.queryToDB(query);
        ResultSet rs= dbc.queryToDB(query);
        
        while(rs.next()){
        String ProductID=rs.getString("ProductID");
        String ProductName=rs.getString("ProductName");
        String ShelfNo=rs.getString("ShelfNo");
        String UnitPrice=rs.getString("UnitPrice");
        String Stock=rs.getString("Stock");
        Date MFG=rs.getDate("MFG");
        Date Expire=rs.getDate("Expire");
        
      LocalDate ld_MFG=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(MFG) );
      LocalDate ld_Expire=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(Expire) );
        
        product pd =new product(ProductID,ProductName,ShelfNo,ld_MFG,ld_Expire,UnitPrice,Stock);
        pdList.add(pd);
         
        }
        
       return pdList; 
    
  
    
    } 
     public  void deleteProduct(ObservableList<product> selectedProduct) throws SQLException, ClassNotFoundException {

         DBconnection dbc =new DBconnection();
          dbc.connectToDB();
       
        for (product pd : selectedProduct) {
            String query = "DELETE FROM Products WHERE ProductID='"+pd.Product_Id+"'";
            dbc.DeleteDataToDB(query);
            System.out.println(query);
        
        }
            
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
   
     ObservableList<product> selectedProduct=FXCollections.observableArrayList();
        selectedProduct=ProductTable.getSelectionModel().getSelectedItems();
      
          deleteProduct(selectedProduct);
        productList.removeAll(selectedProduct);
    
    }
    
}
