import java.util.ArrayList;
import java.util.List;

public class InventoryCommunicationMediator implements CommunicationMediator{
    List<Employee> employees=new ArrayList<>();
    public void sendMessage(String message, String sender) {
        for (Employee employee : employees) {
            if (!employee.getName().equalsIgnoreCase(sender)) {
                employee.receiveMessage(message);
            }
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
