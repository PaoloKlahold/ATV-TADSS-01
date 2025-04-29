import java.util.List;

public class End {
    private Queue queue;
    private List<Client> clients;
    private int cashiersQtd;
    private TimeWork timeWork;
    private int isEnd;

    public End(Queue queue, TimeWork timeWork, List<Client> clients, int cashiersQtd) {
        this.queue = queue;
        this.clients = clients;
        this.timeWork = timeWork;
        this.cashiersQtd = cashiersQtd;
        this.isEnd = 0;
    }

    public void end() {
        this.isEnd += 1;

        if (this.isEnd != this.cashiersQtd) {
            return;
        }

        for (Client client : this.clients) {
            if (!client.getHasBeenServed()) {
                System.out.println("O cliente " + client.getName() + " não foi atendido.");
            }
        }

        System.out.println("O tempo total de espera foi de " + this.timeWork.getActualTime() + " segundos.");
        System.out.println("O tempo total de espera foi de " + (this.timeWork.getActualTime() / 60) + " minutos.");
        System.out.println("O tempo total de espera foi de " + (this.timeWork.getActualTime() / 3600) + " horas.");
    }
}