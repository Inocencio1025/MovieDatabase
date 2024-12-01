import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        request.setAttribute("table", table);

        // Forward to the "add" page (e.g., a form to add new data)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
        dispatcher.forward(request, response);

    }
}
