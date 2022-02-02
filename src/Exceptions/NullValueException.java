/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import javafx.scene.control.Alert;

/**
 *
 * @author FUJITSU
 */
public class NullValueException extends RuntimeException{

    public NullValueException(String msg1, String msg2) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText(msg1);
        alert.setContentText(msg2);
        alert.showAndWait();
    }
    
    
}
