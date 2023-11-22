public class InventoryItemFactory {
    public InventoryItem CreateItem(String type,String name,int quantity)
    {
        if(type.equalsIgnoreCase("product"))
        {
            return new Product(name,quantity);
        }
        else if(type.equalsIgnoreCase("equipment"))
        {
            return new Equipment(name,quantity);
        }
        else
            System.out.println("wrong item requested recheck your spellings .Thank you!");
            return null;
    }
}
