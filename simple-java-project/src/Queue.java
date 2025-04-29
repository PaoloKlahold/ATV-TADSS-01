import java.util.ArrayList;
import java.util.List;

public class Queue {
    private int timeLimitInQueue;
    private List<Client> clientsInQueue;
    private List<String> queueHistory;

    public Queue() {
        this.clientsInQueue = new ArrayList<Client>();
        this.timeLimitInQueue = 120;
        this.queueHistory = new ArrayList<String>();
    }

    public synchronized void addClient(Client client) {
        this.clientsInQueue.add(client);
    }

    public void removeClient(Client client) {
        this.clientsInQueue.remove(client);
        this.queueHistory.add(client.getName() + " foi chamado no horário " + client.getAwaitingTime() + ".");
    }

    public void addInQueueHistory(String history) {
        this.queueHistory.add(history);
    }

    public synchronized Client getFirstClient() {
        if (this.clientsInQueue.isEmpty()) {
            return null;
        }
        Client client = this.clientsInQueue.get(0);
        removeClient(client);
        return client;
    }

    public void addAwaitingTimeIntoClientsInQueue() {
        if (this.clientsInQueue.isEmpty()) {
            return;
        }

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

    public List<String> getQueueHistory() {
        return this.queueHistory;
    }
}
