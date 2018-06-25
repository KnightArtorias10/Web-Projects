package Beans;

import EvaluationDB.EvalEntry;
import Users.UserEntry;

import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
public class resultController {
    private List<EvalEntry> evalList = new LinkedList<EvalEntry>();
    private List<String> commentList = new LinkedList<String>();
    private String selectedMedium;
    private double averageRating = 0;

    public resultController() {

    }

    public String showResults() {
        EntryReader reader = new EntryReader();
        averageRating = reader.readFromDB(selectedMedium, evalList);
        return "ShowResults";
    }

    public List<EvalEntry> getEvalList() { return evalList; }
    public List<String> getCommentList() {
        return commentList;
    }

    public String getSelectedMedium() {
        return selectedMedium;
    }

    public void setSelectedMedium(String selectedMedium) {
        this.selectedMedium = selectedMedium;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
