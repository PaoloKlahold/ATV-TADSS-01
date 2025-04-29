public class Cashier extends Thread {
    public static int elevenAMtoOnePMinSeconds = 7200;
    private String name;
    private Queue queue;
    private TimeWork timeWork;
    private End end;
    private boolean isOpen;

    public Cashier(String name, Queue queue, TimeWork timeWork, End end) {
        this.name = name;
        this.queue = queue;
        this.timeWork = timeWork;
        this.end = end;
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
        this.end.end();
    }

    public String getCashierName() {
        return this.name;
    }

    private synchronized void work() {
        int time = timeWork.getActualTime();

        if (!queue.isEmpty()) {
            Client client = queue.getFirstClient();
            if (client != null) {
                queue.addInQueueHistory(client.getName() + " foi atendido no horário " + time + ".");
                serveClient(client, time);
            }
        } else {
            if (time >= elevenAMtoOnePMinSeconds) {
                stopWorking();
            } else {
                timeWork.setActualTime(time + 1);
            }
        }
    }

    private void serveClient(Client client, int time) {
        for (int i = 1; i <= client.getDefinedServeTime(); i++) {
            timeWork.setActualTime(time + i);
        }

        client.setHasBeenServed(true);
    }
}