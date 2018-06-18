package Test;


import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();
        List<EvalEntry> evalEntries = dbf.listAllEntries();
        for(EvalEntry entry:evalEntries) {
            System.out.println(entry.getName());
            System.out.println(entry.getMedium());
            System.out.println(entry.getRating());
            System.out.println(entry.getTitle());
            System.out.println(entry.getAudience());
            System.out.println(entry.getComment());
        }
    }
}
