package Services;

import Cart.Cart;
import Cart.CartItem;
import Customer.Customer;
import Products.Product;

public class CheckoutService {
    public void Checkout(Customer customer) {
        Cart cart= customer.getCart();
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        for (CartItem item:cart.getCart()) {
            Product product=item.getProduct();

            if (product.isExpired()) {
                throw new IllegalStateException(product.getName()+" is expired");
            }

            if (item.getQuantity()>product.getQuantity()) {
                throw new IllegalStateException(product.getName()+" is out of stock");
            }
        }
        if(!customer.canAfford()){
            throw new IllegalStateException("Insufficient balance");
        }
        double subtotal=cart.getSubtotal();
        double shipping= cart.getShippingCost();
        double total= cart.getTotalPrice();
        new ShippingService().ship(cart);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getCart()) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            System.out.printf("%dx %s\t%.0f\n", item.getQuantity(), item.getProduct().getName(), itemTotal);
            item.getProduct().decrement(item.getQuantity());
        }

        System.out.println("------------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", total);
        customer.deductBalance(total);
        System.out.printf("Remaining Balance\t%.0f\n", customer.getBalance());
    }
}
