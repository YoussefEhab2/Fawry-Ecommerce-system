package Services;

import Cart.Cart;
import Cart.CartItem;


public class ShippingService {
    public void ship(Cart cart){
        System.out.println("** Shipment notice **");

        for(CartItem item : cart.getCart()){
            System.out.printf("%dx %s\t%.0fg\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getweight() * 1000);
        }
        double totalWeight =cart.getTotalWeight();
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);

    }
}
