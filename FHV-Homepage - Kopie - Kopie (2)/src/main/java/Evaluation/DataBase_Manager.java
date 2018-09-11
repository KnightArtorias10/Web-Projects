package Evaluation;

import java.util.Arrays;

public class DataBase_Manager {

    public void writeToDB(String name, String medium, String title, String rating, String[] audience, String comment) {
        EvalDatabaseFacade dbf = new EvalDatabaseFacade();
        EvalEntry entry = new EvalEntry();
        entry.setName(name);
        entry.setMedium(medium);
        entry.setTitle(title);
        entry.setRating(rating);
        entry.setAudience(Arrays.toString(audience));
        entry.setComment(comment);

        dbf.insert(entry);
    }
}
