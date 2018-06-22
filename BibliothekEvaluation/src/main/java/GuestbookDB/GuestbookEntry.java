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
@Table (name="GUESTBOOKENTRY")
public class GuestbookEntry {
    private int id;
    private String email;
    private String comment;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    @Column (name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Column (name="comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
