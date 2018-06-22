package GuestbookDB;


import EvaluationDB.GuestbookEntry;

import java.util.List;


/**
 * Fassade als einziger Anlaufpunkt f�r die dar�berliegende Applikationsschicht, um auf die Datenbank zuzugreifen
 * @author sonja
 *
 */
public class DatabaseFacade {

    public List<GuestbookEntry> listAllEntries() {
        GuestbookDAO dao = GuestbookDAO.getInstance();
        return dao.loadAll();
    }

    public void insert(GuestbookEntry entry) {
        GuestbookDAO.getInstance().save(entry);
    }
}