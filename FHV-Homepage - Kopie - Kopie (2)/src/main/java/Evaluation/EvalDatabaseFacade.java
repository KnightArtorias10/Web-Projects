package Evaluation;

import java.util.List;

public class EvalDatabaseFacade {
        public List<EvaluationentryEntity> listAllEntries() {
            EvaluationDAO dao = EvaluationDAO.getInstance();
            return dao.loadAll();
        }

        public void insert(EvalEntry entry) {
            EvaluationDAO.getInstance().save(entry);
        }
    }