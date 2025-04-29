import java.util.List;

public class TimeWork {
    public int actualTime;
    public Queue queue;
    public List<Client> clients;

    TimeWork(Queue queue, List<Client> clients) {
        this.actualTime = 0;
        this.queue = queue;
        this.clients = clients;
    }

    public synchronized void setActualTime(int time) {
        if (time > this.actualTime) {

            for (int i = 1; i <= (time -  this.actualTime); i++) {
                this.queue.addAwaitingTimeIntoClientsInQueue();

                for (Client client : this.clients) {
                    if (client.getArrivalTime() == (time + i)) {
                        this.queue.addClient(client);
                    }
                }
            }

            this.actualTime = time;
        }
    }

    public int getActualTime() {
        return this.actualTime;
    }
}
