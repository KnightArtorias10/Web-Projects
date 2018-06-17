package EvaluationDB;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entität für die Tabelle Stadt mit entsprechenden Annotationen
 *
 * @author sonja
 *
 */
@Entity
@Table (name="EVALUATION")
public class EvalEntry {

    private int _id;
    private String _kurs;
    private String _note;
    private String _plattform;
    private String _feedback;

    /**
     * Im Falle einer einfachen ID muss das entsprechende Attribut mit der Annotation @Id versehen werden
     * @return
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    public int getID() { return _id; }
    public void setID(int id) { _id = id; }

    @Column (name="kurs")
    public String getKurs() {
        return _kurs;
    }
    public void setKurs(String kurs) {
        _kurs = kurs;
    }

    @Column (name = "note")
    public String getNote() {
        return _note;
    }
    public void setNote(String note) {
        _note = note;
    }

    @Column (name="plattform")
    public String getPlattform() {
        return _plattform;
    }
    public void setPlattform(String plattform) {
        _plattform = plattform;
    }

    @Column (name = "feedback")
    public String getFeedback() {
        return _feedback;
    }
    public void setFeedback(String feedback) {
        _feedback = feedback;
    }
}
