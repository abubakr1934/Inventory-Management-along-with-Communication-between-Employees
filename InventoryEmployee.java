public class InventoryEmployee implements Employee{
    String name;
    CommunicationMediator mediator;

    public InventoryEmployee(String name, CommunicationMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addEmployee(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message,name);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name +"recieved message "+message);
    }
}
