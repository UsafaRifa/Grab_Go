/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import DatabaseConnection.DBconnection;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static grab.go.QrCodeReadController.readQRCode;
import static grab.go.Show_ProductController.productList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class BillgenaratePageController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private JFXTextField ProductIDbill;
    @FXML
    private TableView<Bill> Billtable;
    @FXML
    private TableColumn<Bill, String> BillProductID;
    @FXML
    private TableColumn<Bill, String> BillProductName;
    @FXML
    private TableColumn<Bill, String> BillUnitPrice;
    @FXML
    private TableColumn<Bill, String> BillQuantity;
    @FXML
    private TableColumn<Bill, String> BillsubTotal;
     @FXML
    private TableColumn<Bill, String> ProductVat;
    @FXML
    private TableColumn<Bill, String> productTotal;
    @FXML
    private JFXTextField ProductName;
    @FXML
    private JFXTextField UnitPrice;
    @FXML
    private JFXTextField Quantity;
    @FXML
    private Button DeleteButton;
    @FXML
    private JFXTextField TotalBill;
   int c;
    final FileChooser fc =new FileChooser();
  ObservableList<Bill> productList=FXCollections.observableArrayList();
     public  static String pID;
    @FXML
    private AnchorPane BillPage;
    @FXML
    private JFXTextField CustoID;
    @FXML
    private JFXTextField cusname;
    @FXML
    private JFXTextField CustomerPhone;
       @FXML
    private JFXTextField invoiceNo;
    @FXML
    private JFXDatePicker invoiceDate;
 @FXML
    private JFXTextField cusmember;
    @FXML
    private JFXTextArea billArea;
    @FXML
    private Button a;
    TextArea text = new TextArea();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          text.setPrefRowCount(100);
        text.setPrefColumnCount(20);
        invoiceDate.setValue(LocalDate.now());
        BillProductID.setCellValueFactory(new PropertyValueFactory<Bill,String>("ProductID")); 
        BillProductName.setCellValueFactory(new PropertyValueFactory<Bill,String>("Product_Name"));
        BillQuantity.setCellValueFactory(new PropertyValueFactory<Bill,String>("ProductQuantity"));        
        BillsubTotal.setCellValueFactory(new PropertyValueFactory<Bill,String>("ProductSubTotal"));
        ProductVat.setCellValueFactory(new PropertyValueFactory<Bill,String>("ProductVat"));
        productTotal.setCellValueFactory(new PropertyValueFactory<Bill,String>("ProductTotal"));
        BillUnitPrice.setCellValueFactory(new PropertyValueFactory<Bill, String>("ProductUnitprice"));
    
        Billtable.setItems(productList);
       
    }



    @FXML
    private void back(ActionEvent event) throws IOException {
      Parent pane=FXMLLoader.load(getClass().getResource("ReceptionistHomePage.fxml"));
                 BillPage.getChildren().setAll(pane);
    
    }
   private void print(Node node) {
    System.out.println("Creating a printer job...");

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
      System.out.println(job.jobStatusProperty().asString());

      boolean printed = job.printPage(node);
      if (printed) {
        job.endJob();
      } else {
        System.out.println("Printing failed.");
      }
    } else {
      System.out.println("Could not create a printer job.");
    }
  }
    public void setArea()
    {   text.setText("=======================================================\n");
        text.setText(text.getText()+"         \t\t\t\t     Welcome To Grab and Go                 \n"
                + "Invoice No:"+invoiceNo.getText()+" \t\t\t\t\t\t\t\t\t\t  Date: "+invoiceDate.getValue()+"\n");
        text.setText(text.getText()+"*******************************************************\n");
        int c=1;
        for (Bill bl : productList) { text.setText(text.getText()+"\n Item No:"+c+" \n productID: "+bl.ProductID+"\n");
             text.setText(text.getText()+"*******************************************************\n");
        c++;
        
        }
       
        
       
    
    
    }
    public void TotalBill()
    {
    Double Totalbill = 0.00 ;
    for (Bill pd : productList) {
          

        Totalbill=Totalbill+Double.parseDouble(pd.ProductTotal) ;
        System.out.println(Totalbill);
    }
    
    Double Total=Totalbill;      
    String  ProductTotal=Total.toString();
    TotalBill.setText(ProductTotal);
    }

    @FXML
    private void AddProducttable(ActionEvent event) {
    
    String  ProductID=ProductIDbill.getText();
    String  Productname=ProductName.getText();
    String  ProductUnitprice=UnitPrice.getText();
    String  ProductQuantity=Quantity.getText();
    Double sub=(Double.parseDouble(ProductUnitprice)* Double.parseDouble(ProductQuantity));
    String  ProductSubTotal=sub.toString();
    Double vat=((sub*7.5)/100);
    String  Productvat=vat.toString();
    Double Total=sub+vat;      
    String  ProductTotal=Total.toString();

    
    Bill bl=new Bill(ProductID,Productname,ProductUnitprice,ProductQuantity,ProductSubTotal,Productvat,ProductTotal);
    productList.add(bl);
    Billtable.setItems(productList);
    TotalBill();
    ProductIDbill.clear();
    ProductName.clear();
    Quantity.clear();
    }
   
    static Stage stage = new Stage();
    @FXML
    private void QrcodeRead(ActionEvent event) throws IOException, FileNotFoundException, NotFoundException, SQLException, ClassNotFoundException {
   fc.setTitle("my File Chooser");
        // the selected file 
        File file=fc.showOpenDialog(null);
        
        String pathqr=file.getAbsolutePath();
        read(pathqr);
           product pd=new product();
           
           pd=addBillProduct(ProductIDbill.getText());
           UnitPrice.setText(pd.Unit_Price);
          ProductName.setText(pd.Product_Name);
     


    
    }
    
    
        public void read(String pa) throws IOException, FileNotFoundException, NotFoundException{
    
    String filePath = pa;
                String charset = "UTF-8";
                Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
                hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                System.out.println("Data read from QR Code: " + readQRCode(filePath, charset, hintMap));
                ProductIDbill.setText(readQRCode(filePath, charset, hintMap));
            
    
    }
          public static String readQRCode(String filePath, String charset, Map hintMap)
    throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
            new BufferedImageLuminanceSource(
                ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
        return qrCodeResult.getText();
    }
  
    product addBillProduct(String value) throws SQLException, ClassNotFoundException {
        String ProductName="";
        String UnitPrice="";
         DBconnection dbc =new DBconnection();
          dbc.connectToDB();
        String query = "SELECT ProductName,UnitPrice FROM Products  WHERE ProductID='"+ value + "'";
         dbc.queryToDB(query);
        ResultSet rs= dbc.queryToDB(query);
        while (rs.next()) {
             ProductName = rs.getString("ProductName");
             UnitPrice = rs.getString("UnitPrice");
           
        }
        product pd = new product(value,ProductName,UnitPrice);
        return pd;
    }

    @FXML
    private void RemoveOnAction(ActionEvent event) {
     ObservableList<Bill> selectedProduct=FXCollections.observableArrayList();
        selectedProduct=Billtable.getSelectionModel().getSelectedItems();
        productList.removeAll(selectedProduct);
        TotalBill();
    
    }

    @FXML
    private void addInfo(KeyEvent event) throws SQLException, ClassNotFoundException {
        String id=ProductIDbill.getText();
        if(id.length()==8){
        
           product pd=new product();
           
           pd=addBillProduct(id);
          UnitPrice.setText(pd.Unit_Price);
          ProductName.setText(pd.Product_Name);
          
        }
    
    
    }

    @FXML
    private void FindCustomer(KeyEvent event) throws ClassNotFoundException, SQLException {
    String p=CustomerPhone.getText();
        if(p.length()==11){
        
           Customer pd=new Customer();
           
           pd=getCustomerInfo(p);
         
          CustoID.setText(pd.CustomerID);
          cusmember.setText(pd.MembershipType);
          cusname.setText(pd.CustomerName);
           if(c==2)
           {
           CustoID.setText("Not Registered");
          cusmember.setText("Non Membership Customer");
         
           }
        
        } 
    
    
    }
    Customer getCustomerInfo(String value) throws SQLException, ClassNotFoundException {
        String CustomerName="";
        String MembershipType="";
        String CustomerId="";
        c=2;
         DBconnection dbc =new DBconnection();
          dbc.connectToDB();
        String query = "SELECT CustomerName,CustomerId,MembershipType FROM Customer  WHERE CustomerPhone='"+ value + "'";
         dbc.queryToDB(query);
        ResultSet rs= dbc.queryToDB(query);
        while (rs.next()) {
             CustomerName = rs.getString("CustomerName"); 
             CustomerId = rs.getString("CustomerId");
             MembershipType=rs.getString("MembershipType");
         c=1;  
        }
        System.out.println(CustomerId);
        Customer c = new Customer(CustomerId,CustomerName,value,MembershipType);
        return c;
    }

    @FXML
    private void PrintBill(ActionEvent event) {
            setArea();
    
    }

    @FXML
    private void aaa(ActionEvent event) {
         print(text);
    }
  
    
}
