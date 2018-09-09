import java.io.IOException;

public class ServerConnectionThread extends Thread {
    private boolean isRunning = false;
    private String request;

    //Server
    private FTP_Server server;

    public ServerConnectionThread(FTP_Server server) {
        this.server = server;
    }

    public void run() {
        isRunning = true;
        System.out.println("Server-thread started.");

        while (isRunning) {
            if (request.startsWith("LIST")) {
                server.list();
            } else if (request.startsWith("RETR")) {
                try {
                    server.retr(parseRequest(5), ".");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (request.startsWith("PASV")) {
                server.pasv();
            } else if (request.startsWith("QUIT")) {
                try {
                    server.quit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopThread() {
        isRunning = false;
    }

    public String parseRequest(int index) {
        return request.substring(index);
    }
}
