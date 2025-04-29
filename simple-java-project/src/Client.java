import java.util.Random;

public class Client {
    private String name;
    private int serveTime;
    private int arrivalTime;
    private boolean hasBeenServed = false;
    private int awaitingTime = 0; 

    public Client(String name) {
        this.name = name;
        Random random = new Random();
        this.serveTime = 30 + random.nextInt(91);
        this.arrivalTime = 5 + random.nextInt(46);
    }

    public String getName() {
        return name;
    }

    public int getServeTime() {
        return serveTime;
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

    public void setHasBeenServed(boolean hasBeenServed) {
        this.hasBeenServed = hasBeenServed;
    }

    public boolean getHasBeenServed() {
        return this.hasBeenServed;
    }

    @Override
    public String toString() {
        return String.format(
                "Client{name='%s', serveTime=%d, arrivalTime=%d}",
                name, serveTime, arrivalTime
        );
    }
}
