import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FTP_Server {
    //Login
    private String username = "coolerhacker";
    private String password = "123";


    //Server
    private int port = 9000;
    private boolean isPassive;
    private ServerSocket ss;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean running;

    //Thread
    private ServerConnectionThread thread;

    public FTP_Server() {
        System.out.println("Initializing server...");
        running = true;
        isPassive = false;

        thread = new ServerConnectionThread(this);
        try {
            ss = new ServerSocket(port);
            Socket socket = ss.accept();
            System.out.println("Verbindung mit Client wurde hergestellt.");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            readRequest();
            sendResponse("220: FTP-Server is ready.");
            sendResponse("Enter your username: ");
            readRequest();
            if(readRequest().equals("USER " +username)) {
                sendResponse("231: Password required for " +username);

                if(readRequest().equals("PASS " +password)) {
                    sendResponse("230: User " +username +" logged in");
                } else {
                    sendResponse("530: Login incorrect.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void list() {
        if(!isPassive) {
            sendResponse("227: Entering passive mode.");
            isPassive = true;
            list();
        } else {
            StringBuilder builder = new StringBuilder();
            File currentDir = new File(".");
            File[] fileList = currentDir.listFiles();
            for(File f : fileList) {
                builder.append(f.getName());
                builder.append("\n");
            }
            sendResponse(builder.toString());
        }
    }

    //Request passive mode
    public void pasv(){
        if(isPassive == false) {
            isPassive = true;
        }
    }

    //Copy a file from a server
    public void retr(String fileName, String destination) throws IOException {
        if(!isPassive) {
            //send error message
        } else {
            File currentDir = new File(".");
            File[] fileList = currentDir.listFiles();
            for(File f : fileList) {
                if(f.getName().equals(fileName)) {
                    File retrFile = new File(fileName);
                    FileInputStream fis = new FileInputStream(f);
                    FileOutputStream fos = new FileOutputStream(destination);
                }
            }
        }
    }

    public void quit() throws IOException {
        sendResponse("221: Goodbye.");
        writer.close();
        reader.close();
        ss.close();
        thread.stopThread();
    }

    //Read request from client
    public String readRequest() throws IOException {
        String request;
        StringBuilder sb = new StringBuilder();
        while ((request = reader.readLine()) != null) {
            System.out.println(request);
            sb.append(request);
            break;
        }
        return String.valueOf(sb);
    }

    //Send response to client
    public void sendResponse(String response) {
            writer.write(response + "\r\n");
            writer.flush();
    }
}
