import java.io.IOException;
import java.util.Scanner;

public class FTPClientMenu {
    private boolean running;
    private Scanner sc;
    private FTP_Client client;
    private String command;

    public FTPClientMenu() throws IOException {
        client = new FTP_Client();
        sc = new Scanner(System.in);
        running = true;

        while (running = true) {

            //Menu
            System.out.println("Enter a command");
            System.out.println("----------------");
            System.out.println("open + URL");
            System.out.println("dir");
            System.out.println("cd + directory");
            System.out.println("get + filename");
            System.out.println("quit");
            System.out.println("Type EXIT to exit the client");
            System.out.println("---------------" +"\n");

            command = sc.nextLine();

            if (command.startsWith("open")) {
                client.open(parseCommand(5));
            } else if (command.equals("dir")) {
                client.dir();
            } else if (command.startsWith("cd")) {
                client.cd(parseCommand(3));
            } else if (command.equals("quit")) {
                client.quit();
            } else if (command.startsWith("get")) {
                client.get(parseCommand(4));
            } else if(command.equals("EXIT")) {
                running = false;
            }
        }
    }


    public String parseCommand(int index) {
        return command.substring(index);
    }
}
