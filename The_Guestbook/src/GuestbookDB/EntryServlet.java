package GuestbookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Guestbook.EntryServlet", urlPatterns = {"/Entry"})
public class EntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GuestbookEntry entry = new GuestbookEntry();
        DatabaseFacade dbf = new DatabaseFacade();
        entry.setName(request.getParameter("Name"));
        entry.setComment(request.getParameter("Comment"));
        dbf.insert(entry);
        response.sendRedirect("Show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}