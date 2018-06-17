package EvaluationDB;


import java.util.List;


/**
 * Fassade als einziger Anlaufpunkt f�r die dar�berliegende Applikationsschicht, um auf die Datenbank zuzugreifen
 * @author sonja
 *
 */
public class DatabaseFacade {

	public List<EvalEntry> listAllEntries() {
		EvaluationDAO dao = EvaluationDAO.getInstance();
		return dao.loadAll();
	}

	public void insert(EvalEntry entry) {
		EvaluationDAO.getInstance().save(entry);
	}
}