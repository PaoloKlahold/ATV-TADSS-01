import java.util.Random;

public class Client {
    private String name;
    private int definedServeTime; // Tempo de atendimento pré definido
    private int definedArrivalTime; // Tempo de chegada após o anterior pré definido
    private boolean hasBeenServed;
    private int awaitingTime; 
    private int arrivalTime; // Tempo de chegada do cliente

    public Client(String name) {
        this.name = name;
        Random random = new Random();
        this.definedServeTime = 30 + random.nextInt(91);
        this.definedArrivalTime = 5 + random.nextInt(46);
        this.hasBeenServed = false;
        this.awaitingTime = 0;
        this.arrivalTime = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDefinedServeTime() {
        return this.definedServeTime;
    }

    public int getDefinedArrivalTime() {
        return this.definedArrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void addAwaitingTime() {
        this.awaitingTime += 1;
    }

    public int getAwaitingTime() {
        return this.awaitingTime;
    }

    public void setHasBeenServed(boolean hasBeenServed) {
        this.hasBeenServed = hasBeenServed;
    }

    public boolean getHasBeenServed() {
        return this.hasBeenServed;
    }
}
