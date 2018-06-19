package Guestbook;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String string  = dateFormat.format(new Date());
        entry.setTimestamp(string);
        entry.setName(request.getParameter("Name"));
        entry.setEmail(request.getParameter("Email"));
        entry.setMessage(request.getParameter("Nachricht"));
        dbf.insert(entry);
        response.sendRedirect("Show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
