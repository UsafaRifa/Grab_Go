/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grab.go;

/**
 *
 * @author Mukaffi
 */
public class Employee {
    String FirstName;
    String LasttName;
    String EmployeeID;
    String PhoneNumber;
    String Address;
    String Degisnation;

    public Employee(String FirstName, String LasttName, String EmployeeID, String PhoneNumber, String Address, String Degisnation) {
        this.FirstName = FirstName;
        this.LasttName = LasttName;
        this.EmployeeID = EmployeeID;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Degisnation = Degisnation;
    }

    public Employee() {
    }

    public Employee(String FirstName, String LasttName, String PhoneNumber, String Address, String Degisnation) {
        this.FirstName = FirstName;
        this.LasttName = LasttName;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Degisnation = Degisnation;
    }
    

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLasttName() {
        return LasttName;
    }

    public void setLasttName(String LasttName) {
        this.LasttName = LasttName;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDegisnation() {
        return Degisnation;
    }

    public void setDegisnation(String Degisnation) {
        this.Degisnation = Degisnation;
    }
    
    
    @Override
    public String toString() {
        return "Eployee{" + "name=" + FirstName + ", Phone=" + PhoneNumber + ", Degisnation=" + Degisnation + ", address=" + Address + '}';
    }
    
}
