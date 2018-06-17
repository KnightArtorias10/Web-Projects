import java.util.Scanner;

public class FTP_ClientThread extends Thread {
    FTP_Client ftpClient;
    Scanner sc;
    private boolean running;

    public FTP_ClientThread() {
        sc = new Scanner(System.in);
        ftpClient = null;
    }

    public FTP_Client getFTPClient() {
        return ftpClient;
    }
    public void setFTPClient(FTP_Client ftpClient) {
        this.ftpClient = ftpClient;
    }

    public void run() {
        running = true;
        while(running = true) {
            System.out.println("Enter a command");
            String command = sc.nextLine();
            try {
                ftpClient.control(command);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        running = false;
    }

    public boolean getRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
