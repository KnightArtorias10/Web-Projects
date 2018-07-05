import java.util.Scanner;

public class FTP_ClientThread implements Runnable {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String command;
        System.out.println("Execute a command: ");
        command = sc.nextLine();

        switch(command) {
            case"PWD": printDirectory(); break;
            case "CWD":
                System.out.println("Which directory? ");
                String directory = sc.nextLine();
                changeDirectory(directory);
                break;
            case "EXIT": disconnect(); break;
        }


    }

    public String printDirectory() {
        return "PWD";
    }

    public String changeDirectory(String dir) {
        return "CWD " +dir;
    }

    public String disconnect() {
        return "EXIT";
    }
}
