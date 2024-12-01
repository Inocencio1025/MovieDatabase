import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/addData")
public class AddDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String table = request.getParameter("table");
        PrintWriter out = response.getWriter();

        try {
            switch (table) {
                case "MOVIE":
                    String title = request.getParameter("title");
                    Date releaseDate = Date.valueOf(request.getParameter("date"));
                    String synopsis = request.getParameter("synopsis");
                    double rating = Double.parseDouble((request.getParameter("rating")));
                    int length = Integer.parseInt(request.getParameter("length"));
                    String category = request.getParameter("category");
                    DatabaseConnection.addMovie(title, releaseDate, synopsis, new BigDecimal(rating), length, category);
                    break;

                case "MOVIE_PRODUCER": {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastNames");
                    DatabaseConnection.addProducer(firstName, lastName);
                    break;
                }
                case "MOVIE_DIRECTOR": {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastNames");
                    DatabaseConnection.addDirector(firstName, lastName);
                    break;
                }
                case "MOVIE_ACTOR": {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastNames");
                    DatabaseConnection.addActor(firstName, lastName);
                    break;
                }
                case "MOVIE_ACTRESS": {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastNames");
                    DatabaseConnection.addActress(firstName, lastName);
                    break;
                }
                case "MOVIE_WRITER": {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastNames");
                    DatabaseConnection.addWriter(firstName, lastName);
                    break;
                }
                case null:
                default:
                    out.println("<h2>Invalid Table Type</h2>");
                    break;
            }

            response.sendRedirect("index.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("Error occurred while processing the form.");
        }
    }
}
