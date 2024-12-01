import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener // This annotation automatically registers the listener with the web application
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialize the database when the web application starts
        try {
            DatabaseConnection.initializeDatabase();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Database initialized on application startup.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Optional: Cleanup when the web application shuts down
    }
}
