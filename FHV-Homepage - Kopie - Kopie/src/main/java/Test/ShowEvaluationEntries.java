package Test;

import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

import java.util.List;

public class ShowEvaluationEntries {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<EvalEntry> evalEntries = dbf.listAllEntries();
        for (EvalEntry userEntry:evalEntries) {
            System.out.println("Course: " + userEntry.getCourse());
            System.out.println("Valuable: " + userEntry.getValuable());
            System.out.println("Plattformen: " + userEntry.getPlattforms());
            System.out.println("Beibehalten: " + userEntry.getKeepSame());
            System.out.println("Aendern: " + userEntry.getChange() + "\n\n");
        }
    }
}
