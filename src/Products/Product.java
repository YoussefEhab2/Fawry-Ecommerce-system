package Products;

import Expire.ExpireBehaviour;
import Shipping.ShippingBehaviour;

public class Product {
        String name;
        double price;
        int quantity;
        ShippingBehaviour shippingBehaviour;
        ExpireBehaviour expireBehaviour;
        public Product(String name,int price,int quantity,ExpireBehaviour expireBehaviour,ShippingBehaviour shippingBehaviour) {
                this.name=name;
                this.price=price;
                this.quantity=quantity;
                this.shippingBehaviour=shippingBehaviour;
                this.expireBehaviour=expireBehaviour;
        }
        public String getName() {
                return name;
        }
        public double getPrice() {
                return price;
        }
        public int getQuantity() {
                return quantity;
        }
        public boolean isExpired() {
                return this.expireBehaviour!=null &&expireBehaviour.isexpired();
        }
        public boolean isShippable() {
                return shippingBehaviour!=null&&shippingBehaviour.getname()!=null;
        }
        public double getweight() {
                return isShippable()?shippingBehaviour.getweight():0;
        }
        public void decrement(int amount){
                quantity-=amount;
        }
}
