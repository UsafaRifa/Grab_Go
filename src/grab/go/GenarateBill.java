/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import java.time.LocalDate;

/**
 *
 * @author Mukaffi
 */
public class GenarateBill {
    String  ProductID;
    String  ProductName;
    String  ProductUnitprice;
    String  ProductQuantity;
    String  ProductSubTotal;
    String  ProductVat;
    String  ProductTotal;
    String InvoiceNo;
    LocalDate InvoiceDate;
    String CustomerID;
    String CustomerName;
    String CustomerTotal;

    public GenarateBill(String ProductID, String ProductName, String ProductUnitprice, String ProductQuantity, String ProductSubTotal, String ProductVat, String ProductTotal, String InvoiceNo, LocalDate InvoiceDate, String CustomerID, String CustomerName, String CustomerTotal) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductUnitprice = ProductUnitprice;
        this.ProductQuantity = ProductQuantity;
        this.ProductSubTotal = ProductSubTotal;
        this.ProductVat = ProductVat;
        this.ProductTotal = ProductTotal;
        this.InvoiceNo = InvoiceNo;
        this.InvoiceDate = InvoiceDate;
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerTotal = CustomerTotal;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductUnitprice() {
        return ProductUnitprice;
    }

    public void setProductUnitprice(String ProductUnitprice) {
        this.ProductUnitprice = ProductUnitprice;
    }

    public String getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(String ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }

    public String getProductSubTotal() {
        return ProductSubTotal;
    }

    public void setProductSubTotal(String ProductSubTotal) {
        this.ProductSubTotal = ProductSubTotal;
    }

    public String getProductVat() {
        return ProductVat;
    }

    public void setProductVat(String ProductVat) {
        this.ProductVat = ProductVat;
    }

    public String getProductTotal() {
        return ProductTotal;
    }

    public void setProductTotal(String ProductTotal) {
        this.ProductTotal = ProductTotal;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public LocalDate getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(LocalDate InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerTotal() {
        return CustomerTotal;
    }

    public void setCustomerTotal(String CustomerTotal) {
        this.CustomerTotal = CustomerTotal;
    }
    
    
    
    
}
