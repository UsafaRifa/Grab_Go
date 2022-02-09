
package grab.go;


public class Stock {
    
    
    String ProductName;
    String ProductUpcomingQuantity;
    String ProductQuantity;

    public Stock() {
    }

    public Stock(String ProductName, String ProductUpcomingQuantity, String ProductQuantity) {
        this.ProductName = ProductName;
        this.ProductUpcomingQuantity = ProductUpcomingQuantity;
        this.ProductQuantity = ProductQuantity;
    }
    

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductUpcomingQuantity() {
        return ProductUpcomingQuantity;
    }

    public void setProductUpcomingQuantity(String ProductUpcomingQuantity) {
        this.ProductUpcomingQuantity = ProductUpcomingQuantity;
    }

    public String getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(String ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }
    
            
    
}
