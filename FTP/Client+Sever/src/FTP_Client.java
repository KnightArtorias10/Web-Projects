import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FTP_Client {
    BufferedReader in;
    BufferedWriter out;
    Socket s;
    static int port = 21;

    //Scanner
    Scanner scanner;

    //Thread
    FTP_ClientThread thread;

    public FTP_Client() {
        scanner = new Scanner(System.in);
        thread = new FTP_ClientThread();
        thread.setFTPClient(this);
       // thread.run();
    }

    /**
     * Connects to a server and initializes the streams and the socket
     * @param url
     */
    public void connect(String url) throws Exception {
        System.out.println("Verbindung wird hergestellt...");
            InetAddress address = InetAddress.getByName(url);
            s = new Socket(address, port);

        System.out.println("Erfolgreich verbunden mit " +address.getHostName());
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            InputStreamReader inreader = new InputStreamReader(s.getInputStream());
            in = new BufferedReader(inreader);
    }

    /**
     * Closes connection and the streams
     */
    public void disconnect() throws IOException {
        send("quit");

        try {
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread.setRunning(false);
    }

    /**
     * Prints the current working direction
     */
    public void dir() throws IOException {
        send("dir");
        String response;

        while ((response = in.readLine()) != null) {
            System.out.println(in.readLine());
        }
    }

    public void cd(String direction) throws IOException {
        send("cd " +direction);
    }

    public void get(String fileName) throws IOException {
        send("get " +fileName);
    }

    /**
     * Sends a command to the server
     * @param command
     */
    public void send(String command) throws IOException {
        for(int i = 0; i < command.length(); i++) {
            out.write(command.charAt(i)); //The command char for char
        }
        out.write(System.lineSeparator()); //Enter
        out.flush(); //Refresh the writer
    }

    public void control(String command, String str) throws Exception {
        switch(command) {
            case "connect": if(!str.equals("") || !str.equals(null)) { connect(str); } else {
                System.out.println("Error: Please enter an URL"); } break;
            case "disconnect": disconnect(); break;
            case "dir": dir(); break;
            case "cd": cd(str); break;
        }
    }

    public void control(String command) throws Exception {
        switch(command) {
         //   case "connect": System.out.println("Error: Please enter an URL to connect with"); break;
            case "disconnect": disconnect(); break;
            case "dir": dir(); break;
            case "cd": System.out.println("Error: Please enter the desired direction"); break;
        }
    }
}
