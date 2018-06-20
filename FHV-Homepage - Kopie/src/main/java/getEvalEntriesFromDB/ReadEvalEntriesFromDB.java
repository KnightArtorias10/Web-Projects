package getEvalEntriesFromDB;

import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

import java.util.List;

public class ReadEvalEntriesFromDB {

    public double readFromDB(String selectedCourse, List<String> keepSameList) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<EvalEntry> guestbookEntries = dbf.listAllEntries();
        double averageValuable = 0;
        int amount = 0;
        for (EvalEntry entry:guestbookEntries) {
            if (entry.getCourse().equals(selectedCourse)) {
                keepSameList.add(entry.getKeepSame());
                averageValuable+=Integer.parseInt(entry.getValuable());
                amount++;
            }
        }
        return averageValuable/amount;
    }

}
