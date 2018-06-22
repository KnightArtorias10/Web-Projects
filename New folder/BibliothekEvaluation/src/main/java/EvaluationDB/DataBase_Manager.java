package EvaluationDB;

import java.util.Arrays;
import java.util.List;

public class DataBase_Manager {

    public void writeToDB(String name, String medium, String title, String rating, String[] audience, String comment) {
        DatabaseFacade dbf = new DatabaseFacade();
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
