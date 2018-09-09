import java.io.*;
import java.net.Socket;

public class FTP_Client {
    private Socket s;
    private String host;
    private int port = 21;
    private String username = "PLEASE ENTER YOUR USERNAME";
    private String password = "PLEASE ENTER YOUR PW";
    private BufferedReader reader;
    private PrintWriter writer;

    //Passive-mode
    private String ip;
    private int ipPort;

    public FTP_Client() {

    }

    //Connect with a server
    //220, 331, 230
    //220: You are connected
    //331: User correct
    //230: password correct
    public void open(String host) throws IOException {
        s = new Socket(host, port);

        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

        System.out.println("Verbindung mit Host " +host +" wurde hergestellt.");
        if (readServerResponse().contains("220")) {
            sendCommand("USER " + username);

        }

        if (readServerResponse().contains("331")) {
            sendCommand("PASS " + password);
            readServerResponse();
        }
    }

    //Download a file
    public void get(String fileName) throws IOException {
        Socket client = enterPassiveMode();
        sendCommand("RETR " +fileName);

        BufferedInputStream in = new BufferedInputStream(client.getInputStream());
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("C:/Users/HP EliteBook 8440p/Desktop/File.txt"));

        int count;
        while ((count = in.read())!= -1) {
            fos.write(count);
        }
        in.close();
        fos.close();
        client.close();
    }

    //Print current working directory
    public void dir() throws IOException {
        Socket client = enterPassiveMode();
        sendCommand("LIST");
        readStr(client);
        client.close();
    }

    private String readStr(Socket client) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String answer;
        StringBuilder sb = new StringBuilder();
        while ((answer = reader.readLine()) != null) {
            System.out.println(answer);
            sb.append(answer);
        }
        reader.close();
        return String.valueOf(sb);
    }

    //Change the current directory
    public void cd(String directory) throws IOException {
        sendCommand("CWD " + directory);
        readServerResponse();
    }

    //Disconnects from the server
    public void quit() throws IOException {
        sendCommand("QUIT");
        readServerResponse();
    }

    //Enter passive-mode
    public Socket enterPassiveMode() throws IOException {
        sendCommand("PASV");
        parseResponse(readServerResponse());
        Socket socket = new Socket(ip, ipPort);

        return socket;
    }

    public void sendCommand(String command) {
        if (s != null) {
            writer.write(command + "\r\n");
            writer.flush();
        }
    }

    public String readServerResponse() throws IOException {
        String answer;
        StringBuilder sb = new StringBuilder();
        while ((answer = reader.readLine()) != null) {
            System.out.println(answer);
            sb.append(answer);
            break;
        }
        return String.valueOf(sb);
    }

    //Read response and create ip + port
    public void parseResponse(String response) {
        int first = response.indexOf("(") + 1;
        int last = response.indexOf(")", first);

        String str = response.substring(first, last);
        String[] strArray = str.split(",");
        StringBuilder sb = new StringBuilder();

        sb.append(strArray[0]);
        sb.append(".");
        sb.append(strArray[1]);
        sb.append(".");
        sb.append(strArray[2]);
        sb.append(".");
        sb.append(strArray[3]);
        ip = sb.toString();

        StringBuilder sbPort = new StringBuilder();
        int num1 = Integer.parseInt(strArray[4]);
        int num2 = Integer.parseInt(strArray[5]);

        ipPort = num1 * 256 + num2;
    }

}