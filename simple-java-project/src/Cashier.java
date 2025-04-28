import java.sql.Time;

public class Cashier extends Thread {
    private Queue queue;
    private TimeWork timeWork;
    private boolean isOpen;

    public Cashier(Queue queue, TimeWork timeWork) {
        this.queue = queue;
        this.timeWork = timeWork;
    }

    @Override
    public void run() {
        while (this.isOpen) {
            work();
        }
    }

    public void startWorking() {
        this.isOpen = true;
        this.start();
    }

    public void stopWorking() {
        this.isOpen = false;
    }

    private void work() {
        if (!queue.isEmpty()) {
            int time = timeWork.getActualTime();
            Client client = queue.getFirstClient();
            serveClient(client);

        }
    }

    private void serveClient(Client client) {
        for (int i = 0; i < client.getQueueTime(); i++) {
            
        }
    }
}