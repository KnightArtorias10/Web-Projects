package mvc;
import Users.DatabaseFacade;
import Users.UserEntry;
import beans.History;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"","/Controller"})
public class Controller extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        ServletContext application = getServletContext();
        HttpSession session = request.getSession();
        History history = (History)session.getAttribute("history");
        if (history == null) {
            history = new History();
            session.setAttribute("history",history);
        }
// Je nach Wert von dispatchto die Aktion auswählen
        String dispatchto = "";
        if (request.getParameter("dispatchto") != null) {
            dispatchto = request.getParameter("dispatchto");
        }
        if (dispatchto.equals("Login")) {
            history.addPage("Login");
            String page = "/Login.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
        if (dispatchto.equals("History")) {
            history.addPage("History");
            String page = "/History.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
        if (dispatchto.equals("Gaestebuch")) {
            history.addPage("Gaestebuch");
            String page = "/Show";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
        if (dispatchto.equals("Loginform")) {
            history.addPage("Loginform");
            String page = "/Loginform.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
        if (dispatchto.equals("Evaluation")) {
            history.addPage("Evaluation");
            String page = "/Evalmenu.xhtml";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
        if (dispatchto.equals("LoginSave")) {
// Model beschaffen
            LoginSave loginSave =
                    (LoginSave) session.getAttribute("loginSave");
            if (loginSave == null) {
                loginSave = new mvc.LoginSave();
                session.setAttribute("loginSave", loginSave);
            }
            String id = request.getParameter("User-ID");
            DatabaseFacade dbf = new DatabaseFacade();
            List<UserEntry> guestbookEntries = dbf.listAllEntries();
            for (UserEntry entry:guestbookEntries) {
                if (id.equals(entry.getId())) {
                    history.addPage("Benutzer existiert bereits");
                    String page = "/userexists.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(request, response);
                    return;
                }
            }
            String firstName = request.getParameter("Vorname");
            String lastName = request.getParameter("Nachname");
            String password = request.getParameter("Passwort");
            String[] berechtigungsStufen = request.getParameterValues("Berechtigungsstufe");
            loginSave.setUser(id, password, firstName, lastName, berechtigungsStufen);
            loginSave.setId(id);
            loginSave.setFirstName(firstName);
            loginSave.setLastName(lastName);
            loginSave.setPassword(password);
            loginSave.setBerechtigungsStufen(berechtigungsStufen);
            history.addPage("Willkommen");
            String page = "/welcome.jsp";
            RequestDispatcher dispatcher = application.getRequestDispatcher(page);
            dispatcher.forward(request, response);
            return;
        }
        if (dispatchto.equals("LoggedIn")) {
            String id = request.getParameter("User-ID");
            String password = request.getParameter("Passwort");
            DatabaseFacade dbf = new DatabaseFacade();
            List<UserEntry> guestbookEntries = dbf.listAllEntries();
            for (UserEntry entry:guestbookEntries) {
                if (id.equals(entry.getId())) {
                    if (password.equals(entry.getPassword())) {
                        history.addPage("Kursseite");
                        String page = "/Courses.jsp";
                        RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                        dispatcher.forward(request, response);
                        return;
                    }
                    else {
                        history.addPage("falsches Passwort");
                        String page = "/wrongpassword.jsp";
                        RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                        dispatcher.forward(request, response);
                        return;
                    }
                }
            }
            history.addPage("falscher Benutzername");
            String page = "/unknownuserid.jsp";
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


