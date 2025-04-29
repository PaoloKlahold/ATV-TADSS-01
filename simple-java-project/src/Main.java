import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int NUMBER_OF_CLIENTS = 20; 
    public static final int NUMBER_OF_CASHIERS = 4; 

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_CLIENTS; i++) {
            clients.add(new Client("Cliente" + i));
        }

        // Para cada cliente, adiciona o tempo de chegada na fila
        for (Client client : clients) {
            int arrivalTime = client.getDefinedArrivalTime();
            if (clients.indexOf(client) > 0) {
                arrivalTime += clients.get(clients.indexOf(client) - 1).getArrivalTime();
            }

            client.setArrivalTime(arrivalTime);
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

        for (Cashier cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}