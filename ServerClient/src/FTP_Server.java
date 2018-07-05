import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FTP_Server {
    private ServerSocket server;
    private static int port;
    private boolean passive;

    public FTP_Server() {
        port = 21;

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(true) {
            try {
                System.out.println("Warte auf Client...");
                Socket client = server.accept();
                System.out.println("Erfolgreich verbunden");

                PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println("The message: " + str);

                    if (str.equals("end")) {
                        pw.println("end");
                        break;
                    } else {
                        str = "Server returns " + str;
                        pw.println(str);
                    }
                }

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        FTP_Server s = new FTP_Server();
        s.run();
    }
}
