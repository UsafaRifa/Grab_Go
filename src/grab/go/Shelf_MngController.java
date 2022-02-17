/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static grab.go.ShowEmployeeController.empn;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author FUJITSU
 */
public class Shelf_MngController implements Initializable {

    @FXML
    private TableView<ShelfManage> Shelf_mngTable;
    @FXML
    private TableColumn<ShelfManage, String> Shelf_productID;
    @FXML
    private TableColumn<ShelfManage, String> Shelf_productName;
    @FXML
    private TableColumn<ShelfManage, String> Shelf_blockNum;
    @FXML
    private TableColumn<ShelfManage, String> Shelf_shelfNum;
    @FXML
    private TableColumn<ShelfManage, Integer> Shelf_row;
    @FXML
    private TableColumn<ShelfManage, Integer> Shelf_col;
    @FXML
    private TableColumn<ShelfManage, Integer> Shelf_productQty;
    @FXML
    private TableColumn<ShelfManage, String> Shelf_stockCon;
    @FXML
    private TableColumn<ShelfManage, String> Shelf_addSts;
    
    static ObservableList<ShelfManage> Shelf_productMngList=FXCollections.observableArrayList();
    @FXML
    private AnchorPane tableAnc;
    @FXML
    private JFXComboBox<String> search_key;
    ObservableList<String> allKey = FXCollections.observableArrayList(
                  "ProductID","ProductName","Block","Stock_condition","Add_status"
        );
    @FXML
    private JFXTextField search_txtField;
    @FXML
    private JFXTextField shelf_selection;
    @FXML
    private JFXComboBox<Integer> row_selection;
    @FXML
    private JFXComboBox<Integer> col_selection;
    @FXML
    private JFXComboBox<String> select_block;
    ObservableList<String> BlockAll = FXCollections.observableArrayList(
                  "Block A","Block B","Block C","Block D","Block E"
        );

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        search_key.setItems(allKey);
        search_key.setValue("ProductID");
        select_block.setItems(BlockAll);
        
        search_txtField.setVisible(true);
          shelf_selection.setVisible(false);
          row_selection.setVisible(false);
          col_selection.setVisible(false);
        select_block.setVisible(false);
        
        Shelf_mngTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        try {
            Shelf_productMngList=getAllShelfProduct();
        } catch (SQLException ex) {
            Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Shelf_productID.setCellValueFactory(new PropertyValueFactory<ShelfManage, String>("Product_Id"));
        Shelf_productName.setCellValueFactory(new PropertyValueFactory<ShelfManage, String>("Product_Name"));
        Shelf_blockNum.setCellValueFactory(new PropertyValueFactory<ShelfManage, String>("Block_no"));
        Shelf_shelfNum.setCellValueFactory(new PropertyValueFactory<ShelfManage, String>("Shelf_no"));
        Shelf_row.setCellValueFactory(new PropertyValueFactory<ShelfManage, Integer>("Shelf_row"));
        Shelf_col.setCellValueFactory(new PropertyValueFactory<ShelfManage, Integer>("Shelf_col"));
        Shelf_productQty.setCellValueFactory(new PropertyValueFactory<ShelfManage, Integer>("OnShelf_quantity"));
        Shelf_stockCon.setCellValueFactory(new PropertyValueFactory<ShelfManage, String>("Stock_Con"));
        Shelf_addSts.setCellValueFactory(new PropertyValueFactory<ShelfManage, String>("Add_sts"));
        
        Shelf_mngTable.setItems(Shelf_productMngList);
    } 
    
    public  ObservableList<ShelfManage> getAllShelfProduct() throws SQLException, ClassNotFoundException{
         ObservableList<ShelfManage> ShelfProductList=FXCollections.observableArrayList();
         DBconnection dbc =new DBconnection();
         dbc.connectToDB();
         String query= "SELECT  Products.ProductID,ProductName,ShelfNo,Block_shelfNo,Shelf_row,Shelf_col,OnShelf_qty,Stock_condition,Add_status FROM Products LEFT JOIN Shelf on Products.ProductID=Shelf.ProductID"; 
         dbc.queryToDB(query);
         ResultSet rs= dbc.queryToDB(query);
        
        while(rs.next()){
        String ProductID=rs.getString("ProductID");
        String ProductName=rs.getString("ProductName");
        String Block_no=rs.getString("ShelfNo");
        String Block_Shelfno=rs.getString("Block_ShelfNo");
        int row_no=rs.getInt("Shelf_row");
        int col_no=rs.getInt("Shelf_col");
        int OnShelf_ProQty=rs.getInt("OnShelf_qty");
        String Stock_con=rs.getString("Stock_condition");
        String Add_sts= rs.getString("Add_status");
        ShelfManage sm =new ShelfManage(ProductID,ProductName,Block_no,Block_Shelfno,row_no,col_no,OnShelf_ProQty,Stock_con,Add_sts);
        ShelfProductList.add(sm);
         
        }
        return ShelfProductList;
    }
    

