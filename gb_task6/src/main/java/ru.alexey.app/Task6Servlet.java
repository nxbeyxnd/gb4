package ru.alexey.app;
/* 
23.05.2022: Alexey created this file inside the package: ru.alexey.app 
*/

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class Task6Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().printf("<html>\n" +
                "<body>\n" +
                "<h2>Hello World GB!</h2>\n" +
                "</body>\n" +
                "</html>");
    }
}
