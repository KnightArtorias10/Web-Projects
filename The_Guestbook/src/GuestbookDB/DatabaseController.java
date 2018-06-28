package GuestbookDB;

public class DatabaseController {

    public void writeToDB(String name, String comment) {
        DatabaseFacade facade = new DatabaseFacade();
        GuestbookEntry entry = new GuestbookEntry();
        entry.setName(name);
        entry.setComment(comment);

        facade.insert(entry);
    }
}
