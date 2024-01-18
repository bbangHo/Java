package access.ex2;

public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item (String n, int p, int q) {
        name = n;
        price = p;
        quantity = q;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }
}
