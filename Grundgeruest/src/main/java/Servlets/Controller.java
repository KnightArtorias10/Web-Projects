package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns={"/Controller"})
public class Controller extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ServletContext application = getServletContext();
        HttpSession session = request.getSession();
        History history = (History)session.getAttribute("history");
        if(history == null) {
            history = new History();
            session.setAttribute("history", history);
        }

        String dispatchto = "";
        if(request.getParameter("dispatchto") != null) {
            dispatchto = request.getParameter("dispatchto");
        }

        if(dispatchto.equals("Media")) {
            history.addPage("Media");
            String page = "Media.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }

        if(dispatchto.equals("Guestbook")) {
            history.addPage("Guestbook");
            String page = "Guestbook.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }

        if(dispatchto.equals("Registration")) {
            history.addPage("Registration");
            String page = "Registration.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }

        if(dispatchto.equals("History")) {
            history.addPage("History");
            String page = "History.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }

        else {
            history.addPage("Home");
            String page = "/index.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
    }
}
