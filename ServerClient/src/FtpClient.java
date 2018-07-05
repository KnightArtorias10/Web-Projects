import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.Socket;

public class FtpClient {
    private Socket s;
    private String username, password;
    private BufferedReader reader;
    private PrintWriter writer;

    //Constructor
    public FtpClient() {

    }

    /**
     * Starts a TCP-Connection with a host
     * @param url
     */
    public void open(String url) {
        try {
            s = new Socket(url, 21);

            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writer = new PrintWriter(s.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void connect(String host) throws IOException {
        connect(host, 21);
    }
    
    public synchronized void connect(String host, int port) throws IOException {
        connect(host, port, "anonymous", "anonymous");
    }

    /**
     * Disconnects from the host
     */
    public void quit()throws IOException {
        if(s.isConnected()) {
            reader.close();
            writer.close();
            s.close();
            System.out.println("Disconnected from the server.");
        }
    }

    /**
     * Prints the host's current directory
     */
    public String dir() throws IOException {
        sendCommand("PWD");
        String dir = null;
        String response = reader.readLine();
        if (response.startsWith("257 ")) {
            int firstQuote = response.indexOf('\"');
            int secondQuote = response.indexOf('\"', firstQuote + 1);
            if (secondQuote > 0) {
                dir = response.substring(firstQuote + 1, secondQuote);
            }
        }
        return dir;
    }

    /**
     * Change the current working direction
     * @param dir
     */
    public synchronized boolean cwd(String dir) throws IOException {
        sendCommand("CWD " + dir);
        String response = reader.readLine();
        return (response.startsWith("250 "));
    }

    /**
     * Download a file from the host
     * @param file
     */
    public void get(String file) {

    }

    public String sendCommand(String cmd) throws IOException {
        writer.println(cmd);
        String response = reader.readLine();
        return response;
    }
}
