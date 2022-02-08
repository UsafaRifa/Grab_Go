/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class product {
    
    String Product_Id;
       String     Product_Name;
            String Shelf_no;
           LocalDate  MFG_Date;
           LocalDate Exp_Date;
            String Unit_Price;
             String Available_Stock;

    public product() {
        
        
        
    }
             

    
             
        public product(String Product_Id, String Product_Name, String Shelf_no, LocalDate MFG_Date, LocalDate Exp_Date, String Unit_Price, String Available_Stock) {
        this.Product_Id = Product_Id;
        this.Product_Name = Product_Name;
        this.Shelf_no = Shelf_no;
        this.MFG_Date = MFG_Date;
        this.Exp_Date = Exp_Date;
        this.Unit_Price = Unit_Price;
        this.Available_Stock = Available_Stock;
    }

    public String getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(String Product_Id) {
        this.Product_Id = Product_Id;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String Product_Name) {
        this.Product_Name = Product_Name;
    }

    public String getShelf_no() {
        return Shelf_no;
    }

    public void setShelf_no(String Shelf_no) {
        this.Shelf_no = Shelf_no;
    }

    public LocalDate getMFG_Date() {
        return MFG_Date;
    }

    public void setMFG_Date(LocalDate MFG_Date) {
        this.MFG_Date = MFG_Date;
    }

    public LocalDate getExp_Date() {
        return Exp_Date;
    }

    public void setExp_Date(LocalDate Exp_Date) {
        this.Exp_Date = Exp_Date;
    }

    public String getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(String Unit_Price) {
        this.Unit_Price = Unit_Price;
    }

    public String getAvailable_Stock() {
        return Available_Stock;
    }

    public void setAvailable_Stock(String Available_Stock) {
        this.Available_Stock = Available_Stock;
    }
                 
             

     public String toString() {
        return "product{" + "Product_Id=" + Product_Id + ", Product_Name=" +  Product_Name + ", MFG_Date=" + MFG_Date+ ", Exp_Date=" + Exp_Date+ '}';
    }
    
}
