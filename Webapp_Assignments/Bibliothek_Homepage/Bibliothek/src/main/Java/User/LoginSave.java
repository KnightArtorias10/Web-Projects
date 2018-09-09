package User;

public class LoginSave {
    private String userID;
    private String firstName;
    private String lastName;
    private String password;

    public void setUser(String userID, String password, String firstName, String lastName) {
        UserEntry entry = new UserEntry();
        DatabaseFacade dbf = new DatabaseFacade();
        entry.setUserID(userID);
        entry.setPassword(password);
        entry.setFirstName(firstName);
        entry.setLastName(lastName);
        String berechtigungen = "";
        dbf.insert(entry);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
}