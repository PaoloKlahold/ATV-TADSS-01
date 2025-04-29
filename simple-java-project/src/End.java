import java.util.Formatter;
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

    public synchronized void end() {
        this.isEnd += 1;

        System.out.println(this.isEnd + " caixas encerraram o atendimento.");
        if (this.isEnd != this.cashiersQtd) {
            return;
        }

        System.out.println("\nDetalhes dos Clientes:");
        System.out.println("Legenda:");
        System.out.println("TEF - Tempo de Espera na fila");
        System.out.println("TAPD - Tempo de Atendimento pré definido");
        System.out.println("TCPD - Tempo de chegada pré definido");
        System.out.println("TC - Tempo de chegada\n");

        System.out.printf("%-15s %-15s %-25s %-25s %-25s %-25s\n", 
            "Cliente", 
            "Atendido", 
            "TEF", 
            "TAPD", 
            "TCPD", 
            "TC"
        );

        int totalWaitingTime = 0;
        int totalTimeInBank = 0;
        int maxWaitingTime = 0;
        int maxServeTime = 0;
        int servedClients = 0;

        for (Client client : this.clients) {
            String servedStatus = client.getHasBeenServed() ? "Sim" : "Não";
            totalWaitingTime += client.getAwaitingTime();
            totalTimeInBank += client.getAwaitingTime() + client.getDefinedServeTime();
            maxWaitingTime = Math.max(maxWaitingTime, client.getAwaitingTime());
            maxServeTime = Math.max(maxServeTime, client.getDefinedServeTime());

            if (client.getHasBeenServed()) {
                servedClients++;
            }

            System.out.printf("%-15s %-15s %-25d %-25d %-25d %-25d\n", 
                client.getName(), 
                servedStatus, 
                client.getAwaitingTime(), 
                client.getDefinedServeTime(),
                client.getDefinedArrivalTime(),
                client.getArrivalTime()
            );
        }

        double averageWaitingTime = (double) totalWaitingTime / this.clients.size();
        double averageTimeInBank = (double) totalTimeInBank / this.clients.size();

        System.out.println("\nEstatísticas Gerais:");
        System.out.printf("%-30s %-10d\n", "Tempo total de espera (segundos):", this.timeWork.getActualTime());
        System.out.printf("%-30s %-10d\n", "Tempo total de espera (minutos):", this.timeWork.getActualTime() / 60);
        System.out.printf("%-30s %-10d\n", "Tempo total de espera (horas):", this.timeWork.getActualTime() / 3600);
        System.out.printf("%-30s %-10.2f\n", "Tempo médio de espera (segundos):", averageWaitingTime);
        System.out.printf("%-30s %-10d\n", "Número de clientes atendidos:", servedClients);
        System.out.printf("%-30s %-10d\n", "Número total de clientes:", this.clients.size());
        System.out.printf("%-30s %-10d\n", "Tempo máximo de espera (segundos):", maxWaitingTime);
        System.out.printf("%-30s %-10d\n", "Tempo máximo de atendimento (segundos):", maxServeTime);
        System.out.printf("%-30s %-10.2f\n", "Tempo médio no banco (segundos):", averageTimeInBank);
        System.out.printf("%-30s %-10s\n", "Objetivo de 2 minutos atingido:", averageWaitingTime <= 120 ? "Sim" : "Não");

        System.out.println("\nHistórico da Fila:");
        System.out.printf("%-50s\n", "Evento");
        for (String history : this.queue.getQueueHistory()) {
            System.out.printf("%-50s\n", history);
        }
    }
}