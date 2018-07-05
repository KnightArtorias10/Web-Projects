import java.io.*;
import java.net.Socket;

public class FTP_Client {
    private static int port;
    private static String host;

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 21);

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);

            FTP_ClientThread thread = new FTP_ClientThread();
            thread.run();

            String str = "Test";
            pw.println(str);

            while ((str = br.readLine()) != null) {
                System.out.println(str);
                pw.println("end");

                if (str.equals("end"))
                    break;
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}