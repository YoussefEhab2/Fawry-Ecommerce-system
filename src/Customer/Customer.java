package Customer;

import Cart.Cart;

public class Customer {
    String name;
    double balance;
    Cart cart;
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public Cart getCart() {
        return cart;
    }
    public boolean canAfford() {
        return balance>=cart.getTotalPrice();
    }
    public void deductBalance(double amount) {
        balance -= amount;
    }
}
