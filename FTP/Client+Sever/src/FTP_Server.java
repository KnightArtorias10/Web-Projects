import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class FTP_Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    private List<File> directories;
    private boolean passive;

    public FTP_Server() throws IOException {
        passive = false;
        directories = new ArrayList<File>();

        try {
            serverSocket = new ServerSocket(21);
        } catch (IOException e) {
            e.printStackTrace();
        }

        clientSocket = serverSocket.accept();
    }

    public void quit() throws IOException {
        serverSocket.close();
        clientSocket.close();
    }

    public List getList() {
        return directories;
    }

    public boolean getPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }
}
