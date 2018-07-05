import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public void start(int ip) {
        try {
            serverSocket = new ServerSocket(21);
            socket = serverSocket.accept();

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

            String request;
            while((request = reader.readLine()) != null) {
                if("\n".equals(request)) {
                    System.out.println("Fertig");
                }
                writer.println(request);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void quit() throws IOException {
        reader.close();
        writer.close();
        socket.close();
        serverSocket.close();
        System.out.println("Server has shut down");
    }
}
