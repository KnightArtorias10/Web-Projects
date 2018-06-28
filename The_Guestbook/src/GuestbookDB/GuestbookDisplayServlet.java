package GuestbookDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Guestbook.GuestbookDisplayServlet", urlPatterns = {"/Show"})
public class GuestbookDisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseFacade dbf = new DatabaseFacade();

        List<GuestbookEntry> guestbookEntries = dbf.listAllEntries();
        request.setAttribute("guestbookEntries", guestbookEntries);

        //Servlet JSP communication
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Guestbook.jsp");
        reqDispatcher.forward(request, response);
    }
}