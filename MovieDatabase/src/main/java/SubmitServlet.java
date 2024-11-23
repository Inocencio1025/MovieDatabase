import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the action from the form submission (either "view" or "add")
        String action = request.getParameter("action");

        // Redirect or forward based on the action value
        if ("view".equals(action)) {
            // Forward to the "view" page (e.g., a page showing the data)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
            dispatcher.forward(request, response);
        } else if ("add".equals(action)) {
            // Forward to the "add" page (e.g., a form to add new data)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
            dispatcher.forward(request, response);

        } else if ("modify".equals(action)) {
            // Example hardcoded movie data
            String movieId = request.getParameter("id");

            Movie movie = new Movie();
            movie.setId(movieId);
            movie.setTitle("Inception");
            movie.setReleaseDate("2010-07-16");
            movie.setProducers("Christopher Nolan");
            movie.setDirectors("Christopher Nolan");
            movie.setActors("Leonardo DiCaprio");
            movie.setActresses("Ellen Page");
            movie.setWriters("Christopher Nolan");
            movie.setRating(5);
            movie.setLength(148);
            movie.setCategory("Sci-Fi");

            // Set the movie object as a request attribute
            request.setAttribute("id", "00000000000");
            request.setAttribute("table", "movie");  // Example, set the correct table name


            RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle invalid action
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }
}
