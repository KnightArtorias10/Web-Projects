package beans;

public class Login {

    public Login() {}
    //* Property numberOfVisitors.
    private int numberOfVisitors;
    //* Getter für Property numberOfVisitors.
    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }
    //* Setter für Property numberOfVisitors.
    public void setNumberOfVisitors(int numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
    }
    //* Zählt einen Besucher.
    public void countVisitor() {
        numberOfVisitors++;
    }
}
