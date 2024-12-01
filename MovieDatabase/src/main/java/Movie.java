import java.math.BigDecimal;
import java.util.Date;

public record Movie(int movieID, String title, Date releaseDate, String synopsis, BigDecimal rating, int length,
                    String category) {
    // Constructor

    // Setters (if needed)
}
