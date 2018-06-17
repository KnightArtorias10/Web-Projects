package EvaluationDatabase;

import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

import java.util.Arrays;
import java.util.List;

public class Database_Manager {

    public void writeToDB(String kurs, String note, String[] plattform, String feedback) {
        DatabaseFacade dbf = new DatabaseFacade();
        EvalEntry entry = new EvalEntry();
        entry.setKurs(kurs);
        entry.setNote(note);
        entry.setPlattform(Arrays.toString(plattform));
        entry.setFeedback(feedback);

        dbf.insert(entry);
    }

    public double readFromDB(String kurs, List<String> feedback) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<EvalEntry> entries = dbf.listAllEntries();
        double average = 0;
        int amount = 0;
        for(EvalEntry e : entries) {
            if(e.getKurs().equals(kurs)) {
                feedback.add(e.getFeedback());
                average = average + Integer.parseInt(e.getNote());
                amount++;
            }
        }
        return average/amount;
    }
}
