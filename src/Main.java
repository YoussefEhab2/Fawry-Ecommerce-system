import Expire.NonExpirable;
import Products.Inventory;
import Products.Product;
import Customer.Customer;
import Cart.Cart;
import Services.CheckoutService;
import Expire.Expirable;
import Shipping.Shippable;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5,
                new Expirable(LocalDate.of(2025, 7, 5)),
                new Shippable(0.2, "Cheese"));

        Product biscuits = new Product("Biscuits", 150, 4,
                new Expirable(LocalDate.of(2025, 8, 1)),
                new Shippable(0.7,"Biscuits" ));

        Product Guitar = new Product("Guitar", 1500, 4,
                new Expirable(LocalDate.of(2025, 8, 1)),
                new Shippable(1.5,"Guitar" ));

        Product scratchCard = new Product("ScratchCard", 50, 10,
                new NonExpirable(), null);

        Inventory inventory = new Inventory();
        inventory.addProduct(cheese);
        inventory.addProduct(biscuits);
        inventory.addProduct(scratchCard);
        inventory.addProduct(Guitar);

        Customer customer = new Customer("Youssef", 1000);

        Cart cart = customer.getCart();
        cart.add(inventory.getProduct("Cheese"), 2);
        cart.add(inventory.getProduct("Biscuits"), 1);
        cart.add(inventory.getProduct("ScratchCard"), 1);
//        cart.add(inventory.getProduct("Guitar"), 1);

        new CheckoutService().Checkout(customer);
    }
}