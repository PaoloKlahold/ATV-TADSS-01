import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int NUMBER_OF_CLIENTS = 10; 
    public static final int NUMBER_OF_CASHIERS = 4; 

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_CLIENTS; i++) {
            clients.add(new Client("Cliente" + i));
        }

        Queue queue = new Queue();
        TimeWork timeWork = new TimeWork(queue, clients);
        End end = new End(queue, timeWork, clients, NUMBER_OF_CASHIERS);

        List<Cashier> cashiers = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_CASHIERS; i++) {
            cashiers.add(new Cashier("Caixa" + i, queue, timeWork, end));
        }

        for (Cashier cashier : cashiers) {
            cashier.startWorking();
        }
    }
}