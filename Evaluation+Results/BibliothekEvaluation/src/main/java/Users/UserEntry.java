package Users;

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
@Table (name="users")
public class UserEntry {

    private String _id;
    private String _password;
    private String _firstName;
    private String _lastName;
    private String _berechtigungsStufen;

    /**
     * Im Falle einer einfachen ID muss das entsprechende Attribut mit der Annotation @Id versehen werden
     * @return
     */
    @Id
    @Column (name="userid")
    public String getId() {
        return _id;
    }
    public void setId(String id) {
        _id = id;
    }

    @Column (name="password")
    public String getPassword() {
        return _password;
    }
    public void setPassword(String password) {
        _password = password;
    }

    @Column (name = "firstname")
    public String getFirstName() {
        return _firstName;
    }
    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    @Column (name = "lastname")
    public String getLastName() {
        return _lastName;
    }
    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    @Column (name = "berechtigungsstufe")
    public String getBerechtigungsStufen() {
        return _berechtigungsStufen;
    }

    public void setBerechtigungsStufen(String berechtigungsStufen) {
        _berechtigungsStufen = berechtigungsStufen;
    }
}
