import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private static final String URL = "jdbc:h2:./MovieDatabase";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //Creates tables and entries at startup
    static void initializeDatabase() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {

            //Drop All tables -for testing

            stmt.execute("DROP TABLE IF EXISTS MOVIE_ACTOR;\n" +
                    "DROP TABLE IF EXISTS MOVIE_ACTRESS;\n" +
                    "DROP TABLE IF EXISTS MOVIE_PRODUCER;\n" +
                    "DROP TABLE IF EXISTS MOVIE_DIRECTOR;\n" +
                    "DROP TABLE IF EXISTS MOVIE_WRITER;\n" +
                    "DROP TABLE IF EXISTS ACTOR;\n" +
                    "DROP TABLE IF EXISTS ACTRESS;\n" +
                    "DROP TABLE IF EXISTS PRODUCER;\n" +
                    "DROP TABLE IF EXISTS DIRECTOR;\n" +
                    "DROP TABLE IF EXISTS WRITER;\n" +
                    "DROP TABLE IF EXISTS MOVIE;\n"
            );

            // Create Tables
            // Movie table
            stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE (" +
                    "movieID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(255), " +
                    "releaseDate DATE, " +
                    "synopsis TEXT, " +
                    "rating DECIMAL(2, 1), " +
                    "length INT, " +
                    "category VARCHAR(50))"
            );
            // Producer table
            stmt.execute("CREATE TABLE IF NOT EXISTS PRODUCER (" +
                    "producerID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR(255))"
            );
            // Actor table
            stmt.execute("CREATE TABLE IF NOT EXISTS ACTOR (" +
                    "actorID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR(255))"
            );
            // Actress table
            stmt.execute("CREATE TABLE IF NOT EXISTS ACTRESS (" +
                    "actressID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR(255))"
            );
            // Writer table
            stmt.execute("CREATE TABLE IF NOT EXISTS WRITER (" +
                    "writerID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR(255))"
            );
            // Director table
            stmt.execute("CREATE TABLE IF NOT EXISTS DIRECTOR (" +
                    "directorID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR(255))"
            );
            // Movie_Producer table (Weak Entity)
            stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE_PRODUCER (" +
                    "producerID INT, " +
                    "movieID INT, " +
                    "role VARCHAR(100), " +
                    "pay INT, " +
                    "PRIMARY KEY (producerID, movieID), " +
                    "FOREIGN KEY(producerID) REFERENCES PRODUCER(producerID), " +
                    "FOREIGN KEY(movieID) REFERENCES MOVIE(movieID))"
            );
            // Movie_Actor table (Weak Entity)
            stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE_ACTOR (" +
                    "actorID INT, " +
                    "movieID INT, " +
                    "role VARCHAR(100), " +
                    "pay INT, " +
                    "PRIMARY KEY (actorID, movieID), " +
                    "FOREIGN KEY (actorID) REFERENCES ACTOR(actorID), " +
                    "FOREIGN KEY (movieID) REFERENCES MOVIE(movieID))"
            );
            // Movie_Actress table (Weak Entity)
            stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE_ACTRESS (" +
                    "actressID INT, " +
                    "movieID INT, " +
                    "role VARCHAR(100), " +
                    "pay INT, " +
                    "PRIMARY KEY (actressID, movieID), " +
                    "FOREIGN KEY (actressID) REFERENCES ACTRESS(actressID), " +
                    "FOREIGN KEY (movieID) REFERENCES MOVIE(movieID))"
            );
            // Movie_Writer table (Weak Entity)
            stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE_WRITER (" +
                    "writerID INT, " +
                    "movieID INT, " +
                    "role VARCHAR(100), " +
                    "pay INT, " +
                    "PRIMARY KEY (writerID, movieID), " +
                    "FOREIGN KEY (writerID) REFERENCES WRITER(writerID), " +
                    "FOREIGN KEY (movieID) REFERENCES MOVIE(movieID))"
            );
            // Movie_Director table (Weak Entity)
            stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE_DIRECTOR (" +
                    "directorID INT, " +
                    "movieID INT, " +
                    "role VARCHAR(100), " +
                    "pay INT, " +
                    "PRIMARY KEY (directorID, movieID), " +
                    "FOREIGN KEY (directorID) REFERENCES DIRECTOR(directorID), " +
                    "FOREIGN KEY (movieID) REFERENCES MOVIE(movieID))"
            );

            System.out.println("Database and tables initialized successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error initializing the database: " + e.getMessage());
        }

        //Adding entries at start up
        addExampleMovies();
    }

    // Add into database functions
    // All functions returns its ID
    public static int addMovie(String title, Date releaseDate, String synopsis, BigDecimal rating, int length, String category) {
        String sql = "INSERT INTO MOVIE (title, releaseDate, synopsis, rating, length, category) VALUES (?, ?, ?, ?, ?, ?)";
        int movieID = -1;  // Default value if insertion fails
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, title);
            stmt.setDate(2, releaseDate);
            stmt.setString(3, synopsis);
            stmt.setBigDecimal(4, rating);
            stmt.setInt(5, length);
            stmt.setString(6, category);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    movieID = generatedKeys.getInt(1);
                    System.out.println("Movie " + title + " added successfully with ID: " + movieID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieID;
    }

    public static int addProducer(String firstName, String lastName) {
        String sql = "INSERT INTO PRODUCER (firstName, lastName) VALUES (?, ?)";  // Fixed table name to match case
        int producerID = -1;  // Default value if the insertion fails
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {  // Make sure to request generated keys
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    producerID = generatedKeys.getInt(1);  // Get the auto-generated producerID
                    System.out.println("Producer " + firstName + " added successfully with ID: " + producerID);  // Print to console
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producerID;
    }

    public static int addActor(String firstName, String lastName) {
        String sql = "INSERT INTO ACTOR (firstName, lastName) VALUES (?, ?)";
        int actorID = -1;  // Default value if the insertion fails
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    actorID = generatedKeys.getInt(1);
                    System.out.println("Actor " + firstName + " added successfully with ID: " + actorID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorID;
    }
    public static int addActress(String firstName, String lastName) {
        String sql = "INSERT INTO ACTRESS (firstName, lastName) VALUES (?, ?)";
        int actressID = -1;  // Default value if the insertion fails
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    actressID = generatedKeys.getInt(1);
                    System.out.println("Actress " + firstName + " added successfully with ID: " + actressID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actressID;
    }

    public static int addWriter(String firstName, String lastName) {
        String sql = "INSERT INTO WRITER (firstName, lastName) VALUES (?, ?)";
        int writerID = -1;  // Default value if the insertion fails
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    writerID = generatedKeys.getInt(1);
                    System.out.println("Writer " + firstName + " added successfully with ID: " + writerID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return writerID;
    }
    public static int addDirector(String firstName, String lastName) {
        String sql = "INSERT INTO DIRECTOR (firstName, lastName) VALUES (?, ?)";
        int directorID = -1;  // Default value if the insertion fails
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    directorID = generatedKeys.getInt(1);
                    System.out.println("Director " + firstName + " added successfully with ID: " + directorID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directorID;
    }

    // all addToMovie functions creates the weak entity
    public static void addProducerToMovie(int producerID, int movieID, String role, BigDecimal pay) {
        String sql = "INSERT INTO MOVIE_PRODUCER (producerID, movieID, role, pay) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producerID);
            stmt.setInt(2, movieID);
            stmt.setString(3, role);
            stmt.setBigDecimal(4, pay);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Producer " + producerID + " linked to Movie " + movieID + " with role: " + role + " and pay: $" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addActorToMovie(int actorID, int movieID, String role, BigDecimal pay) {
        String sql = "INSERT INTO MOVIE_ACTOR (actorID, movieID, role, pay) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, actorID);
            stmt.setInt(2, movieID);
            stmt.setString(3, role);
            stmt.setBigDecimal(4, pay);


            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Actor " + actorID + " linked to Movie " + movieID + " with role: " + role + " and pay: $" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addActressToMovie(int actressID, int movieID, String role, BigDecimal pay) {
        String sql = "INSERT INTO MOVIE_ACTRESS (actressID, movieID, role, pay) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, actressID);
            stmt.setInt(2, movieID);
            stmt.setString(3, role);
            stmt.setBigDecimal(4, pay);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Actress " + actressID + " linked to Movie " + movieID + " with role: " + role + " and pay: $" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addDirectorToMovie(int directorID, int movieID, String role, BigDecimal pay) {
        String sql = "INSERT INTO MOVIE_DIRECTOR (directorID, movieID, role, pay) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, directorID);
            stmt.setInt(2, movieID);
            stmt.setString(3, role);
            stmt.setBigDecimal(4, pay);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Director " + directorID + " linked to Movie " + movieID + " with role: " + role + " and pay: $" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addWriterToMovie(int writerID, int movieID, String role, BigDecimal pay) {
        String sql = "INSERT INTO MOVIE_WRITER (writerID, movieID, role, pay) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, writerID);
            stmt.setInt(2, movieID);
            stmt.setString(3, role);
            stmt.setBigDecimal(4, pay);


            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Writer " + writerID + " linked to Movie " + movieID + " with role: " + role + " and pay: $" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // End of all Add functions





    // Method to get all movies from the database
    public static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT M.movieID, M.title, M.releaseDate, M.synopsis, M.rating, M.length, M.category, " +
                "GROUP_CONCAT(DISTINCT CONCAT(A.firstName, ' ', A.lastName) SEPARATOR '<br>') AS actors, " +
                "GROUP_CONCAT(DISTINCT MA.role SEPARATOR '<br>') AS actorRoles, " +
                "GROUP_CONCAT(DISTINCT MA.pay SEPARATOR '<br>') AS actorPay, " +

                "GROUP_CONCAT(DISTINCT CONCAT(AC.firstName, ' ', AC.lastName) SEPARATOR '<br>') AS actresses, " +
                "GROUP_CONCAT(DISTINCT MAC.role SEPARATOR '<br>') AS actressRoles, " +
                "GROUP_CONCAT(DISTINCT MAC.pay SEPARATOR '<br>') AS actressPay, " +

                "GROUP_CONCAT(DISTINCT CONCAT(D.firstName, ' ', D.lastName) SEPARATOR '<br>') AS directors, " +
                "GROUP_CONCAT(DISTINCT MD.role SEPARATOR '<br>') AS directorRoles, " +
                "GROUP_CONCAT(DISTINCT MD.pay SEPARATOR '<br>') AS directorPay, " +

                "GROUP_CONCAT(DISTINCT CONCAT(P.firstName, ' ', P.lastName) SEPARATOR '<br>') AS producers, " +
                "GROUP_CONCAT(DISTINCT MP.role SEPARATOR '<br>') AS producerRoles, " +
                "GROUP_CONCAT(DISTINCT MP.pay SEPARATOR '<br>') AS producerPay, " +

                "GROUP_CONCAT(DISTINCT CONCAT(W.firstName, ' ', W.lastName) SEPARATOR '<br>') AS writers, " +
                "GROUP_CONCAT(DISTINCT MW.role SEPARATOR '<br>') AS writerRoles, " +
                "GROUP_CONCAT(DISTINCT MW.pay SEPARATOR '<br>') AS writerPay " +
                "FROM MOVIE M " +

                "LEFT JOIN MOVIE_ACTOR MA ON M.movieID = MA.movieID " +
                "LEFT JOIN ACTOR A ON MA.actorID = A.actorID " +

                "LEFT JOIN MOVIE_ACTRESS MAC ON M.movieID = MAC.movieID " +
                "LEFT JOIN ACTRESS AC ON MAC.actressID = AC.actressID " +

                "LEFT JOIN MOVIE_DIRECTOR MD ON M.movieID = MD.movieID " +
                "LEFT JOIN DIRECTOR D ON MD.directorID = D.directorID " +

                "LEFT JOIN MOVIE_PRODUCER MP ON M.movieID = MP.movieID " +
                "LEFT JOIN PRODUCER P ON MP.producerID = P.producerID " +

                "LEFT JOIN MOVIE_WRITER MW ON M.movieID = MW.movieID " +
                "LEFT JOIN WRITER W ON MW.writerID = W.writerID " +
                "GROUP BY M.movieID;";




        try (PreparedStatement statement = getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Create lists for the actors, actresses, directors, producers, and writers
                List<String> actors = new ArrayList<>();
                List<String> actresses = new ArrayList<>();
                List<String> directors = new ArrayList<>();
                List<String> producers = new ArrayList<>();
                List<String> writers = new ArrayList<>();

                List<String> actorRoles = new ArrayList<>();
                List<String> actressRoles = new ArrayList<>();
                List<String> directorRoles = new ArrayList<>();
                List<String> producerRoles = new ArrayList<>();
                List<String> writerRoles = new ArrayList<>();

                List<String> actorPay = new ArrayList<>();
                List<String> actressPay = new ArrayList<>();
                List<String> directorPay = new ArrayList<>();
                List<String> producerPay = new ArrayList<>();
                List<String> writerPay = new ArrayList<>();

                // Assuming resultSet contains the relevant data for each column
                // Add actors, actresses, directors, etc. to the lists
                actors.add(resultSet.getString("actors"));
                actorRoles.add(resultSet.getString("actorRoles"));
                actorPay.add(resultSet.getString("actorPay"));

                actresses.add(resultSet.getString("actresses"));
                actressRoles.add(resultSet.getString("actressRoles"));
                actressPay.add(resultSet.getString("actressPay"));
                directors.add(resultSet.getString("directors"));
                directorRoles.add(resultSet.getString("directorRoles"));
                directorPay.add(resultSet.getString("directorPay"));

                producers.add(resultSet.getString("producers"));
                producerRoles.add(resultSet.getString("producerRoles"));
                producerPay.add(resultSet.getString("producerPay"));

                writers.add(resultSet.getString("writers"));
                writerRoles.add(resultSet.getString("writerRoles"));
                writerPay.add(resultSet.getString("writerPay"));

                // Create the movie object with all the lists included
                Movie movie = new Movie(
                        resultSet.getInt("movieID"),
                        resultSet.getString("title"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("rating"),
                        resultSet.getInt("length"),
                        resultSet.getString("category"),
                        actors,
                        actresses,
                        directors,
                        producers,
                        writers,
                        actorRoles,
                        actressRoles,
                        directorRoles,
                        producerRoles,
                        writerRoles,
                        actorPay,
                        actressPay,
                        directorPay,
                        producerPay,
                        writerPay
                );

                movies.add(movie);
            }


        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        }

        return movies;
    }

    public static List<MovieActor> getMovieActors() {
        List<MovieActor> actors = new ArrayList<>();
        String query = "SELECT a.actorID, a.firstName, a.lastName, m.title AS movieTitle, ma.movieID, ma.role, ma.pay " +
                "FROM ACTOR a " +
                "JOIN MOVIE_ACTOR ma ON a.actorID = ma.actorID " +
                "JOIN MOVIE m ON ma.movieID = m.movieID";

        try (PreparedStatement statement = getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MovieActor actor = new MovieActor(
                        resultSet.getInt("actorID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("title"),
                        resultSet.getInt("movieID"),
                        resultSet.getString("role"),
                        resultSet.getBigDecimal("pay")
                );
                actors.add(actor);
                //System.out.println(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }


    public static List<MovieActress> getMovieActresses() {
        List<MovieActress> actresses = new ArrayList<>();
        String query = "SELECT a.actressID, a.firstName, a.lastName, m.title AS movieTitle, ma.movieID, ma.role, ma.pay " +
                "FROM ACTRESS a " +
                "JOIN MOVIE_ACTRESS ma ON a.actressID = ma.actressID " +
                "JOIN MOVIE m ON ma.movieID = m.movieID";

        try (PreparedStatement statement = getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MovieActress actress = new MovieActress(
                        resultSet.getInt("actressID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("title"),
                        resultSet.getInt("movieID"),
                        resultSet.getString("role"),
                        resultSet.getBigDecimal("pay")
                        );
                actresses.add(actress);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actresses;
    }

    public static List<MovieProducer> getMovieProducers() {
        List<MovieProducer> producers = new ArrayList<>();
        String query = "SELECT a.producerID, a.firstName, a.lastName, m.title AS movieTitle, ma.movieID, ma.role, ma.pay " +
        "FROM PRODUCER a " +
        "JOIN MOVIE_PRODUCER ma ON a.producerID = ma.producerID " +
        "JOIN MOVIE m ON ma.movieID = m.movieID";

        try (PreparedStatement statement = getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MovieProducer producer = new MovieProducer(
                        resultSet.getInt("producerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("title"),
                        resultSet.getInt("movieID"),
                        resultSet.getString("role"),
                        resultSet.getBigDecimal("pay")
                );
                producers.add(producer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producers;
    }

    public static List<MovieDirector> getMovieDirectors() {
        List<MovieDirector> directors = new ArrayList<>();
        String query = "SELECT d.directorID, d.firstName, d.lastName, m.title AS movieTitle, md.movieID, md.role, md.pay " +
                "FROM DIRECTOR d " +
                "JOIN MOVIE_DIRECTOR md ON d.directorID = md.directorID " +
                "JOIN MOVIE m ON md.movieID = m.movieID;";

        try (PreparedStatement statement = getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MovieDirector director = new MovieDirector(
                        resultSet.getInt("directorID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("title"),
                        resultSet.getInt("movieID"),
                        resultSet.getString("role"),
                        resultSet.getBigDecimal("pay")
                );
                directors.add(director);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return directors;
    }

    public static List<MovieWriter> getMovieWriters() {
        List<MovieWriter> writers = new ArrayList<>();
        String query = "SELECT w.writerID, w.firstName, w.lastName, m.title AS movieTitle, mw.movieID, mw.role, mw.pay " +
                "FROM WRITER w " +
                "JOIN MOVIE_WRITER mw ON w.writerID = mw.writerID " +
                "JOIN MOVIE m ON mw.movieID = m.movieID;";

        try (PreparedStatement statement = getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MovieWriter writer = new MovieWriter(
                        resultSet.getInt("writerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("title"),
                        resultSet.getInt("movieID"),
                        resultSet.getString("role"),
                        resultSet.getBigDecimal("pay")
                );
                writers.add(writer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return writers;
    }

    public static void deleteRecord(String table, String id) {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            // Delete weak entities first
            switch (table) {
                case "MOVIE":
                    deleteWeakEntity(conn, "MOVIE_ACTOR", "movieID", id);
                    deleteWeakEntity(conn, "MOVIE_ACTRESS", "movieID", id);
                    deleteWeakEntity(conn, "MOVIE_DIRECTOR", "movieID", id);
                    deleteWeakEntity(conn, "MOVIE_PRODUCER", "movieID", id);
                    deleteWeakEntity(conn, "MOVIE_WRITER", "movieID", id);
                    break;

                case "ACTOR":
                    deleteWeakEntity(conn, "MOVIE_ACTOR", "actorID", id);
                    break;

                case "ACTRESS":
                    deleteWeakEntity(conn, "MOVIE_ACTRESS", "actressID", id);
                    break;

                case "DIRECTOR":
                    deleteWeakEntity(conn, "MOVIE_DIRECTOR", "directorID", id);
                    break;

                case "PRODUCER":
                    deleteWeakEntity(conn, "MOVIE_PRODUCER", "producerID", id);
                    break;

                case "WRITER":
                    deleteWeakEntity(conn, "MOVIE_WRITER", "writerID", id);
                    break;
            }

            // Delete main record
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, Integer.parseInt(id));
                stmt.executeUpdate();
            }

            conn.commit(); // Commit transaction
            System.out.println(id + " deleted from " + table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteWeakEntity(Connection conn, String weakTable, String foreignKey, String id) throws SQLException {
        String sql = "DELETE FROM " + weakTable + " WHERE " + foreignKey + " = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        }
    }

    // For adding example entries to database
    private static void addExampleMovies() {
        int movieID = addMovie(
                "Step Brothers",                     // Title
                Date.valueOf("2008-07-25"),          // Release Date
                "Two middle-aged men become step brothers and hilarity ensues.",  // Synopsis
                new BigDecimal("3.9"),               // Rating
                98,                                  // Length (in minutes)
                "Comedy"                             // Category
        );

        addProducerToMovie(addProducer("Judd", "Apatow"), movieID, "Executive Producer", new BigDecimal("1500000"));
        addProducerToMovie(addProducer("Jimmy", "Miller"), movieID, "Producer", new BigDecimal("1200000"));
        addDirectorToMovie(addDirector("Adam", "McKay"), movieID, "Main Director", new BigDecimal("2000000"));
        addWriterToMovie(addWriter("Will", "Ferrell"), movieID, "Screenplay", new BigDecimal("500000"));
        addWriterToMovie(addWriter("Adam", "McKay"), movieID, "Screenplay", new BigDecimal("500000"));
        addActorToMovie(addActor("Will", "Ferrell"), movieID, "Brennan Huff", new BigDecimal("3000000"));
        addActorToMovie(addActor("John", "C. Reilly"), movieID, "Dale Doback", new BigDecimal("2500000"));


        movieID = addMovie(
                "Accepted",                          // Title
                Date.valueOf("2006-08-18"),          // Release Date
                "A high school slacker creates a fake university to avoid going to real college.",  // Synopsis
                new BigDecimal("6.4"),               // Rating
                90,                                  // Length (in minutes)
                "Comedy"                             // Category
        );

        addProducerToMovie(addProducer("Tom", "Shankland"), movieID, "Producer", new BigDecimal("1000000"));
        addProducerToMovie(addProducer("Paul", "Weitz"), movieID, "Producer", new BigDecimal("1200000"));
        addDirectorToMovie(addDirector("Steve", "Pink"), movieID, "Main Director", new BigDecimal("2000000"));
        addWriterToMovie(addWriter("Adam", "Cozen"), movieID, "Screenplay", new BigDecimal("500000"));
        addWriterToMovie(addWriter("Bill", "Collage"), movieID, "Screenplay", new BigDecimal("500000"));
        addActorToMovie(addActor("Justin", "Long"), movieID, "Bartleby Gaines", new BigDecimal("2000000"));
        addActressToMovie(addActress("Blake", "Lively"), movieID, "Monica Moreland", new BigDecimal("1500000"));
        addActorToMovie(addActor("Jonah", "Hill"), movieID, "Sherman", new BigDecimal("1000000"));
        addActorToMovie(addActor("Adam", "Hillis"), movieID, "Hans", new BigDecimal("1200000"));


        movieID = addMovie(
                "Waiting",
                Date.valueOf("2005-10-07"),
                "Employees at a chain restaurant struggle to come to terms with their frustrations while dealing with customers.",
                new BigDecimal("6.7"),
                94,
                "Comedy"
        );

        addProducerToMovie(addProducer("Rob", "McKittrick"), movieID, "Producer", new BigDecimal("1000000"));
        addProducerToMovie(addProducer("Matt", "Parker"), movieID, "Producer", new BigDecimal("1200000"));
        addDirectorToMovie(addDirector("Rob", "McKittrick"), movieID, "Main Director", new BigDecimal("2000000"));
        addWriterToMovie(addWriter("Rob", "McKittrick"), movieID, "Screenplay", new BigDecimal("500000"));
        addActorToMovie(addActor("Ryan", "Reynolds"), movieID, "Monty", new BigDecimal("3000000"));
        addActressToMovie(addActress("Anna", "Faris"), movieID, "Danielle", new BigDecimal("2500000"));
        addActorToMovie(addActor("Justin", "Long"), movieID, "Dean", new BigDecimal("2000000"));
        addActorToMovie(addActor("David", "Koechner"), movieID, "Carmine", new BigDecimal("1800000"));
        addActorToMovie(addActor("Andy", "Milonakis"), movieID, "Nick", new BigDecimal("1500000"));

        movieID = addMovie(
                "South Park: Bigger, Longer & Uncut",
                Date.valueOf("1999-06-30"),
                "The boys' latest adventure takes them to Canada, where they must rescue their parents from being sent to war after they see an inappropriate movie.",
                new BigDecimal("7.7"),
                81,
                "Animation, Comedy, Musical"
        );

        addProducerToMovie(addProducer("Trey", "Parker"), movieID, "Executive Producer", new BigDecimal("3000000"));
        addProducerToMovie(addProducer("Matt", "Stone"), movieID, "Producer", new BigDecimal("2500000"));
        addDirectorToMovie(addDirector("Trey", "Parker"), movieID, "Director", new BigDecimal("4000000"));
        addWriterToMovie(addWriter("Trey", "Parker"), movieID, "Screenplay", new BigDecimal("600000"));
        addWriterToMovie(addWriter("Matt", "Stone"), movieID, "Screenplay", new BigDecimal("600000"));
        addActorToMovie(addActor("Trey", "Parker"), movieID, "Stan Marsh", new BigDecimal("1000000"));
        addActorToMovie(addActor("Matt", "Stone"), movieID, "Kyle Broflovski", new BigDecimal("1000000"));
        addActorToMovie(addActor("Isaac", "Hayes"), movieID, "Chef", new BigDecimal("800000"));
        addActorToMovie(addActor("George", "S. Clinton"), movieID, "Saddam Hussein", new BigDecimal("500000"));
        addActressToMovie(addActress("Mary", "Kay Bergman"), movieID, "Sharon Marsh", new BigDecimal("300000"));
    }
}
