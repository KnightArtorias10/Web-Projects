/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author HP EliteBook 8440p
 */
public class History implements java.io.Serializable {
    private List<String> visited = new LinkedList<String>();

    public List<String> getVisited() { return visited; }

    public void addPage(String page) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDate.format(new Date());
        visited.add("Page: <b><u>" +page +"</u></b> um <b><u>" +time +"</u></b> \n");
    }
}
