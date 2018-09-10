package Guestbook;

/**
 * Spezifisches DAO f�r die Entit�t City
 * erbt CRUD-Funktionalit�t vom Guestbook.BaseDAO
 * implementiert als Singleton
 *
 * @author sonja
 *
 */
public class GuestbookEntryDAO extends BaseDAO<GuestbookEntryPOJO, String>{

    private static GuestbookEntryDAO instance;

    public static GuestbookEntryDAO getInstance() {
        if (instance == null) {
            instance = new GuestbookEntryDAO();
        }
        return instance;
    }

    public GuestbookEntryDAO() {
        super(GuestbookEntryPOJO.class);
    }

    /**
     * stellt eine erweiterte Funktionalit�t gegen�ber dem Guestbook.BaseDAO dar
     * @param name
     * @return
     */
}
