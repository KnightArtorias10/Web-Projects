package Evaluation;


import java.util.List;

public class EntryReader {

    public double readFromDB(String selectedMedium, List<String> commentList) {
        EvalDatabaseFacade dbf = new EvalDatabaseFacade();
        List<EvaluationentryEntity> entries = dbf.listAllEntries();
        double averageRating = 0;
        int amount = 0;
        for (EvaluationentryEntity entry: entries) {
            if (entry.getMedium().equals(selectedMedium)) {
                commentList.add(entry.getComment());
                averageRating+=Integer.parseInt(entry.getRating());
                amount++;
            }
        }
        return averageRating/amount;
    }
}