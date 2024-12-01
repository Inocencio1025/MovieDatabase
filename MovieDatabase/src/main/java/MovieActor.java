import java.math.BigDecimal;

public class MovieActor {

    private int actorID;
    private String firstName;
    private String lastName;
    private String title;
    private int movieID;
    private String role;
    private BigDecimal pay;

    // Constructor
    public MovieActor(int actorID, String firstName, String lastName, String title, int movieID, String role, BigDecimal pay) {
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.movieID = movieID;
        this.role = role;
        this.pay = pay;
    }

    // Getters and Setters
    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
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
