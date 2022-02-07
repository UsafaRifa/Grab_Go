/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddProductController implements Initializable {

    @FXML
    private JFXTextField Pro_id;
    @FXML
    private JFXTextField Pro_name;
    @FXML
    private JFXComboBox<String> Shelf_No;
          ObservableList<String> ShelfAll = FXCollections.observableArrayList(
                  "Block A",
                  "Block B",
                  "Block C"
        );
    @FXML
    private JFXDatePicker MFG;
    @FXML
    private JFXDatePicker Expire;
    @FXML
    private JFXTextField Price;
    @FXML
    private JFXCheckBox Ava_Stock;
    @FXML
    private Button Save_pro;
    @FXML
    private Button Reset_Pro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Shelf_No.setItems(ShelfAll);
        // TODO
    }    

    @FXML
    private void Save_pro(ActionEvent event) throws ClassNotFoundException, SQLException {
        
       String productId= Pro_id.getText() ;
         String productName= Pro_name.getText() ; 
           String productPrice= Price.getText() ;  
           
             LocalDate mfg =  MFG.getValue();
            LocalDate exp = Expire.getValue();
            String shelf=Shelf_No.getValue();
            String stock=Ava_Stock.getText();
            System.out.println(stock);
            
     
       product pd=new product( productId,productName,shelf, mfg,exp,productPrice,stock );
        System.out.println(pd);
        insertProduct(pd);
       
        
    }
    
    private void insertProduct(product pd) throws ClassNotFoundException, SQLException {
      
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        String query = "insert into Products(ProductID, ProductName,ShelfNo,MFG,Expire,UnitPrice,Stock) values('" + pd.Product_Id + "','" + pd.Product_Name+ "','" + pd.Shelf_no + "','" + pd.MFG_Date + "','" + pd.Exp_Date + "','" + pd.Unit_Price+ "','" + pd.Available_Stock + "')";
        System.out.println(query);
        boolean dataInserted = dbc.insertDataToDB(query);
        if(dataInserted)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Product Added");
            alert.showAndWait();
        }
    }
    

    @FXML
    private void Reset_Pro(ActionEvent event) {
    }
    
}

/* ProductID int ,
	ProductName  varchar(50),
	ShelfNo varchar(50),
	MFG Date,
	Expire DATE,
	UnitPrice float(24),
	Stock varchar(100)*/