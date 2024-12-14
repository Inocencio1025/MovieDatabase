import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        String sortBy = request.getParameter("sortBy");

        List<?> data = fetchDataFromDatabase(table);
        data = sortData(data, table, sortBy);

        request.setAttribute("table", table);
        request.setAttribute("data", data);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("table");
        List<?> data = fetchDataFromDatabase(table);

        request.setAttribute("table", table);
        request.setAttribute("data", data);

        request.getRequestDispatcher("/view.jsp").forward(request, response);
    }

    private List<?> sortData(List<?> data, String tableName, String sortBy) {
        return switch (tableName) {
            case "MOVIE" -> {
                List<Movie> movies = (List<Movie>) data;
                movies.sort(switch (sortBy) {
                    case "ID" -> Comparator.comparing(Movie::getMovieID);
                    case "title" -> Comparator.comparing(Movie::getTitle);
                    case "releaseDate" -> Comparator.comparing(Movie::getReleaseDate).reversed();
                    case "rating" -> Comparator.comparing(Movie::getRating).reversed();
                    case "length" -> Comparator.comparing(Movie::getLength).reversed();
                    case "category" -> Comparator.comparing(Movie::getCategory);
                    default -> Comparator.comparing(Movie::getMovieID); // Default sort by ID
                });
                yield movies;
            }
            case "MOVIE_ACTOR" -> {
                List<MovieActor> actors = (List<MovieActor>) data;
                actors.sort(switch (sortBy) {
                    case "ID" -> Comparator.comparing(MovieActor::getActorID);
                    case "lastName" -> Comparator.comparing(MovieActor::getLastName);
                    case "movie" -> Comparator.comparing(MovieActor::getTitle);
                    case "role" -> Comparator.comparing(MovieActor::getRole);
                    case "pay" -> Comparator.comparing(MovieActor::getPay).reversed();
                    default -> Comparator.comparing(MovieActor::getActorID);
                });
                yield actors;
            }
            case "MOVIE_ACTRESS" -> {
                List<MovieActress> actresses = (List<MovieActress>) data;
                actresses.sort(switch (sortBy) {
                    case "ID" -> Comparator.comparing(MovieActress::getActressID);
                    case "lastName" -> Comparator.comparing(MovieActress::getLastName);
                    case "movie" -> Comparator.comparing(MovieActress::getMovieID);
                    case "role" -> Comparator.comparing(MovieActress::getRole);
                    case "pay" -> Comparator.comparing(MovieActress::getPay).reversed();
                    default -> Comparator.comparing(MovieActress::getActressID);
                });
                yield actresses;
            }
            case "MOVIE_PRODUCER" -> {
                List<MovieProducer> producers = (List<MovieProducer>) data;
                producers.sort(switch (sortBy) {
                    case "ID" -> Comparator.comparing(MovieProducer::getProducerID);
                    case "lastName" -> Comparator.comparing(MovieProducer::getLastName);
                    case "movie" -> Comparator.comparing(MovieProducer::getMovieID);
                    case "role" -> Comparator.comparing(MovieProducer::getRole);
                    case "pay" -> Comparator.comparing(MovieProducer::getPay).reversed();
                    default -> Comparator.comparing(MovieProducer::getProducerID);
                });
                yield producers;
            }
            case "MOVIE_DIRECTOR" -> {
                List<MovieDirector> directors = (List<MovieDirector>) data;
                directors.sort(switch (sortBy) {
                    case "ID" -> Comparator.comparing(MovieDirector::getDirectorID);
                    case "lastName" -> Comparator.comparing(MovieDirector::getLastName);
                    case "movie" -> Comparator.comparing(MovieDirector::getMovieID);
                    case "role" -> Comparator.comparing(MovieDirector::getRole);
                    case "pay" -> Comparator.comparing(MovieDirector::getPay).reversed();
                    default -> Comparator.comparing(MovieDirector::getDirectorID);
                });
                yield directors;
            }
            case "MOVIE_WRITER" -> {
                List<MovieWriter> writers = (List<MovieWriter>) data;
                writers.sort(switch (sortBy) {
                    case "ID" -> Comparator.comparing(MovieWriter::getWriterID);
                    case "lastName" -> Comparator.comparing(MovieWriter::getLastName);
                    case "movie" -> Comparator.comparing(MovieWriter::getMovieID);
                    case "role" -> Comparator.comparing(MovieWriter::getRole);
                    case "pay" -> Comparator.comparing(MovieWriter::getPay).reversed();
                    default -> Comparator.comparing(MovieWriter::getWriterID);
                });
                yield writers;
            }
            default -> null; // Handle invalid tableName
        };
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
