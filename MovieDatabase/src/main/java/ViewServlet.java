import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        List<?> data = fetchDataFromDatabase(table);

        request.setAttribute("table", table);
        request.setAttribute("data", data);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp"); // Forward to view.jsp
        dispatcher.forward(request, response);
    }

    private List<?> fetchDataFromDatabase(String tableName) {
        return switch (tableName) {
            case "MOVIE" -> fetchMovies();
            case "MOVIE_ACTOR" -> fetchActors();
            case "MOVIE_ACTRESS" -> fetchActress();
            case "MOVIE_PRODUCER" -> fetchProducers();
            case "MOVIE_DIRECTOR" -> fetchDirectors();
            case "MOVIE_WRITER" -> fetchWriters();
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
