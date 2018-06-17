public class MySingleton {
    private static MySingleton instance; //Referenz auf sich selber

    private static MySingleton getInstance() {
        if(instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}