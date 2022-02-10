/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jfoenix.controls.JFXTextField;
import static grab.go.QrCodeReadController.readQRCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableView<?> Billtable;
    @FXML
    private TableColumn<?, ?> BillProductID;
    @FXML
    private TableColumn<?, ?> BillProductName;
    @FXML
    private TableColumn<?, ?> BillUnitPrice;
    @FXML
    private TableColumn<?, ?> BillQuantity;
    @FXML
    private TableColumn<?, ?> BillsubTotal;
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
    @FXML
    private AnchorPane BillPage;
    final FileChooser fc =new FileChooser();
    /**
     * Initializes the controller class.
     */
     public  static String pID;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
    }



    @FXML
    private void back(ActionEvent event) throws IOException {
      Parent pane=FXMLLoader.load(getClass().getResource("ReceptionistHomePage.fxml"));
                 BillPage.getChildren().setAll(pane);
    
    }

    @FXML
    private void AddProducttable(ActionEvent event) {
    }
   
    static Stage stage = new Stage();
    @FXML
    private void QrcodeRead(ActionEvent event) throws IOException, FileNotFoundException, NotFoundException {
   fc.setTitle("my File Chooser");
        // the selected file 
        File file=fc.showOpenDialog(null);
        
        String pathqr=file.getAbsolutePath();
        read(pathqr);
        
     


    
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
  

    @FXML
    private void RemoveOnAction(ActionEvent event) {
    }
    
}
