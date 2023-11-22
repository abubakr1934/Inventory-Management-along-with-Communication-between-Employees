import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<InventoryObserver > observers=new ArrayList<>();
    List<String> remainingEmployees=new ArrayList<>();
    CommunicationMediator mediator;
    public Inventory(CommunicationMediator mediator)
    {
        this.mediator=mediator;
    }
    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
    }

    public void addEmployee(String employee) {
        remainingEmployees.add(employee);
    }

    public void removeEmployee(String employee) {
        remainingEmployees.remove(employee);
    }

    public void notifyObservers(InventoryItem item) {
        for (InventoryObserver observer : observers) {
            observer.update(item);
        }

        if (item.getQuantity() == 0) {
            notifyEmployees(item.getName() + " has finished and needs to be updated.");
        }
    }

    private void notifyEmployees(String message) {
        for (String employee : remainingEmployees) {
            mediator.sendMessage(message, employee);
        }
    }
}
