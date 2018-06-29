public class Main {
    public static void main(String[] args) throws Exception {
        FTP_Client client = new FTP_Client();

        //FTP Server
        client.connect("speedtest.tele2.net"); //username: anonymous pw: anything goes
        client.dir();
    }
}
