package Guestbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entität für die Tabelle Stadt mit entsprechenden Annotationen
 *
 * @author sonja
 *
 */
@Entity
@Table (name="guestbook")
public class GuestbookEntry {

    private String _name;
    private String _email;
    private String _message;
    private String _timestamp;

    /**
     * Im Falle einer einfachen ID muss das entsprechende Attribut mit der Annotation @Id versehen werden
     * @return
     */
    @Id
    @Column (name="timestamp")
    public String getTimestamp() {
        return _timestamp;
    }
    public void setTimestamp(String timestamp) {
        _timestamp = timestamp;
    }

    @Column (name="name")
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    @Column (name = "email")
    public String getEmail() {
        return _email;
    }
    public void setEmail(String email) {
        _email = email;
    }

    @Column (name = "message")
    public String getMessage() {
        return _message;
    }
    public void setMessage(String message) {
       _message = message;
    }
}
