package Test;


import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<EvalEntry> evalEntries = dbf.listAllEntries();
        for(EvalEntry entry:evalEntries) {
            System.out.println(entry);
        }
    }
}
