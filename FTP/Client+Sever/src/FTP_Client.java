import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class FTP_Client {
    InputStream in;
    OutputStream out;
    BufferedReader reader;
    BufferedWriter writer;
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
            writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            InputStreamReader inreader = new InputStreamReader(s.getInputStream());
            reader = new BufferedReader(inreader);
    }

    /**
     * Closes connection and the streams
     */
    public void disconnect() throws IOException {
        send("quit");

        try {
            reader.close();
            writer.close();
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

        while ((response = reader.readLine()) != null) {
            System.out.println(reader.readLine());
        }
    }

    public void cd(String direction) throws IOException {
        send("cd " +direction);
    }

    public void get(String fileName) throws IOException {
        send("get " +fileName);
        String remoteFile = fileName;
        File downloadFile = new File("D:/Downloads/" +fileName);
        OutputStream fileout = new BufferedOutputStream(new FileOutputStream(downloadFile));
        InputStream inputStream = s.getInputStream();
        byte[] bytesArray = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
            fileout.write(bytesArray, 0, bytesRead);
        }

            System.out.println("File " +fileName +" has been downloaded successfully.");
        fileout.close();
        inputStream.close();
    }

    /**
     * Sends a command to the server
     * @param command
     */
    public void send(String command) throws IOException {
        for(int i = 0; i < command.length(); i++) {
            writer.write(command.charAt(i)); //The command char for char
        }
        writer.write(System.lineSeparator()); //Enter
        writer.flush(); //Refresh the writer
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
         //   case "connect": System.writer.println("Error: Please enter an URL to connect with"); break;
            case "disconnect": disconnect(); break;
            case "dir": dir(); break;
            case "cd": System.out.println("Error: Please enter the desired direction"); break;
        }
    }
}
