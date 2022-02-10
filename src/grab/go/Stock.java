
package grab.go;


public class Stock {
    
    
    String ProductName;
   
    String ProductQuantity;
     String ProductUpcomingQuantity;

    public Stock() {
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

    public Stock(String ProductName, String ProductQuantity, String ProductUpcomingQuantity) {
        this.ProductName = ProductName;
        this.ProductQuantity = ProductQuantity;
        this.ProductUpcomingQuantity = ProductUpcomingQuantity;
    }

   
    
}
