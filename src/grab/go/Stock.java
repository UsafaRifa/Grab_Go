
package grab.go;


public class Stock {
    
     String ProductID;
    String ProductName;
    String ProductQuantity;
     String ProductUpcomingQuantity;

    public Stock() {
    }

    public Stock(String ProductID, String ProductName, String ProductQuantity, String ProductUpcomingQuantity) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductQuantity = ProductQuantity;
        this.ProductUpcomingQuantity = ProductUpcomingQuantity;
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

    public String getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(String ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }

    public String getProductUpcomingQuantity() {
        return ProductUpcomingQuantity;
    }

    public void setProductUpcomingQuantity(String ProductUpcomingQuantity) {
        this.ProductUpcomingQuantity = ProductUpcomingQuantity;
    }

    

    
    
}
