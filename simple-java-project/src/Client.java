import java.util.Random;

public class Client {
    private String name;
    private int queueTime;
    private int arrivalTime;
    private int awaitingTime = 0; 

    public Client(String name) {
        this.name = name;
        Random random = new Random();
        this.queueTime = 30 + random.nextInt(91);
        this.arrivalTime = 5 + random.nextInt(46);
    }

    public String getName() {
        return name;
    }

    public int getQueueTime() {
        return queueTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void addAwaitingTime() {
        this.awaitingTime += 1;
    }

    public int getAwaitingTime() {
        return awaitingTime;
    }

    @Override
    public String toString() {
        return String.format(
                "Client{name='%s', queueTime=%d, arrivalTime=%d}",
                name, queueTime, arrivalTime
        );
    }
}
