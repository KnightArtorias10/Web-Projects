package Beans;

import EvaluationDB.EvalEntry;
import GuestbookDB.DatabaseFacade;

import java.util.List;

public class EntryReader {

    public double readFromDB(String selectedMedium, List<EvalEntry> evalList) {
        EvaluationDB.DatabaseFacade dbf = new EvaluationDB.DatabaseFacade();
        List<EvalEntry> entries = dbf.listAllEntries();
        double averageRating = 0;
        int amount = 0;
        for (EvalEntry entry: entries) {
            if (entry.getMedium().equals(selectedMedium)) {
                evalList.add(entry);
                averageRating+=Integer.parseInt(entry.getRating());
                amount++;
            }
        }
        return averageRating/amount;
    }
}
