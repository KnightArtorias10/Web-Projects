package Beans;

import Evaluation.EntryReader;

import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
public class resultController {
    private List<String> commentList = new LinkedList<String>();
    private String selectedMedium;
    private double averageRating = 0;

    public resultController() {

    }

    public String showResults() {
        EntryReader reader = new EntryReader();
        averageRating = reader.readFromDB(selectedMedium, commentList);
        return "ShowResults";
    }

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
