package Test;

import Users.DatabaseFacade;
import Users.UserEntry;

import java.util.List;

public class ShowUserEntries {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<UserEntry> userEntries = dbf.listAllEntries();
        for (UserEntry userEntry:userEntries) {
            System.out.println("Firstname: " + userEntry.getFirstName());
            System.out.println("Lastname: " + userEntry.getLastName());
            System.out.println("Username: " + userEntry.getId());
            System.out.println("Password: " + userEntry.getPassword());
            System.out.println("Berechtigung(en): " +  userEntry.getBerechtigungsStufen() + "\n\n");
        }

    }
}
