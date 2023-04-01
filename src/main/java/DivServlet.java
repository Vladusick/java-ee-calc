import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DivServlet", urlPatterns = "/div")
public class DivServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(DivServlet.class);

    // http://localhost:8080/java-ee/div?a=1&b=1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("DivServlet");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        int firstNumber = Integer.parseInt(req.getParameter("a"));
        int secondNumber = Integer.parseInt(req.getParameter("b"));
        int div = firstNumber / secondNumber;
        logger.info("Div = " + div);

        out.println("<html><body><h1>" + String.format("%d / %d = %d",firstNumber, secondNumber, div) + "</h1></body></html>");
        out.close();
    }
}
