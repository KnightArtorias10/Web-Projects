package mvc;

import Users.DatabaseFacade;
import Users.UserEntry;

public class LoginSave {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String[] berechtigungsStufen;

    public void setUser(String id, String password, String firstName, String lastName, String[] berechtigungsStufen) {
        UserEntry entry = new UserEntry();
        DatabaseFacade dbf = new DatabaseFacade();
        entry.setId(id);
        entry.setPassword(password);
        entry.setFirstName(firstName);
        entry.setLastName(lastName);
        String berechtigungen = "";
        for(int i = 0; i < berechtigungsStufen.length;i++) {
            if (i == 0) {
                berechtigungen = berechtigungsStufen[i];
            }
            else {
                berechtigungen = berechtigungen + ", " + berechtigungsStufen[i];
            }
        }
        entry.setBerechtigungsStufen(berechtigungen);
        dbf.insert(entry);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String[] getBerechtigungsStufen() {
        return berechtigungsStufen;
    }

    public void setBerechtigungsStufen(String[] berechtigungsStufen) {
        this.berechtigungsStufen = berechtigungsStufen;
    }
}