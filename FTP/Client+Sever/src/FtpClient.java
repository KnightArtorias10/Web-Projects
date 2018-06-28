import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class FtpClient {
    private Socket socket;
    private static int port = 21;

    public FtpClient() {

    }

    public void connect(String host) throws IOException {
        System.out.println("Verbindung wird hergestellt...");
        InetAddress address = InetAddress.getByName(host);
        socket = new Socket(address, port);
        System.out.println("Erfolgreich verbunden mit " +address.getHostName());
    }

    public void getFile(String fileName) {

    }

    public void printCurrentDirection() {
        for() {

        }
    }

    //boolean
    public void changeDirection(String direction) {

    }

    public void disconnect() throws IOException {
        socket.close();
    }
}
