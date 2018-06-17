public class Main {
    public static void main(String[] args) throws Exception {
        FTP_Client client = new FTP_Client();

        //FTP Server
        client.connect("ftp.informatik.rwth-aachen.de");
        client.dir();
    }
}
