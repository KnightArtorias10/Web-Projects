package Guestbook;

import java.util.List;


/**
 * Fassade als einziger Anlaufpunkt f�r die dar�berliegende Applikationsschicht, um auf die Datenbank zuzugreifen
 * @author sonja
 *
 */
public class DatabaseFacade {

	public List<GuestbookEntry> listAllEntries() {
		GuestbookEntryDAO dao = GuestbookEntryDAO.getInstance();
		return dao.loadAll();
	}

	public void insert(GuestbookEntry entry) {
		GuestbookEntryDAO.getInstance().save(entry);
	}
}