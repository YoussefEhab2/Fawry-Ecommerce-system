package Products;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();
    public Product getProduct(String name) {
       for(Product p : products) {
           if(p.getName().equals(name)) {
               return p;
           }
       }
       return null;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public List<Product> getProducts() {
        return products;
    }
    public boolean isAvailable(String name,int qty) {
        Product p=getProduct(name);
        return p!=null && p.getQuantity()>=qty &&!p.isExpired();
    }
}
