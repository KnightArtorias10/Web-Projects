package Guestbook;

import java.util.List;


/**
 * Fassade als einziger Anlaufpunkt f�r die dar�berliegende Applikationsschicht, um auf die Datenbank zuzugreifen
 * @author sonja
 *
 */
public class DatabaseFacade {

    public List<GuestbookEntryPOJO> listAllEntries() {
        GuestbookEntryDAO dao = GuestbookEntryDAO.getInstance();
        return dao.loadAll();
    }

    public void insert(GuestbookEntryPOJO entry) {
        GuestbookEntryDAO.getInstance().save(entry);
    }
}