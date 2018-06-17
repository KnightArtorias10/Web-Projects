package Test;

import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

import java.util.List;

public class ShowEvaluationEntries {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<EvalEntry> evalEntries = dbf.listAllEntries();
        for (EvalEntry userEntry:evalEntries) {
            System.out.println("Kurs: " + userEntry.getKurs());
            System.out.println("Note: " + userEntry.getNote());
            System.out.println("Plattform(en): " + userEntry.getPlattform());
            System.out.println("Feedback: " + userEntry.getFeedback() + "\n\n");
        }

    }
}
