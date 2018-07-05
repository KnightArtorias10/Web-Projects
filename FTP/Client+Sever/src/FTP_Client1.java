import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FTP_Client1 {
    private InputStream in;
    private OutputStream out;
    BufferedReader reader;
    private Writer writer;
    private Socket s;
    private static int port = 21;
    private String host;

    public FTP_Client1() throws IOException {
      //  displayMenu();
    }

    public void connect(String url) throws Exception {
        System.out.println("Verbindung wird hergestellt...");
        InetAddress address = InetAddress.getByName(url);
        s = new Socket(address, port);

        System.out.println("Erfolgreich verbunden mit " +address.getHostName());
        writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        InputStreamReader inreader = new InputStreamReader(s.getInputStream());
        reader = new BufferedReader(inreader);
    }

    public void sendCommand(String command) throws IOException {
        PrintWriter out = new PrintWriter(s.getOutputStream());

        out.println("command");
        out.flush();
    }

    public void displayMenu() throws IOException {
        System.out.println("--[MENU]--");
        System.out.println("-COMMANDS-");
        System.out.println("dir");
        System.out.println("change + directory");
        System.out.println("get + filename");
        System.out.println("disconnect");
        System.out.println("Enter a command: ");

        String command = reader.readLine();

        switch(command) {
            case "dir": ; break;
            case "change": ; break;
            case "get": ; break;
            case "disconnect": disconnect(); break;
        }
    }

    //Implementations
    public void disconnect() throws IOException {
        in.close();
        out.close();
        s.close();
    }
}
