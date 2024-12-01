import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tableName = request.getParameter("table");
        List<?> data = fetchDataFromDatabase(tableName);

        request.setAttribute("tableName", tableName);
        request.setAttribute("data", data);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp"); // Forward to view.jsp
        dispatcher.forward(request, response);
    }

    private List<?> fetchDataFromDatabase(String tableName) {
        return switch (tableName) {
            case "MOVIE" -> fetchMovies();
            case "ACTOR" -> fetchActors();
            case "ACTRESS" -> fetchActress();
            case "PRODUCER" -> fetchProducers();
            case "DIRECTOR" -> fetchDirectors();
            case "WRITER" -> fetchWriters();
            default -> null; // In case of invalid table name, return null
        };
    }

    //Retrieving lists to populate table
    private List<Movie> fetchMovies() {return DatabaseConnection.getMovies();}
    private List<MovieActor> fetchActors() {return DatabaseConnection.getMovieActors();}
    private List<MovieActress> fetchActress() {return DatabaseConnection.getMovieActresses();}
    private List<MovieProducer> fetchProducers() {return DatabaseConnection.getMovieProducers();}
    private List<MovieDirector> fetchDirectors() {return DatabaseConnection.getMovieDirectors();}
    private List<MovieWriter> fetchWriters() {return DatabaseConnection.getMovieWriters();}
}
