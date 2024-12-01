import java.math.BigDecimal;

public class MovieDirector {
    private int directorID;
    private String firstName;
    private String lastName;
    private String title;
    private int movieID;
    private String role;
    private BigDecimal pay;

    // Constructor
    public MovieDirector(int directorID, String firstName, String lastName, String title, int movieID, String role, BigDecimal pay) {
        this.directorID = directorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.movieID = movieID;
        this.role = role;
        this.pay = pay;
    }

    // Getters and Setters
    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }
}
