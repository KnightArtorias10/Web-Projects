package Beans;

import EvaluationDB.DataBase_Manager;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class EvaluationBean {
    private String name;
    private String medium;
    private String title;
    private String rating;
    private String[] audience;
    private String comment;

    public EvaluationBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String[] getAudience() {
        return audience;
    }

    public void setAudience(String[] audience) {
        this.audience = audience;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String writeToDB() {
        DataBase_Manager dbm = new DataBase_Manager();
        dbm.writeToDB(name, medium, title, rating, audience, comment);
        return "Success";
    }
}
