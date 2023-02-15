package edu.school21.cinema.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/signIn")

@WebServlet("/hello")
public class SignInServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);
        String username = req.getParameter("username");
        res.setContentType("text/html");
        PrintWriter printWriter = res.getWriter();
        if (username == null) {
            printWriter.write("Hello, Anonymous" + " ");
        } else {
            printWriter.write("Hello, " + username + " ");
        }
        printWriter.write("Page was visited " + visitCounter + " times.");
        printWriter.close();
    }

}

//        PrintWriter pw = res.getWriter();
//
//        pw.println("<html>");
//        pw.println("<h1> Hello <?h1>");
//        pw.println("</html");
//    }
//}
