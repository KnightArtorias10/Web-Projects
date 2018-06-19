package SaveToDatabase;

import EvaluationDB.DatabaseFacade;
import EvaluationDB.EvalEntry;

public class SaveEvaluation {

    public void writeToDB(String course,int valuable,String[] usedPlattforms,String keepSame, String change) {
        EvalEntry entry = new EvalEntry();
        DatabaseFacade dbf = new DatabaseFacade();
        entry.setCourse(course);
        entry.setValuable(Integer.toString(valuable));
        entry.setKeepSame(keepSame);
        entry.setChange(change);
        String plattforms = "";
        for(int i = 0; i < usedPlattforms.length;i++) {
            if (i == 0) {
                plattforms = usedPlattforms[i];
            }
            else {
                plattforms = plattforms + ", " + usedPlattforms[i];
            }
        }
        entry.setPlattforms(plattforms);
        dbf.insert(entry);
    }
}
