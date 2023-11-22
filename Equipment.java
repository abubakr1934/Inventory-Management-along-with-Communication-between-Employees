public class Equipment implements InventoryItem{
    String name;
    int quantity;

    public Equipment(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void updateQuantity(int quantity) {
        this.quantity+=quantity;

    }
}
