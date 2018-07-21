package GuestbookFinished;

/**
 * Spezifisches DAO f�r die Entit�t City
 * erbt CRUD-Funktionalit�t vom EvaluationDB.EvaluationDB.BaseDAO
 * implementiert als Singleton
 *
 * @author sonja
 *
 */
public class GuestbookDAO extends BaseDAO<GuestbookEntry, String> {

    private static GuestbookDAO instance;

    public static GuestbookDAO getInstance() {
        if (instance == null) {
            instance = new GuestbookDAO();
        }
        return instance;
    }

    public GuestbookDAO() {
        super(GuestbookEntry.class);
    }

    /**
     * stellt eine erweiterte Funktionalit�t gegen�ber dem EvaluationDB.EvaluationDB.BaseDAO dar
     * @param name
     * @return
     */
}
