import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ID and table name passed from the JSP
        String id = request.getParameter("id");
        String table = request.getParameter("table");

        // Perform the deletion logic based on the table
        boolean isDeleted = false;
        if ("movie".equals(table)) {
            // Call a method from your DatabaseHelper to delete from the movie table

        } else if ("producer".equals(table)) {
            // Call a method to delete a producer record

        } else if ("director".equals(table)) {
            // Call a method to delete a director record

        }
        // Add other table conditions as needed

        // After deletion, redirect back to the view page
        if (isDeleted) {
            response.sendRedirect("view.jsp"); // Assuming the list is on the "view.jsp" page
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete record.");
        }
    }

}
