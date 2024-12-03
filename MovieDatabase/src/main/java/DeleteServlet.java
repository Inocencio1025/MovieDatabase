import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("ID");
        String table = request.getParameter("table");
        request.setAttribute("table", table);

        DatabaseConnection.deleteRecord(table,id);
        response.sendRedirect("view.jsp");
    }

}
