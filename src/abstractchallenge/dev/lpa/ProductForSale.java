package abstractchallenge.dev.lpa;

public abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int qty) {
        return qty * price;
    }

    public void printPricedItem(int qty) {
        System.out.println("qty: " + qty);
        System.out.println("price: " + price);
        System.out.println("type: " + type);
        System.out.println("description: " + description);
    }

    public abstract void showDetails();
}
