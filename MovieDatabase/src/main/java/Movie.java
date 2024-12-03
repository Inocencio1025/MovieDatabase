import java.util.List;

public class Movie {
    private int movieID;
    private String title;
    private String releaseDate;
    private String synopsis;
    private String rating;
    private int length;
    private String category;

    // Using List to store multiple names, roles, and pay for each category
    private List<String> actors;
    private List<String> actresses;
    private List<String> directors;
    private List<String> producers;
    private List<String> writers;
    private List<String> actorRoles;
    private List<String> actressRoles;
    private List<String> directorRoles;
    private List<String> writerRoles;
    private List<String> producerRoles;
    private List<String> actorPay;
    private List<String> actressPay;
    private List<String> directorPay;
    private List<String> writerPay;
    private List<String> producerPay;


    // Constructor
    public Movie(int movieID, String title, String releaseDate, String synopsis, String rating, int length, String category,
                 List<String> actors, List<String> actresses, List<String> directors, List<String> producers, List<String> writers,
                 List<String> actorRoles, List<String> actressRoles, List<String> directorRoles, List<String> writerRoles, List<String> producerRoles,
                 List<String> actorPay, List<String> actressPay, List<String> directorPay, List<String> writerPay, List<String> producerPay) {


        this.movieID = movieID;
        this.title = title;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.rating = rating;
        this.length = length;
        this.category = category;
        this.actors = actors;
        this.actresses = actresses;
        this.directors = directors;
        this.producers = producers;
        this.writers = writers;
        this.actorRoles = actorRoles;
        this.actressRoles = actressRoles;
        this.directorRoles = directorRoles;
        this.writerRoles = writerRoles;
        this.producerRoles = producerRoles;
        this.actorPay = actorPay;
        this.actressPay = actressPay;
        this.directorPay = directorPay;
        this.writerPay = writerPay;
        this.producerPay = producerPay;
    }

    // Getters and Setters for the new fields (List types)
    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getActresses() {
        return actresses;
    }

    public void setActresses(List<String> actresses) {
        this.actresses = actresses;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getActorRoles() {
        return actorRoles;
    }

    public void setActorRoles(List<String> actorRoles) {
        this.actorRoles = actorRoles;
    }

    public List<String> getDirectorRoles() {
        return directorRoles;
    }

    public void setDirectorRoles(List<String> directorRoles) {
        this.directorRoles = directorRoles;
    }

    public List<String> getWriterRoles() {
        return writerRoles;
    }

    public void setWriterRoles(List<String> writerRoles) {
        this.writerRoles = writerRoles;
    }

    public List<String> getProducerRoles() {
        return producerRoles;
    }

    public void setProducerRoles(List<String> producerRoles) {
        this.producerRoles = producerRoles;
    }

    public List<String> getActorPay() {
        return actorPay;
    }

    public void setActorPay(List<String> actorPay) {
        this.actorPay = actorPay;
    }

    public List<String> getDirectorPay() {
        return directorPay;
    }

    public void setDirectorPay(List<String> directorPay) {
        this.directorPay = directorPay;
    }

    public List<String> getWriterPay() {
        return writerPay;
    }

    public void setWriterPay(List<String> writerPay) {
        this.writerPay = writerPay;
    }

    public List<String> getProducerPay() {
        return producerPay;
    }

    public void setProducerPay(List<String> producerPay) {
        this.producerPay = producerPay;
    }

    // Other existing getters and setters
    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLength() {return length;}

    public void setLength(int length) {
        this.length = length;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getActressPay() {
        return actressPay;
    }

    public void setActressPay(List<String> actressPay) {
        this.actressPay = actressPay;
    }

    public List<String> getActressRoles() {
        return actressRoles;
    }

    public void setActressRoles(List<String> actressRoles) {
        this.actressRoles = actressRoles;
    }
}
