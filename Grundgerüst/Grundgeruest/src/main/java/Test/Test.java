package Test;

import Guestbook.DatabaseFacade;
import Guestbook.GuestbookEntry;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<GuestbookEntry> guestbookEntries = dbf.listAllEntries();
        for(GuestbookEntry entry:guestbookEntries) {
            System.out.println(entry.getName());
        }
    }
}
