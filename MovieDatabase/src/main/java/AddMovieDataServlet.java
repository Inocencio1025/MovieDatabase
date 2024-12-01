import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/addMovieData")
public class AddMovieDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String table = request.getParameter("table");
        int movieID = Integer.parseInt(request.getParameter("movieID"));
        int personID = Integer.parseInt(request.getParameter("personID"));
        String role = request.getParameter("role");
        double pay = Double.parseDouble(request.getParameter("pay"));

        try {
            switch (table) {
                case "MOVIE_PRODUCER": {
                    DatabaseConnection.addProducerToMovie(personID, movieID, role, new BigDecimal(pay));
                    break;
                }
                case "MOVIE_DIRECTOR": {
                    DatabaseConnection.addDirectorToMovie(personID, movieID, role, new BigDecimal(pay));
                    break;
                }
                case "MOVIE_ACTOR": {
                    DatabaseConnection.addActorToMovie(personID, movieID, role, new BigDecimal(pay));
                    break;
                }
                case "MOVIE_ACTRESS": {
                    DatabaseConnection.addActressToMovie(personID, movieID, role, new BigDecimal(pay));
                    break;
                }
                case "MOVIE_WRITER": {
                    DatabaseConnection.addWriterToMovie(personID, movieID, role, new BigDecimal(pay));
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
