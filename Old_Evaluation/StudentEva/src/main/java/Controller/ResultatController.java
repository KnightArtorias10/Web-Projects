package Controller;

import EvaluationDatabase.Database_Manager;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ResultatController {
    private String kurs;
    private List<String> feedback = new ArrayList<String>();
    private double average;

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }

    public double getAverage() {
        return average;
    }
    public String seeResults() {

        Database_Manager dbm = new Database_Manager();
        average = dbm.readFromDB(kurs, feedback);
        return "seeResults";
    }
}
