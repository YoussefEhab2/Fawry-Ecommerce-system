package Cart;

import Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cart = new ArrayList<>();
    public void add(Product product, int quantity) {
        if(product.getQuantity() > quantity) {
            cart.add(new CartItem(product, quantity));
        }else{
            throw new IllegalArgumentException("Not enough stock for "+product.getName());
        }
    }
    public List<CartItem> getCart() {
        return cart;
    }
    public void remove(Product product) {
        cart.remove(new CartItem(product,1));
    }
    public boolean isEmpty() {
        return cart.isEmpty();
    }
    public double getTotalWeight() {
        double sum = 0.0;
        for (CartItem item : cart) {
            sum+=item.product.getweight();
        }
        return sum;
    }
    public double getShippingCost() {
        return getTotalWeight()>0?30:0;
    }
    public double getSubtotal(){
        double sum = 0.0;
        for (CartItem item : cart) {
            sum+=item.product.getPrice()*item.quantity;
        }
        return sum;
    }
    public double getTotalPrice() {
        double sum = 0.0;
        sum+=getSubtotal();
        sum+=getShippingCost();
        return sum;
    }
}
