package Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Guestbook.ControlerServlet", urlPatterns = {"/ControlerServlet"})
public class ControlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String lastpage;
        boolean foundLastpage = false;
        PrintWriter out = response.getWriter();
        for (int i = 0;cookies != null && i<cookies.length;i++) {
            Cookie c = cookies[i];
            out.println(c.getName());
            out.println(c.getValue());
            if (c.getName().equals("lastpage")) {
                if (c.getValue() != null && !c.getValue().equals("")) {
                    foundLastpage = true;
                    response.sendRedirect(c.getValue());
                }
            }
        }
        if (!foundLastpage) {
            response.sendRedirect("index.jsp");
        }
    }
}