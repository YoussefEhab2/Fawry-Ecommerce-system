package Shipping;

public class NonShippable implements ShippingBehaviour{
    public double getweight(){
        return 0;
    }
    public String getname(){
        return null;
    }
}
