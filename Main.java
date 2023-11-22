public class Main {
    public static void main(String[] args) {

        InventoryItemFactory factory = new InventoryItemFactory();
        InventoryItem product = factory.CreateItem("product", "Lays", 20);
        InventoryItem equipment = factory.CreateItem("equipment", "Chips maker", 5);

        InventoryCommunicationMediator mediator = new InventoryCommunicationMediator();


        Employee employee1 = new InventoryEmployee("Abubakr", mediator);
        Employee employee2 = new InventoryEmployee("Devashree", mediator);
        Employee manager = new InventoryEmployee("Atharva", mediator);


        Inventory inventory = new Inventory(mediator);
        inventory.addObserver(item -> {
            if (item.getQuantity() < 10) {
                System.out.println("Low inventory for item: " + item.getName());
            }
        });


        inventory.addEmployee("Employee 1");
        inventory.addEmployee("Employee 2");
        inventory.addEmployee("Manager");


        InventoryUpdateCommand updateCommand = new InventoryUpdateCommand(product, -20);
        updateCommand.execute();
        inventory.notifyObservers(product);

        updateCommand = new InventoryUpdateCommand(equipment, -15);
        updateCommand.execute();
        inventory.notifyObservers(equipment);
    }
}
