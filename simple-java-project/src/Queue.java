import java.util.ArrayList;
import java.util.List;

public class Queue {
    private int timeLimitInQueue;
    private List<Client> clientsInQueue;

    public Queue() {
        this.clientsInQueue = new ArrayList<>();
        this.timeLimitInQueue = 120;
    }

    public void addClient(Client client) {
        this.clientsInQueue.add(client);
    }

    public void removeClient(Client client) {
        this.clientsInQueue.remove(client);
    }

    public Client getFirstClient() {
        Client client = this.clientsInQueue.get(0);
        removeClient(client);
        return client;
    }

    public void addAwaitingTimeIntoClientsInQueue() {
        for (Client client : this.clientsInQueue) {
            client.addAwaitingTime();

            if (client.getAwaitingTime() > this.timeLimitInQueue) {
                System.out.println("O cliente " + client.getName() + " excedeu o tempo limite na fila.");
            }
        }
    }

    public boolean isEmpty() {
        return this.clientsInQueue.isEmpty();
    }
}
