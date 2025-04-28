import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int elevenAMtoOnePMinSeconds = 7200;
    public static final int NUMBER_OF_CLIENTS = 10; 

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_CLIENTS; i++) {
            clients.add(new Client("Cliente" + i));
        }

        System.out.println("Clientes criados:");
        for (Client client : clients) {
            System.out.println(client);
        }

        Queue queue = new Queue();

        for (int seconds = 0; seconds < elevenAMtoOnePMinSeconds; seconds++) {
        }
    }
}