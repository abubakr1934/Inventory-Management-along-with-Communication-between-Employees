public class InventoryUpdateCommand {
    InventoryItem item;
    int quantity;

    public InventoryUpdateCommand(InventoryItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    void execute()
    {
        item.updateQuantity(quantity);
    }
}
