package Users;

import java.util.List;


/**
 * Fassade als einziger Anlaufpunkt f�r die dar�berliegende Applikationsschicht, um auf die Datenbank zuzugreifen
 * @author sonja
 *
 */
public class DatabaseFacade {

	public List<UserEntry> listAllEntries() {
		UserEntryDAO dao = UserEntryDAO.getInstance();
		return dao.loadAll();
	}

	public void insert(UserEntry entry) {
		UserEntryDAO.getInstance().save(entry);
	}
}