import java.io.*;
import java.net.*;

public class FtpServer {
        static String hostName = "MyFTP-Server";
        static int port = 21;
        static ServerSocket server = null;

        public static void main(String[] args) {
            try {
                server = new ServerSocket(21);
                acceptClients();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void acceptClients() {
            while(true) {
                try {
                    Socket socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
