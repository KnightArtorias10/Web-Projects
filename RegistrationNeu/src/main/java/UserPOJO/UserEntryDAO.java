package UserPOJO;

/**
 * Spezifisches DAO f�r die Entit�t City
 * erbt CRUD-Funktionalit�t vom Guestbook.BaseDAO
 * implementiert als Singleton
 *
 * @author sonja
 *
 */
public class UserEntryDAO extends BaseDAO<UserEntry, String> {

    private static UserEntryDAO instance;

    public static UserEntryDAO getInstance() {
        if (instance == null) {
            instance = new UserEntryDAO();
        }
        return instance;
    }

    public UserEntryDAO() {
        super(UserEntry.class);
    }

    /**
     * stellt eine erweiterte Funktionalit�t gegen�ber dem Guestbook.BaseDAO dar
     * @param name
     * @return
     */
}