    @FXML
    private void AddQtyOnAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        
        ObservableList<ShelfManage> selectedItem=FXCollections.observableArrayList();
        selectedItem=Shelf_mngTable.getSelectionModel().getSelectedItems();
         for (ShelfManage shelf_mng : selectedItem) {
          sm.setProduct_Id(shelf_mng.Product_Id);
          sm.setProduct_Name(shelf_mng.Product_Name);
          sm.setBlock_no(shelf_mng.Block_no);
          sm.setShelf_no(shelf_mng.Shelf_no);
          sm.setShelf_row(shelf_mng.Shelf_row);
          sm.setShelf_col(shelf_mng.Shelf_col);
          sm.setOnShelf_quantity(shelf_mng.OnShelf_quantity);
          sm.setStock_Con(shelf_mng.Stock_Con);
          sm.setAdd_sts(shelf_mng.Add_sts);
        }
        
        
         TextInputDialog ti=new TextInputDialog(); 
          ti.setTitle("Add Quantity");
          ti.getDialogPane().setContentText("New Added Amount(Total quantity must be less then 100): ");
          Optional<String> res=ti.showAndWait();
          TextField in=ti.getEditor();
         if(!(in.getText().isEmpty()))
         {
             int qty= Integer.parseInt(in.getText());
             int overflowCheck= qty+sm.getOnShelf_quantity();
             if(overflowCheck <=100){
                 String que="UPDATE Shelf SET Add_status='"+in.getText().toString()+",Pending' WHERE ProductID='"+sm.getProduct_Id()+"'";
                        System.out.println(que); 
                        DBconnection dbc = new DBconnection();
                         dbc.connectToDB();
                         boolean dataIn = dbc.insertDataToDB(que);
                         if(dataIn){
                             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                             alert.setTitle("Successful");
                            alert.setHeaderText("Updated");
                            alert.showAndWait();
                            
                            Parent pane = FXMLLoader.load(getClass().getResource("Shelf_Mng.fxml"));
                             tableAnc.getChildren().setAll(pane);
                         }
             }else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Excess to store");
                    alert.showAndWait();
             }
             
         }
                  
                    
    }
    
    public static ShelfManage sm= new ShelfManage();
    @FXML
    private void updateProductOnAction(ActionEvent event) {
        
        
        ObservableList<ShelfManage> selectedItem=FXCollections.observableArrayList();
        selectedItem=Shelf_mngTable.getSelectionModel().getSelectedItems();
         for (ShelfManage shelf_mng : selectedItem) {
          sm.setProduct_Id(shelf_mng.Product_Id);
          sm.setProduct_Name(shelf_mng.Product_Name);
          sm.setBlock_no(shelf_mng.Block_no);
          sm.setShelf_no(shelf_mng.Shelf_no);
          sm.setShelf_row(shelf_mng.Shelf_row);
          sm.setShelf_col(shelf_mng.Shelf_col);
          sm.setOnShelf_quantity(shelf_mng.OnShelf_quantity);
          sm.setStock_Con(shelf_mng.Stock_Con);
          sm.setAdd_sts(shelf_mng.Add_sts);
        }
       
      Parent pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("Update_Product.fxml"));
            tableAnc.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Shelf_MngController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
     
    }

    private void updateItemInfo(ObservableList<ShelfManage> selectedItem) {
        
        
    }

    @FXML
    private void searchBtnOnAction(MouseEvent event) throws ClassNotFoundException, SQLException {
        
        String key=search_key.getValue().toString();
        String txt=search_txtField.getText();
        String que;
        if(key.equals("ProductID") || key.equals("ProductName")){
            que="SELECT  Products.ProductID,ProductName,ShelfNo,Block_shelfNo,Shelf_row,Shelf_col,OnShelf_qty,Stock_condition,Add_status FROM Products " +
              "LEFT JOIN Shelf on Products.ProductID=Shelf.ProductID " +"where (Products."+key+" LIKE '%"+txt+"%')";
        }else {
            que="SELECT  Products.ProductID,ProductName,ShelfNo,Block_shelfNo,Shelf_row,Shelf_col,OnShelf_qty,Stock_condition,Add_status FROM Products LEFT JOIN Shelf on Products.ProductID=Shelf.ProductID where ("+key+" LIKE '%"+txt+"%')";
        }
        
        ObservableList<ShelfManage> selectedShelfItem = FXCollections.observableArrayList();
        selectedShelfItem = SearchInShelf(que);
        Shelf_mngTable.setItems(selectedShelfItem);
       
        
        
        
        
        
        
        
        
        
       /* if(key.equals("Block")){
            System.out.println("point");
            String blk=select_block.getValue().toString();
            String shlf=shelf_selection.getText();
            int r=Integer.parseInt(row_selection.getValue().toString());
            int c=Integer.parseInt(col_selection.getValue().toString());
            System.out.println(r);
            if(!(blk.isEmpty()) && !(shlf.isEmpty()) && !(row_selection.getValue().toString().isEmpty()) && !(col_selection.getValue().toString().isEmpty())){
                String que="SELECT  Products.ProductID,ProductName,ShelfNo,Block_shelfNo,Shelf_row,Shelf_col,OnShelf_qty,Stock_condition,Add_status FROM Products "
                    + "LEFT JOIN Shelf on Products.ProductID=Shelf.ProductID"
                    + "where (ShelfNo='"+blk+"' AND Block_shelfNo='"+shlf+"'AND Shelf_row="+r+" AND Shelf_col="+c+")";
            }
            if(!(blk.isEmpty()) && !(shlf.isEmpty()) && (row_selection.getValue().toString().isEmpty()) && (col_selection.getValue().toString().isEmpty())){
                String que="SELECT  Products.ProductID,ProductName,ShelfNo,Block_shelfNo,Shelf_row,Shelf_col,OnShelf_qty,Stock_condition,Add_status FROM Products "
                    + "LEFT JOIN Shelf on Products.ProductID=Shelf.ProductID"
                    + "where (ShelfNo='"+blk+"' AND Block_shelfNo='"+shlf+"')";
            }
            if(!(blk.isEmpty()) && (shlf.isEmpty()) && (row_selection.getValue().toString().isEmpty()) && (col_selection.getValue().toString().isEmpty())){
                String que="SELECT  Products.ProductID,ProductName,ShelfNo,Block_shelfNo,Shelf_row,Shelf_col,OnShelf_qty,Stock_condition,Add_status FROM Products " +
"              LEFT JOIN Shelf on Products.ProductID=Shelf.ProductID" +
"                  where (ShelfNo='"+blk+"'))";
                System.out.println(que);
            }
        }
        */
        
    }
    
    ObservableList<ShelfManage> SearchInShelf(String que) throws SQLException, ClassNotFoundException {
        ObservableList<ShelfManage> Productlist = FXCollections.observableArrayList();
        DBconnection dbc = new DBconnection();
        dbc.connectToDB();
        System.out.println(que);
        ResultSet rs = dbc.queryToDB(que);
        while (rs.next()) {
            String Product_Id = rs.getString("ProductID");
            String Product_Name = rs.getString("ProductName");
            String Block_no = rs.getString("ShelfNo");
            String Shelf_no= rs.getString("Block_shelfNo");
            int Shelf_r = rs.getInt("Shelf_row");
            int Shelf_c = rs.getInt("Shelf_col");
            int OnShelf_quantity = rs.getInt("OnShelf_qty");
            String Stock_Con = rs.getString("Stock_condition");
            String Add_sts = rs.getString("Add_status");

            ShelfManage shM = new ShelfManage(Product_Id, Product_Name, Block_no, Shelf_no,Shelf_r,Shelf_c,OnShelf_quantity,Stock_Con,Add_sts);
            Productlist.add(shM);

        }

        return Productlist;
    }

    @FXML
    private void keySelectOnAction(MouseEvent event) {
        String key=search_key.getValue().toString();
        //String txt=search_txtField.getText();
        if(key.equals("Block")){
          search_txtField.setVisible(false);
          shelf_selection.setVisible(true);
          row_selection.setVisible(true);
          col_selection.setVisible(true);
          select_block.setVisible(true);
        }
        else{
          search_txtField.setVisible(true);
          shelf_selection.setVisible(false);
          row_selection.setVisible(false);
          col_selection.setVisible(false);
          select_block.setVisible(false);
        }
    }
}
    
