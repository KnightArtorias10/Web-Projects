package Controller;

import SaveToDatabase.SaveEvaluation;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class SaveEvaluationController {

    private SaveEvaluation _saveEvaluation = new SaveEvaluation();
    private String _course;
    private List<String> _courseOptions;
    private int _valuable;
    private List<Integer> _valuableOptions;
    private String[] _usedPlattforms;
    private List<String> _usedPlattformsOptions;
    private String _keepSame;
    private String _change;

    public SaveEvaluationController() {
        _courseOptions = new ArrayList<>();
        _courseOptions.add("Webapplikationen");
        _courseOptions.add("English: 4: Technical Writing");
        _courseOptions.add("Nutzerzentrierte Softwareentwicklung");
        _courseOptions.add("Objektorientierte Analyse und Design");
        _courseOptions.add("Software und IT-Sicherheit");
        _valuableOptions = new ArrayList<>();
        _valuableOptions.add(1);
        _valuableOptions.add(2);
        _valuableOptions.add(3);
        _valuableOptions.add(4);
        _valuableOptions.add(5);
        _usedPlattformsOptions = new ArrayList<>();
        _usedPlattformsOptions.add("MS Windows");
        _usedPlattformsOptions.add("Linux");
        _usedPlattformsOptions.add("Mac");
        _usedPlattformsOptions.add("UNIX");
        _usedPlattformsOptions.add("sonstige");
    }

    public String writeToDB() {
        _saveEvaluation.writeToDB(_course,_valuable,_usedPlattforms,_keepSame, _change);
        return "student_response";
    }

    public String getCourse() {
        return _course;
    }

    public void setCourse(String course) {
        _course = course;
    }

    public List<String> getCourseOptions() {
        return _courseOptions;
    }

    public int getValuable() {
        return _valuable;
    }

    public void setValuable(int valuable) {
        _valuable = valuable;
    }

    public List<Integer> getValuableOptions() {
        return _valuableOptions;
    }
    public String[] getUsedPlattforms() {
        return _usedPlattforms;
    }

    public void setUsedPlattforms(String[] usedPlattforms) {
        _usedPlattforms = usedPlattforms;
    }

    public List<String> getUsedPlattformsOptions() {
        return _usedPlattformsOptions;
    }

    public String getKeepSame() {
        return _keepSame;
    }

    public void setKeepSame(String keepSame) {
        _keepSame = keepSame;
    }

    public String getChange() {
        return _change;
    }

    public void setChange(String change) {
        _change = change;
    }
}
