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
@Table (name="evaluations")
public class EvalEntry {
    private int _evalId;
    private String _course;
    private String _valuable;
    private String _plattforms;
    private String _keepSame;
    private String _change;


    /**
     * Im Falle einer einfachen ID muss das entsprechende Attribut mit der Annotation @Id versehen werden
     * @return
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="evalid")
    public int getEvalId() {
        return _evalId;
    }

    public void setEvalId(int evalId) {
        _evalId = evalId;
    }

    @Column (name="course")
    public String getCourse() {
        return _course;
    }
    public void setCourse(String course) {
        _course = course;
    }

    @Column (name = "valuable")
    public String getValuable() {
        return _valuable;
    }
    public void setValuable(String valuable) {
        _valuable = valuable;
    }

    @Column (name="plattforms")
    public String getPlattforms() {
        return _plattforms;
    }
    public void setPlattforms(String plattforms) {
        _plattforms = plattforms;
    }

    @Column (name = "keepsame")
    public String getKeepSame() {
        return _keepSame;
    }
    public void setKeepSame(String keepSame) {
        _keepSame = keepSame;
    }

    @Column (name = "change")
    public String getChange() {
        return _change;
    }

    public void setChange(String change) {
        _change = change;
    }
}
