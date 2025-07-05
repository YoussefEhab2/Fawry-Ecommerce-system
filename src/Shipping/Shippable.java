package Shipping;

public class Shippable implements ShippingBehaviour{
double weight;
String name;
public Shippable(double weight, String name) {
    this.weight=weight;
    this.name=name;
}
public double getweight() {
    return weight;
}
public void setweight(double weight) {
    this.weight=weight;
}
public String getname() {
    return name;
}
public void setname(String name) {
    this.name=name;
}

}
