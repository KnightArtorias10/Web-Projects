package GuestbookDB;

import EvaluationDB.GuestbookEntry;

public class DatabaseController {

    public void writeToDB(String email, String comment) {
        DatabaseFacade facade = new DatabaseFacade();
        GuestbookEntry entry = new GuestbookEntry();
        entry.setEmail(email);
        entry.setComment(comment);

        facade.insert(entry);
    }
}
