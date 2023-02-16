package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import org.springframework.context.*;
//import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")

public class SignInServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
//
//    }
    public SignInServlet() {
    super();
}

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            User user = userService.authorizeUser(email, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
                return;
            }
        }
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/signIn.jsp").forward(req, res);
        }
    }

    public void destroy() {
        super.destroy();
    }
}



//        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
//        if (visitCounter == null) {
//            visitCounter = 1;
//        } else {
//            visitCounter++;
//        }
//        session.setAttribute("visitCounter", visitCounter);
//        String username = req.getParameter("username");
//        res.setContentType("text/html");
//        PrintWriter printWriter = res.getWriter();
//        if (username == null) {
//            printWriter.write("Hello, Anonymous" + " ");
//        } else {
//            printWriter.write("Hello, " + username + " ");
//        }
//        printWriter.write("Page was visited " + visitCounter + " times.");
//        printWriter.close();
//    }
//
//}

//        PrintWriter pw = res.getWriter();
//
//        pw.println("<html>");
//        pw.println("<h1> Hello <?h1>");
//        pw.println("</html");
//    }
//}
