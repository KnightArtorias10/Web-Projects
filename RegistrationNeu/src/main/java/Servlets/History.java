package Servlets;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class History implements java.io.Serializable {
    private List<String> _visited = new LinkedList<String>();

    public List<String> getVisited() {
        return _visited;
    }

    public void addPage(String page) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String uhrzeit = sdf.format(new Date());
        _visited.add("Seite: " + page + " um: " + uhrzeit + "\n");
    }

}


