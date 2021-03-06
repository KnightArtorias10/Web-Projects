/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Guestbook.DatabaseFacade;
import Guestbook.GuestbookEntryPOJO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author HP EliteBook 8440p
 */

@WebServlet (urlPatterns = {"/Guestbook"})
public class Guestbook extends HttpServlet {
    static final String DRIVER = "org.h2.driver";
    static final String URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GuestbookEntryPOJO entry = new GuestbookEntryPOJO();
        DatabaseFacade facade = new DatabaseFacade();


        entry.setEmail(request.getParameter("email"));
        entry.setComment(request.getParameter("comment"));
        facade.insert(entry);
        response.sendRedirect("Show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
