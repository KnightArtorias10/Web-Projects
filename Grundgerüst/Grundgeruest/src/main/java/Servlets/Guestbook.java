/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        // GuestbookEntryPOJO entry = new GuestbookEntryPOJO();
        //DatabaseFacade facade = new DatabaseFacade();

        //entry.setEmail(request.getParameter("Email"));
        // entry.setComment(request.getParameter("Comment"));
        // facade.insert(entry);
        // response.sendRedirect("Show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = con.createStatement();
            String sqlInsert = "INSERT INTO GUESTBOOK(email, comment)" + "VALUES (" +request.getParameter("email") + "," +request.getParameter("comment");

            response.sendRedirect("guestbook.jsp");
            statement.execute(sqlInsert);
            statement.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
