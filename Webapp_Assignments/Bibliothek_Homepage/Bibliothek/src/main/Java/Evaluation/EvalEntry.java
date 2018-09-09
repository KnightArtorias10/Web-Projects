package Evaluation;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entität für die Tabelle Stadt mit entsprechenden Annotationen
 *
 * @author sonja
 *
 */
@Entity
@Table(name="EVALUATIONENTRY")
public class EvalEntry {

    private int _id;
    private String name;
    private String medium;
    private String title;
    private String rating;
    private String audience;
    private String comment;

    /**
     * Im Falle einer einfachen ID muss das entsprechende Attribut mit der Annotation @Id versehen werden
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public int getID() {
        return _id;
    }

    public void setID(int id) {
        _id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="medium")
    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Column(name="audience")
    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    @Column(name="comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}