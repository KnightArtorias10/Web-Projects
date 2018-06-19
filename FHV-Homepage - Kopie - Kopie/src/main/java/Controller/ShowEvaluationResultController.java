package Controller;


import getEvalEntriesFromDB.ReadEvalEntriesFromDB;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
public class ShowEvaluationResultController {
    private List<String> _courseOptions;
    private String _selectedCourse;
    private List<String> _keepSameList = new LinkedList<String>();
    double _averageValuable = 0;


    public ShowEvaluationResultController() {
        _courseOptions = new ArrayList<>();
        _courseOptions.add("Webapplikationen");
        _courseOptions.add("English: 4: Technical Writing");
        _courseOptions.add("Nutzerzentrierte Softwareentwicklung");
        _courseOptions.add("Objektorientierte Analyse und Design");
        _courseOptions.add("Software und IT-Sicherheit");
    }

    public String showResult() {
        ReadEvalEntriesFromDB readEvalEntriesFromDB = new ReadEvalEntriesFromDB();
        _averageValuable = readEvalEntriesFromDB.readFromDB(_selectedCourse, _keepSameList);
        return "result";
    }



    public List<String> getCourseOptions() {
        return _courseOptions;
    }

    public void setCourseOptions(List<String> courseOptions) {
        _courseOptions = courseOptions;
    }

    public String getSelectedCourse() {
        return _selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        _selectedCourse = selectedCourse;
    }

    public List<String> getKeepSameList() {
        return _keepSameList;
    }

    public void setKeepSameList(List<String> keepSameList) {
        _keepSameList = keepSameList;
    }

    public double getAverageValuable() {
        return _averageValuable;
    }

    public void setAverageValuable(double averageValuable) {
        _averageValuable = averageValuable;
    }
}