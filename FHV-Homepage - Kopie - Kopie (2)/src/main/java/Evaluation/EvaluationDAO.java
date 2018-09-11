package Evaluation;

/**
 * Spezifisches DAO f�r die Entit�t City
 * erbt CRUD-Funktionalit�t vom EvaluationDB.EvaluationDB.BaseDAO
 * implementiert als Singleton
 *
 * @author sonja
 *
 */
public class EvaluationDAO extends EvalBaseDAO<EvaluationentryEntity, String> {

    private static EvaluationDAO instance;

    public static EvaluationDAO getInstance() {
        if (instance == null) {
            instance = new EvaluationDAO();
        }
        return instance;
    }

    public EvaluationDAO() {
        super(EvaluationentryEntity.class);
    }

    /**
     * stellt eine erweiterte Funktionalit�t gegen�ber dem EvaluationDB.EvaluationDB.BaseDAO dar
     * @param name
     * @return
     */
}
