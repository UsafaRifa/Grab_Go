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
public class Customer {
    
      
    
    String CustomerID;
    String CustomerName;
    String CustomerAddress;
    String CustomerEmail;
    String CustomerPhoneNumber;
    String MembershipType;
    String Credit;

    public Customer(String CustomerID, String CustomerName, String CustomerAddress, String CustomerEmail, String CustomerPhoneNumber, String MembershipType, String Credit) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPhoneNumber = CustomerPhoneNumber;
        this.MembershipType = MembershipType;
        this.Credit = Credit;
    }

    public Customer() {
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

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String CustomerPhoneNumber) {
        this.CustomerPhoneNumber = CustomerPhoneNumber;
    }

    public String getMembershipType() {
        return MembershipType;
    }

    public void setMembershipType(String MembershipType) {
        this.MembershipType = MembershipType;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String Credit) {
        this.Credit = Credit;
    }


    
    
   public String toString() {
        return "Customer{" + "name=" + CustomerName + ", Phone=" + CustomerPhoneNumber + ", CustomerEmail=" + CustomerEmail + ", address=" +CustomerAddress + '}';
    }
    
}

/* String CustomerID;
    String CustomerName;
    String CustomerAddress;
    String CustomerEmail;
    String CustomerPhoneNumber;
    String CustomerPassword; */