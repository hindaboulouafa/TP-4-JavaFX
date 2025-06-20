package hind.aboulouafa;

public class Product {
    private String name;
    private double price;

    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name; }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name + " - " + price + " DH";
    }
}
